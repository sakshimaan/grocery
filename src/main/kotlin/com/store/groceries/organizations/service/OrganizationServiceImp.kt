package com.store.groceries.organizations.service
import com.store.groceries.organizations.model.Organization
import com.store.groceries.organizations.repository.OrganizationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrganizationServiceImp(private var repository: OrganizationRepository):OrganizationService {

    override fun create(organization: Organization): Organization {
        organization.orgId = UUID.randomUUID().toString()
        try {
            if(organization.orgName.isEmpty() || organization.orgName.isBlank()){
                throw OrgServiceExceptions("Organization name can not be null")
            }
            else if(!organization.orgRevenue.startsWith("$")){
                throw OrgServiceExceptions("Revenue should starts with \"$\" ")
            }

           return repository.save(organization)
        }catch (e:Exception){
            throw OrgServiceExceptions("Please provide the correct input")
        }
    }

    override fun getAllOrg(): List<Organization> {
        try {
            return repository.findAll()
        }catch (e:Exception){
            throw OrgServiceExceptions("Not found")
        }
    }

    override fun update(newOrg: Organization, id: String): Organization {
        var old = repository.findById(id).orElse(null)
        old.orgName = newOrg.orgName
        old.orgYear = newOrg.orgYear
        old.orgRevenue = newOrg.orgRevenue
        old.orgRanking = newOrg.orgRanking
        try{
            return repository.save(newOrg)
        } catch (e:Exception){
            throw OrgServiceExceptions("Invalid Request")
        }
    }

    override fun deleteOne(id: String) =  repository.deleteById(id)

}