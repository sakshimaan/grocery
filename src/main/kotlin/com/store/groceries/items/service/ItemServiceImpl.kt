package com.store.groceries.items.service
import com.store.groceries.items.model.Item
import com.store.groceries.items.repository.ItemRepository
import com.store.groceries.organizations.repository.OrganizationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ItemServiceImpl(private var repository: ItemRepository, private var orgRepository: OrganizationRepository): ItemService {

    override fun getOne(id: String): Item {
        return repository.findById(id).orElseThrow{RuntimeException("Item not found")}
    }
    override fun getAll(): List<Item>{
        return repository.findAll()
    }

    override fun createOne(item: Item): Item {
      item.id=UUID.randomUUID().toString()
        return repository.save(item)
    }

    override fun createAll(items: List<Item>): List<Item> {
        return repository.saveAll(items)
    }

    override fun update(newItem: Item, id: String): Item {
        val old = repository.findById(id).orElse(null)
        old.name = newItem.name
        old.quantity = newItem.quantity
        old.category = newItem.quantity
        return repository.save(newItem)
    }

    override fun partialUpdate(newItem: Item, id: String): Item {
        var old = repository.findById(id).orElse(null)
        //remain to implement
        old.name = newItem.name
        return repository.save(newItem)
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
        return item
    }

    override fun getAllDetails():List<Item> {
        var items = repository.findAll()
        items.forEach {
            it.organization = orgRepository.findById(it.orgId!!).get()
        }
        return items
    }

    override fun getByOrg(orgId: String): List<Item>{
        return repository.findByOrgId(orgId)
    }
}
