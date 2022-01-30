package com.store.groceries.organizations.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("organization")
data class Organization(
    @Id
    var orgId: String?,
    var name:String,
    var itemId:String
    )