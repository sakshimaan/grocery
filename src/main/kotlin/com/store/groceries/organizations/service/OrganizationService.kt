package com.store.groceries.organizations.service
import com.store.groceries.organizations.model.Organization

interface OrganizationService {
    fun getAll():List<Organization>
    fun create(organization: Organization):Organization
    //fun getByName(orgName:String): Item
}