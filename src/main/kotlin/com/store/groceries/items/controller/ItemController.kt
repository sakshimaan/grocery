package com.store.groceries.items.controller
import com.store.groceries.items.model.Item
import com.store.groceries.items.service.ItemService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import kotlin.IllegalArgumentException

@RestController
@RequestMapping("/item")
@Qualifier("groceryItemController")
class ItemController(private val itemService: ItemService){

    //ResponseEntity is used in controller methods to modify response with optional headers and status code
    @GetMapping("/all")
    fun getAllItems(): ResponseEntity<List<Item>> {
        try{
            return ResponseEntity.ok(itemService.getAll())
        } catch (e: ItemControllerExceptions){
            throw ItemControllerExceptions("Not found")
        } catch (e:Exception){
            throw IllegalArgumentException("Item not found")
        }
    }

    @GetMapping("/{id}")
    fun getOne(@PathVariable("id") id:String):ResponseEntity<Item> {
        try {
            return ResponseEntity.ok(itemService.getOne(id))
        } catch (e: ItemControllerExceptions){
            throw ItemControllerExceptions("Not found")
        }catch (e:Exception){
            throw java.lang.IllegalArgumentException("Item not found")
        }
    }

    @GetMapping("/details")
    fun getAll():ResponseEntity<List<Item>> {
        try{
            return ResponseEntity.ok(itemService.getAllDetails())
        } catch (e: ItemControllerExceptions){
            throw ItemControllerExceptions("Not found")
        }catch (e:Exception){
            throw ItemControllerExceptions("Item not found")
        }
    }

    @GetMapping
    fun getByName(@RequestParam("name") name:String):ResponseEntity<Item>? {
        try{
            return ResponseEntity.ok(itemService.getByName(name))
        }catch (e: ItemControllerExceptions){
            throw ItemControllerExceptions("Not found")
        }catch (e:Exception){
            throw ItemControllerExceptions("Item not found")
        }
    }

    @GetMapping("/orgId")
    fun getByOrg(@RequestParam("orgId") orgId:String):ResponseEntity<List<Item>> {
        try {
            return ResponseEntity.ok(itemService.getByOrg(orgId))
        } catch (e: ItemControllerExceptions){
            throw ItemControllerExceptions("Not found")
        }catch (e:Exception){
            throw ItemControllerExceptions("Item not found")
        }
    }

    @PostMapping
    fun saveOne(@RequestBody @Valid item: Item):ResponseEntity<Item> {
        try {
            return ResponseEntity.ok(itemService.createOne(item))
        }catch (e: ItemControllerExceptions){
            throw ItemControllerExceptions("Please enter correct data")
        }catch (e:Exception){
            throw ItemControllerExceptions("Invalid Input")
        }
    }

    @PutMapping("/{id}")
    fun update(@RequestBody newItem : Item, @PathVariable("id") id:String ):ResponseEntity<Item> {
        try {
            return ResponseEntity.ok(itemService.update(newItem,id))
        }catch (e: ItemControllerExceptions){
            throw ItemControllerExceptions("Please enter correct data")
        }catch (e:Exception){
            throw ItemControllerExceptions("Invalid Input")
        }
    }

    @PatchMapping("/{id}")
    fun partialUp(@RequestBody item: Item, @PathVariable("id") id:String):ResponseEntity<Item> {
        try{
            return ResponseEntity.ok(itemService.partialUpdate(item,id))
        }catch (e: ItemControllerExceptions){
            throw ItemControllerExceptions("Please enter correct data")
        }catch (e:Exception){
            throw ItemControllerExceptions("Invalid Input")
        }
    }

    @DeleteMapping
    fun deleteAll(items:List<Item>):ResponseEntity<Unit> =  ResponseEntity.ok(itemService.deleteAll(items))

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: String):ResponseEntity<Unit> = ResponseEntity.ok(itemService.deleteOne(id))

}
