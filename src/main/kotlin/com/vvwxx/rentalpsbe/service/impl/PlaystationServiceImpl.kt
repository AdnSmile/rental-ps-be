package com.vvwxx.rentalpsbe.service.impl

import com.vvwxx.rentalpsbe.dto.request.ReqList
import com.vvwxx.rentalpsbe.dto.request.ReqPlaystation
import com.vvwxx.rentalpsbe.dto.request.ReqUpdatePlaystation
import com.vvwxx.rentalpsbe.dto.response.ResPlaystation
import com.vvwxx.rentalpsbe.entity.PlaystationEntity
import com.vvwxx.rentalpsbe.exception.DuplicateException
import com.vvwxx.rentalpsbe.exception.NotFoundException
import com.vvwxx.rentalpsbe.model.EPsClass
import com.vvwxx.rentalpsbe.model.EPsStatus
import com.vvwxx.rentalpsbe.repository.PlaystationRepository
import com.vvwxx.rentalpsbe.service.PlaystationService
import com.vvwxx.rentalpsbe.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class PlaystationServiceImpl (
    private val validationUtil: ValidationUtil,
    private val psRepo: PlaystationRepository
): PlaystationService {

    override fun save(req: ReqPlaystation): ResPlaystation {

        validationUtil.validate(req)
        val id = generateId(req.psId!!, req.psClass!!)

        if (psRepo.existsByPsId(id)) {
            throw DuplicateException("PS Room id: $id already exists.")
        }

        val ps = PlaystationEntity(
            psId = id,
            psClass = convertClassToEnum(req.psClass!!.lowercase()),
            psType = req.psType!!.uppercase(),
            status = convertStatusToEnum(req.status!!.lowercase()), // available, is use, maintenance, Reserved
            hourlyRate = req.hourlyRate,
            createdAt = Date(),
            updatedAt = null,
        )

        psRepo.save(ps)
        return convertPsToRes(ps)
    }

    override fun update(req: ReqUpdatePlaystation, psId: String): ResPlaystation {

        val ps = findByIdCustom(psId.uppercase())
        validationUtil.validate(req)

        ps.apply {
            psClass = convertClassToEnum(req.psClass!!.lowercase())
            psType = req.psType!!.uppercase()
            status = convertStatusToEnum(req.status!!.lowercase()) // available, is use, maintenance, Reserved
            hourlyRate = req.hourlyRate
            updatedAt = Date()
        }

        psRepo.save(ps)
        return convertPsToRes(ps)
    }

    override fun get(psId: String): ResPlaystation {

        val ps = findByIdCustom(psId.uppercase())
        return convertPsToRes(ps)
    }

    override fun delete(psId: String) {

        val ps = findByIdCustom(psId.uppercase())
        psRepo.delete(ps)
    }

    override fun list(req: ReqList): List<ResPlaystation> {

        val page = psRepo.findAll(PageRequest.of(req.page, req.size))
        val psList: List<PlaystationEntity> = page.get().collect(Collectors.toList())
        return psList.map { convertPsToRes(it) }
    }

    override fun listByClass(psClass: String, req: ReqList): List<ResPlaystation> {

        val page = psRepo.findByPsClassOrderByCreatedAt(psClass.uppercase(), PageRequest.of(req.page, req.size))
        val psList: List<PlaystationEntity> = page.get().collect(Collectors.toList())
        return psList.map { convertPsToRes(it) }
    }

    override fun listByType(psType: String, req: ReqList): List<ResPlaystation> {

        val page = psRepo.findByPsTypeOrderByCreatedAt(psType.uppercase(), PageRequest.of(req.page, req.size))
        val psList: List<PlaystationEntity> = page.get().collect(Collectors.toList())
        return psList.map { convertPsToRes(it) }
    }

    private fun findByIdCustom(id: String): PlaystationEntity {
        return psRepo.findByIdOrNull(id) ?: throw NotFoundException("Playstation with id $id not found")
    }

    private fun generateId(id: String, psClass: String): String {

        return when (psClass) {
            "vip" -> "VIP$id"
            else -> "GEN$id"
        }
    }

    private fun convertStatusToEnum(status: String): String {
        return when (status) {
            "available" -> EPsStatus.AVAILABLE.toString()
            "is use" -> EPsStatus.IS_USE.toString()
            "maintenance" -> EPsStatus.MAINTENANCE.toString()
            "reserved" -> EPsStatus.RESERVED.toString()
            else -> EPsStatus.AVAILABLE.toString()
        }
    }

    private fun convertClassToEnum(type: String): String {
        return when (type) {
            "general" -> EPsClass.GENERAL.toString()
            "vip" -> EPsClass.VIP.toString()
            else -> EPsClass.GENERAL.toString()
        }
    }

    private fun convertPsToRes(ps: PlaystationEntity): ResPlaystation {
        return ResPlaystation(
            psId = ps.psId,
            psClass = ps.psClass,
            psType = ps.psType,
            status = ps.status, // available, is use, maintenance, Reserved
            hourlyRate = ps.hourlyRate,
            createdAt = ps.createdAt,
            updatedAt = ps.updatedAt,
        )
    }
}