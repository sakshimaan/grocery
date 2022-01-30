package com.store.groceries.items.repository

import com.store.groceries.items.model.Item
import org.springframework.data.mongodb.repository.MongoRepository

interface ItemRepository:MongoRepository<Item,String>{
}