package com.store.groceries.organizations.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.Length
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.Size

@Document("organization")
data class Organization(
    @Id
    @JsonIgnore
    var orgId: String?,

    @field:Length(min = 2, max = 20, message = "Length should be between 2-20")
    var orgName:String,

    @field:Length(min = 2, max = 4, message = "Revenue should be between $1 - $999")
    var orgRevenue:String,

    @field:Length(min = 4, max = 4, message = "Year format should be YYYY")
    var orgYear:Int,

    @field:Size(min = 1, max = 10, message = "Ranking can be between 1-10 only.")
    var orgRanking:Int
    )