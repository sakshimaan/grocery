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
import java.time.ZonedDateTime

@ControllerAdvice
class ExceptionHandler{

    @ExceptionHandler
    fun handleOrgService(ex: OrgServiceExceptions):ResponseEntity<ErrorResponse>{
        val errorOrgSer = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,ZonedDateTime.now().toLocalDateTime())
        return ResponseEntity(errorOrgSer,HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleOrgController(ex: OrgControllerExceptions):ResponseEntity<ErrorResponse>{
        val errorOrgCon = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,ZonedDateTime.now().toLocalDateTime())
        return ResponseEntity(errorOrgCon,HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleItemService(ex: ItemServiceExceptions, req:WebRequest):ResponseEntity<ErrorResponse>{
        val errorItemSer = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,ZonedDateTime.now().toLocalDateTime())
        return ResponseEntity(errorItemSer,HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleItemController(ex: ItemControllerExceptions, req:WebRequest):ResponseEntity<ErrorResponse>{
        val errorItemCon = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,ZonedDateTime.now().toLocalDateTime())
        return ResponseEntity(errorItemCon,HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler
    fun runTime(ex: RuntimeException):ResponseEntity<ErrorResponse>{
        val error = ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.message,ZonedDateTime.now().toLocalDateTime())
        return ResponseEntity(error,HttpStatus.NOT_FOUND)
    }
}