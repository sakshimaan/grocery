package com.store.groceries.items.controller

import com.store.groceries.items.model.Item
import com.store.groceries.items.service.ItemService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import javax.validation.Valid

@RestController
//@Validated
@RequestMapping("/item")
@Qualifier("groceryItemController")
class ItemController(private val itemService: ItemService){

    //ResponseEntity is used in controller methods to modify response with optional headers and status code
    @GetMapping("/all")
    fun getAllItems(): ResponseEntity<List<Item>> = ResponseEntity.ok(itemService.getAll())?:throw ResponseStatusException(HttpStatus.NOT_FOUND,"No item exist")

    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id:String):ResponseEntity<Item> {
        try {
            return ResponseEntity.ok(itemService.getOne(id))
        } catch (e:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,"Item not found")
        }
    }

//    @GetMapping("/details")
//    fun getAll():ResponseEntity<List<Item>> = ResponseEntity.ok(itemService.getAllDetails())

    @GetMapping
    fun getByName(@RequestParam("name") name:String):ResponseEntity<Item>? = ResponseEntity.ok(itemService.getByName(name))

    @PostMapping
    fun saveOne(@RequestBody @Valid item: Item):ResponseEntity<Item> {
        try {
            return ResponseEntity.ok(itemService.createOne(item))
        }catch (e:Exception){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,"Invalid Input")
        }
    }

    @PutMapping("/{id}")
    fun update(@RequestBody newItem : Item, @PathVariable("id") id:String ):ResponseEntity<Item> = ResponseEntity.ok(itemService.update(newItem,id))

    @PatchMapping("/{id}")
    fun partialUp(@RequestBody item: Item, @PathVariable("id") id:String):ResponseEntity<Item> = ResponseEntity.ok(itemService.partialUpdate(item,id))

    @DeleteMapping
    fun deleteAll(items:List<Item>):ResponseEntity<Unit> = ResponseEntity.ok(itemService.deleteAll(items))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String):ResponseEntity<Unit> = ResponseEntity.ok(itemService.deleteOne(id))

}
