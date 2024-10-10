package com.vvwxx.rentalpsbe.service

import com.vvwxx.rentalpsbe.dto.request.ReqList
import com.vvwxx.rentalpsbe.dto.request.ReqPlaystation
import com.vvwxx.rentalpsbe.dto.request.ReqUpdatePlaystation
import com.vvwxx.rentalpsbe.dto.response.ResPlaystation

interface PlaystationService {

    fun save(req: ReqPlaystation): ResPlaystation

    fun update(req: ReqUpdatePlaystation, psId: String): ResPlaystation

    fun get(psId: String): ResPlaystation

    fun delete(psId: String)

    fun list(req: ReqList): List<ResPlaystation>
}