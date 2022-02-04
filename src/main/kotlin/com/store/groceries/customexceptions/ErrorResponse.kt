package com.store.groceries.customexceptions

class ErrorResponse(
    var status: Int? = null,
    var message: String? = null,
    var timeStamp : Long? = null
)