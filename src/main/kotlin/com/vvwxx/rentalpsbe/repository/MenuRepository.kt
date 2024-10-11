package com.vvwxx.rentalpsbe.repository

import com.vvwxx.rentalpsbe.entity.MenuEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface MenuRepository: JpaRepository<MenuEntity, Int> {

    fun findByMenuType(menuType: String, pageable: Pageable): Page<MenuEntity>

    fun existsByMenuName(menuName: String): Boolean
}