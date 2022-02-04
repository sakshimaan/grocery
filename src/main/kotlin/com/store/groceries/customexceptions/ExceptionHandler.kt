package com.store.groceries.customexceptions

import com.store.groceries.items.controller.ItemControllerExceptions
import com.store.groceries.items.service.ItemServiceExceptions
import com.store.groceries.organizations.controller.OrgControllerExceptions
import com.store.groceries.organizations.service.OrgServiceExceptions
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.lang.RuntimeException

@ControllerAdvice
class ExceptionHandler{

    @ExceptionHandler
    fun handleOrgService(ex: OrgServiceExceptions):ResponseEntity<ErrorResponse>{
        var errorOrgSer = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,System.currentTimeMillis())
        return ResponseEntity(errorOrgSer,HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleOrgController(ex: OrgControllerExceptions):ResponseEntity<ErrorResponse>{
        var errorOrgCon = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,System.currentTimeMillis())
        return ResponseEntity(errorOrgCon,HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleItemService(ex: ItemServiceExceptions, req:WebRequest):ResponseEntity<ErrorResponse>{
        var errorItemSer = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,System.currentTimeMillis())
        return ResponseEntity(errorItemSer,HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleItemController(ex: ItemControllerExceptions, req:WebRequest):ResponseEntity<ErrorResponse>{
        var errorItemCon = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,System.currentTimeMillis())
        return ResponseEntity(errorItemCon,HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler
    fun runTime(ex: RuntimeException):ResponseEntity<ErrorResponse>{
        var error = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,System.currentTimeMillis())
        return ResponseEntity(error,HttpStatus.NOT_FOUND)
    }
}