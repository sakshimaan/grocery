package com.store.groceries.items.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern

@Document("groceries") // is used to select collection name in MongoDB
data class Item(
    @Id
    var id:String?,

    //@Pattern(regexp = "[A-Za-z]{8}",message="length must be <= 8 and only alphabets are allowed")
    @field:NotBlank
    var name:String,

    @Pattern(regexp = "^[0-9]{2}", message = "Quantity should be < 100 and  only digits are allowed")
    var quantity:String,

    @Pattern(regexp = "^[a-zA-Z0-9]{10}", message ="length should be <= 10")
    var category:String
)
