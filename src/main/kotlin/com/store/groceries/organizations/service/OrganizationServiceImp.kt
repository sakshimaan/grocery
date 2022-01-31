package com.store.groceries.organizations.service
import com.store.groceries.organizations.model.Organization
import com.store.groceries.organizations.repository.OrganizationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrganizationServiceImp(private var repository: OrganizationRepository):OrganizationService {

    override fun create(organization: Organization): Organization {
        organization.orgId = UUID.randomUUID().toString()
       return repository.save(organization)
    }

    override fun getAll(): List<Organization> {
        return repository.findAll()
    }

//    override fun getAllDetails(): Any {
//        return repository.getDetails()
//    }
}