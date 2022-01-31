package com.store.groceries.items.service
import com.store.groceries.items.model.Item

interface ItemService{
    fun getOne(id:String): Item
    fun getAll():List<Item>
    fun createOne(item: Item): Item
    fun createAll(items:List<Item>):List<Item>
    fun update(newItem: Item, id:String): Item
    fun partialUpdate(item: Item, id: String): Item
    fun deleteOne(id:String)
    fun deleteAll(items: List<Item>)
    fun getByName(name:String):Item?
    //fun getAllDetails():List<Item>
}