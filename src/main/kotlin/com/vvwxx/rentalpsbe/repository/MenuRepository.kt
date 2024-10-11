package com.vvwxx.rentalpsbe.repository

import com.vvwxx.rentalpsbe.entity.MenuEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository: JpaRepository<MenuEntity, Int> {

    fun getMenuEntitiesByMenuType(menuType: String): List<MenuEntity>

    fun existsByMenuName(menuName: String): Boolean
}