package com.store.groceries.organizations.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.store.groceries.items.model.Item
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document("organization")
data class Organization(
    @Id
    @JsonIgnore
    var orgId: String?,

    var orgName:String,
    var orgRevenue:String,
    var orgYear:Int,
    var orgRanking:Int
    )