package com.vvwxx.rentalpsbe.controller

import com.vvwxx.rentalpsbe.dto.request.ReqList
import com.vvwxx.rentalpsbe.dto.request.ReqMenu
import com.vvwxx.rentalpsbe.dto.response.BaseResponse
import com.vvwxx.rentalpsbe.exception.UnauthenticatedException
import com.vvwxx.rentalpsbe.service.MenuService
import com.vvwxx.rentalpsbe.util.JWTGenerator
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/api/menu")
class MenuController(
    private val menuService: MenuService
) {

    @GetMapping("/all")
    fun list(@RequestParam("page", defaultValue = "0") page: Int,
             @RequestParam("size", defaultValue = "10") size: Int,
             ) : ResponseEntity<Any> {

        return ResponseEntity.ok(
            BaseResponse(
                message = "Successfully get list of menu",
                status = "T",
                data = menuService.list(ReqList(size, page))
            )
        )
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Int) : ResponseEntity<Any> {

        return ResponseEntity.ok(
            BaseResponse(
                message = "Successfully get the menu with id $id",
                status = "T",
                data = menuService.get(id)
            )
        )
    }

    @PostMapping
    fun create(@RequestBody req: ReqMenu, @RequestHeader("token") token: String): ResponseEntity<Any> {

        val user = JWTGenerator().decodeJWT(token)
        val token = user["role"].toString()

        if (token != "Admin") {
            throw UnauthenticatedException("You don't have permission")
        }

        return ResponseEntity.ok(
            BaseResponse(
                message = "Successfully create a menu",
                status = "T",
                data = menuService.save(req)
            )
        )
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id: Int, @RequestBody req: ReqMenu, @RequestHeader("token") token: String ): ResponseEntity<Any> {

        val user = JWTGenerator().decodeJWT(token)
        val token = user["role"].toString()

        if (token != "Admin") {
            throw UnauthenticatedException("You don't have permission")
        }

        return ResponseEntity.ok(
            BaseResponse(
                message = "Successfully update a menu with id $id",
                status = "T",
                data = menuService.update(id, req)
            )
        )
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int, @RequestHeader("token") token: String): ResponseEntity<Any> {

        val user = JWTGenerator().decodeJWT(token)
        val token = user["role"].toString()

        if (token != "Admin") {
            throw UnauthenticatedException("You don't have permission")
        }

        return ResponseEntity.ok(
            BaseResponse(
                message = "Successfully delete a menu with id $id",
                status = "T",
                data = menuService.delete(id)
            )
        )
    }
}