package com.store.groceries.items.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.store.groceries.organizations.model.Organization
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

@Document("groceries") // is used to select collection name in MongoDB
data class Item(
    @Id
    @JsonIgnore
    var id:String?,

    //@Pattern(regexp = "[A-Za-z]{8}",message="length must be <= 8 and only alphabets are allowed")
    @field:NotBlank
    var name:String,

   // @field:Pattern(regexp = "^\\d+\$", message = "Only digits are allowed in Quantity")
    var quantity:String,

   // @field:Pattern(regexp = "^[a-zA-Z0-9]{10}", message ="length should be <= 10")
    var category:String,

    @JsonIgnore
    var orgId:String?,

    @Transient
    var organization: Organization?

//    @DBRef(lazy = true)
//    var organizations:List<Organization>
)
