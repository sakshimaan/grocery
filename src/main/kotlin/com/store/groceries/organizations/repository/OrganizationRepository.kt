package com.store.groceries.organizations.repository

import com.store.groceries.organizations.model.Organization
import org.springframework.data.mongodb.repository.MongoRepository

interface OrganizationRepository : MongoRepository<Organization,String>
