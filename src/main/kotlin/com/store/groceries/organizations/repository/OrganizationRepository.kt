package com.store.groceries.organizations.repository

import com.store.groceries.organizations.model.Organization
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.query.Param

interface OrganizationRepository : MongoRepository<Organization,String>
