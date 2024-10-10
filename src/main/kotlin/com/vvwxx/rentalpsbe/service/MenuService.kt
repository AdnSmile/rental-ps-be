package com.vvwxx.rentalpsbe.service

import com.vvwxx.rentalpsbe.dto.request.ReqList
import com.vvwxx.rentalpsbe.dto.request.ReqMenu
import com.vvwxx.rentalpsbe.dto.response.ResMenu

interface MenuService {

    fun save(req: ReqMenu): ResMenu

    fun update(id: Int, req: ReqMenu): ResMenu

    fun get(id: Int): ResMenu

    fun delete(id: Int)

    fun list(req: ReqList): List<ResMenu>
}