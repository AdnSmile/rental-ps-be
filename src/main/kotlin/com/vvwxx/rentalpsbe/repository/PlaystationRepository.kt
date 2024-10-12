package com.vvwxx.rentalpsbe.repository

import com.vvwxx.rentalpsbe.entity.PlaystationEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PlaystationRepository: JpaRepository<PlaystationEntity, String> {

    fun existsByPsId(psId: String): Boolean

    fun findByPsTypeOrderByCreatedAt(psType: String, pageable: Pageable): Page<PlaystationEntity>

    fun findByPsClassOrderByCreatedAt(psClass: String, pageable: Pageable): Page<PlaystationEntity>
}