package com.store.groceries.organizations.controller

import com.store.groceries.items.model.Item
import com.store.groceries.items.service.ItemService
import com.store.groceries.organizations.model.Organization
import com.store.groceries.organizations.service.OrganizationService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/organization")
@Qualifier("groceryOrganizationController")
class OrganizationController(private val organizationService: OrganizationService,private val itemSer: ItemService ) {

    @GetMapping
    fun getAllData():Any {
        //var item:ResponseEntity<List<Item>> = ResponseEntity.ok(itemSer.getAll())
        var org:ResponseEntity<List<Organization>> = ResponseEntity.ok(organizationService.getAll())
        return org
    }

    @PostMapping
    fun createOrg(@RequestBody organization:Organization):ResponseEntity<Organization> =
        ResponseEntity.ok(organizationService.create(organization))
}

