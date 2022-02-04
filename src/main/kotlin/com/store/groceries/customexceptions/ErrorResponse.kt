package com.store.groceries.customexceptions

import java.time.LocalDateTime
import java.time.ZonedDateTime

class ErrorResponse(
    var status: Int? = null,
    var message: String? = null,
    var timeStamp : LocalDateTime? = null
)