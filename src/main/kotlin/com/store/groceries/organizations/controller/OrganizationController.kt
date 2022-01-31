package com.store.groceries.organizations.controller
import com.store.groceries.organizations.model.Organization
import com.store.groceries.organizations.service.OrganizationService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/organization")
@Qualifier("groceryOrganizationController")
class OrganizationController(private val organizationService: OrganizationService) {

    @GetMapping
    fun getAllOrg():ResponseEntity<List<Organization>> = ResponseEntity.ok(organizationService.getAll())

//    @GetMapping("/details")
//    fun getAllDetails():Any = ResponseEntity.ok(organizationService.getAllDetails())
//    @GetMapping
//    fun getById(@RequestParam orgName:Organization): Item = ResponseEntity.ok(organizationService.getByName(orgName))

    @PostMapping
    fun createOrg(@RequestBody organization:Organization):ResponseEntity<Organization> =
        ResponseEntity.ok(organizationService.create(organization))
}

