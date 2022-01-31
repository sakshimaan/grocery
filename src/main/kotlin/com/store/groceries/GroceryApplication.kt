package com.store.groceries
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class GroceryApplication

fun main(args: Array<String>) {
	runApplication<GroceryApplication>(*args)
	println("!!!!!SpringBoot Kotlin RESTFUL Web Services CRUD example !!!!!")
}