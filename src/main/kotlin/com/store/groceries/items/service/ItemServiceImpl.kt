package com.store.groceries.items.service
import com.store.groceries.items.model.Item
import com.store.groceries.items.repository.ItemRepository
import com.store.groceries.organizations.repository.OrganizationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ItemServiceImpl(private var repository: ItemRepository, private var orgRepository: OrganizationRepository): ItemService {

    override fun getOne(id: String): Item {
        try{
            return repository.findById(id).orElseThrow{RuntimeException("Item not found")}
        } catch (e:Exception){
            throw ItemServiceExceptions("Item with id : $id not found in the database")
        }

    }
    override fun getAll(): List<Item>{
        try{
            return repository.findAll()
        } catch (e:Exception){
            throw ItemServiceExceptions("Invalid request")
        }
        }

    override fun createOne(item: Item): Item {
      item.id=UUID.randomUUID().toString()
        try{
            if(item.name.isEmpty() || item.name.isBlank()){
                throw ItemServiceExceptions("Item name can't be empty")
            }
        return repository.save(item)
    } catch (e:Exception){
        throw ItemServiceExceptions("Incorrect Input details")
    }
    }

    override fun createAll(items: List<Item>): List<Item> {
        try {
            return repository.saveAll(items)
        } catch (e: Exception) {
            throw ItemServiceExceptions("Incorrect Input details")
        }
    }

    override fun update(newItem: Item, id: String): Item {
        val old = repository.findById(id).orElseThrow { Exception("No item exist with this id") }
        old.name = newItem.name
        old.quantity = newItem.quantity
        old.category = newItem.quantity
        try{
            return repository.save(newItem)
        } catch (e:Exception){
            throw ItemServiceExceptions("Invalid Update Request")
        }
    }

    override fun partialUpdate(newItem: Item, id: String): Item {
        var old = repository.findById(id).orElseThrow{ Exception("No item exist with this id")}
        newItem.name?.let{
            old.name = newItem.name
        }
        newItem.quantity?.let {
            old.quantity = newItem.quantity
        }
        newItem.category.let {
            old.category = newItem.category
        }

        try{
            return repository.save(newItem)
        } catch (e:Exception){
            throw ItemServiceExceptions("Invalid Partial Update Request")
        }
    }

    override fun deleteOne(id: String) {
        return repository.deleteById(id)
    }

    override fun deleteAll(items: List<Item>) {
        return repository.deleteAll(items)
    }

    override fun getByName(name: String): Item? {
        var item = repository.findByName(name)
        item?.let {
            item.organization = orgRepository.findById(item.orgId!!).get()
        }
        try{
            return item
        }catch (e:Exception){
            throw ItemServiceExceptions("Invalid Request")
        }
    }

    override fun getAllDetails():List<Item> {
        var items = repository.findAll()
        items.forEach {
            it.organization = orgRepository.findById(it.orgId!!).get()
        }
        try{
            return items
        }catch (e:Exception){
            throw ItemServiceExceptions("Invalid Request")
        }
    }

    override fun getByOrg(orgId: String): List<Item>{
        try{
            return repository.findByOrgId(orgId)
        }catch (e:Exception){
            throw ItemServiceExceptions("Invalid Request")
        }
    }
}
