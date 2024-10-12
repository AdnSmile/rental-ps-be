package com.vvwxx.rentalpsbe.controller

import com.vvwxx.rentalpsbe.dto.request.ReqList
import com.vvwxx.rentalpsbe.dto.request.ReqPlaystation
import com.vvwxx.rentalpsbe.dto.request.ReqUpdatePlaystation
import com.vvwxx.rentalpsbe.dto.response.BaseResponse
import com.vvwxx.rentalpsbe.dto.response.PagingBaseResponse
import com.vvwxx.rentalpsbe.exception.UnauthenticatedException
import com.vvwxx.rentalpsbe.service.PlaystationService
import com.vvwxx.rentalpsbe.util.JWTGenerator
import com.vvwxx.rentalpsbe.util.Util
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/ps")
class PlaystationController(
    private val psService: PlaystationService
) {

    @PostMapping
    fun create(@RequestBody req: ReqPlaystation, @RequestHeader("token") token: String): ResponseEntity<Any> {

        val user = JWTGenerator().decodeJWT(token)
        val token = user["role"].toString()

        if (token != "Admin") {
            throw UnauthenticatedException("You don't have permission")
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(
            BaseResponse(
                message = "Successfully create new playstation room",
                status = "T",
                data = psService.save(req)
            )
        )
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: String, @RequestBody req: ReqUpdatePlaystation, @RequestHeader("token") token: String): ResponseEntity<Any> {

        val user = JWTGenerator().decodeJWT(token)
        val token = user["role"].toString()

        if (token != "Admin") {
            throw UnauthenticatedException("You don't have permission")
        }

        return ResponseEntity.status(HttpStatus.OK).body(
            BaseResponse(
                message = "Successfully updated playstation room with id ${id.uppercase()}",
                status = "T",
                data = psService.update(req, id)
            )
        )
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String, @RequestHeader("token") token: String): ResponseEntity<Any> {

        val user = JWTGenerator().decodeJWT(token)
        val token = user["role"].toString()

        if (token != "Admin") {
            throw UnauthenticatedException("You don't have permission")
        }

        return ResponseEntity.status(HttpStatus.OK).body(
            BaseResponse(
                message = "Successfully deleted playstation room with id ${id.uppercase()}",
                status = "T",
                data = psService.delete(id)
            )
        )
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: String) : ResponseEntity<Any> {

        return ResponseEntity.status(HttpStatus.OK).body(
            BaseResponse(
                message = "Successfully get list of playstation room by id ${id.uppercase()}",
                status = "T",
                data = psService.get(id)
            )
        )
    }

    @GetMapping("/all")
    fun list(@RequestParam("page", defaultValue = "0") page: Int,
             @RequestParam("size", defaultValue = "10") size: Int,
    ) : ResponseEntity<Any> {

        return ResponseEntity.status(HttpStatus.OK).body(
            PagingBaseResponse(
                message = "Successfully get list of playstation room",
                status = "T",
                page = if (page == 0) page+1 else page,
                size = size,
                data = psService.list(ReqList(size, Util.actualPageValue(page)))
            )
        )
    }

    @GetMapping("/type")
    fun listByType(@RequestParam("page", defaultValue = "0") page: Int,
                       @RequestParam("size", defaultValue = "10") size: Int,
                       @RequestParam("ps_type") type: String,
    ) : ResponseEntity<Any> {

        return ResponseEntity.status(HttpStatus.OK).body(
            PagingBaseResponse(
                message = "Successfully get list of playstation room by type",
                status = "T",
                page = if (page == 0) page+1 else page,
                size = size,
                data = psService.listByType(type, ReqList(size, Util.actualPageValue(page)))
            )
        )
    }

    @GetMapping("/class")
    fun listByClass(@RequestParam("page", defaultValue = "0") page: Int,
                       @RequestParam("size", defaultValue = "10") size: Int,
                       @RequestParam("ps_class") theClass: String,
    ) : ResponseEntity<Any> {

        return ResponseEntity.status(HttpStatus.OK).body(
            PagingBaseResponse(
                message = "Successfully get list of playstation room by class",
                status = "T",
                page = if (page == 0) page+1 else page,
                size = size,
                data = psService.listByClass(theClass, ReqList(size, Util.actualPageValue(page)))
            )
        )
    }
}