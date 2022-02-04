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
    fun getAllOrg(): ResponseEntity<List<Organization>> {
        try {
            return ResponseEntity.ok(organizationService.getAllOrg())
        } catch (e: OrgControllerExceptions){
            throw OrgControllerExceptions("Organization list is empty")
        } catch (e:Exception){
            throw  OrgControllerExceptions("Invalid request")
        }
    }

    @PostMapping
    fun createOrg(@RequestBody organization: Organization): ResponseEntity<Organization> {
        try {
            return ResponseEntity.ok(organizationService.create(organization))
        } catch (e: OrgControllerExceptions) {
            throw OrgControllerExceptions("Please enter correct data")
        }
    }

    @PutMapping
    fun updateOrg(@RequestBody newOrg: Organization,@PathVariable("id") id:String): ResponseEntity<Organization> {
        try {
            return ResponseEntity.ok(organizationService.update(newOrg,id))
        } catch (e: OrgControllerExceptions){
            throw OrgControllerExceptions("Please enter correct data")
        } catch (e: Exception) {
            throw  OrgControllerExceptions("Invalid Input")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteOrg(@PathVariable("id") id:String):ResponseEntity<Unit> = ResponseEntity.ok(organizationService.deleteOne(id))

}