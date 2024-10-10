package com.vvwxx.rentalpsbe.service.impl

import com.vvwxx.rentalpsbe.dto.request.ReqList
import com.vvwxx.rentalpsbe.dto.request.ReqMenu
import com.vvwxx.rentalpsbe.dto.response.ResMenu
import com.vvwxx.rentalpsbe.entity.MenuEntity
import com.vvwxx.rentalpsbe.exception.NotFoundException
import com.vvwxx.rentalpsbe.repository.MenuRepository
import com.vvwxx.rentalpsbe.service.MenuService
import com.vvwxx.rentalpsbe.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class MenuServiceImpl(
    val menuRepo: MenuRepository,
    val validationUtil: ValidationUtil
) : MenuService {

    override fun save(req: ReqMenu): ResMenu {

        validationUtil.validate(req)

        val menu = MenuEntity(
            menuName = req.menuName,
            menuType = req.menuType,
            price = req.price,
            stock = req.stock,
            createdAt = Date(),
            updatedAt = null,
        )

        menuRepo.save(menu)
        return convertMenuToResMenu(menu)
    }

    override fun update(id: Int, req: ReqMenu): ResMenu {

        val menu = findByIdCustome(id)

        validationUtil.validate(req)

        menu.apply {
            menuName = req.menuName
            menuType = req.menuType
            price = req.price
            stock = req.stock
            updatedAt = Date()
        }

        menuRepo.save(menu)
        return convertMenuToResMenu(menu)
    }

    override fun get(id: Int): ResMenu {

        val menu = findByIdCustome(id)
        return convertMenuToResMenu(menu)
    }

    override fun delete(id: Int) {

        val menu = findByIdCustome(id)
        menuRepo.delete(menu)
    }

    override fun list(req: ReqList): List<ResMenu> {

        val page = menuRepo.findAll(PageRequest.of(req.page, req.size))
        val menuList: List<MenuEntity> = page.get().collect(Collectors.toList())
        return menuList.map { convertMenuToResMenu(it) }
    }

    private fun findByIdCustome(id: Int): MenuEntity {
        return menuRepo.findByIdOrNull(id) ?: throw NotFoundException("Menu with $id is not found")
    }

    private fun convertMenuToResMenu(menu: MenuEntity): ResMenu {
        return ResMenu(
            menuId = menu.menuId,
            menuName = menu.menuName,
            menuType = menu.menuType,
            price = menu.price,
            stock = menu.stock,
            createdAt = menu.createdAt,
            updatedAt = menu.updatedAt,
        )
    }
}