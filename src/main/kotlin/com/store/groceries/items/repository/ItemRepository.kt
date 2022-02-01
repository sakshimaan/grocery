package com.store.groceries.items.repository

import com.store.groceries.items.model.Item
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.repository.query.Param

interface ItemRepository:MongoRepository<Item,String>{

    fun findByName(@Param("name") name: String?): Item?

    fun findByOrgId(orgId : String):List<Item>

//    fun findByOrgName(orgName: String):List<Item> {
//
//    }
}