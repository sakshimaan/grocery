package com.store.groceries.organizations.service
import com.store.groceries.organizations.model.Organization

interface OrganizationService {
    fun getAllOrg():List<Organization>
    fun create(organization: Organization):Organization
}