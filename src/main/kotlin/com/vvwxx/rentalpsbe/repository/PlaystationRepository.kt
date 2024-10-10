package com.vvwxx.rentalpsbe.repository

import com.vvwxx.rentalpsbe.entity.PlaystationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface PlaystationRepository: JpaRepository<PlaystationEntity, String> {

    fun existsByPsId(psId: String): Boolean
}