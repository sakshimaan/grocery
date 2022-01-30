package com.store.groceries
import com.store.groceries.organizations.model.Organization
import com.store.groceries.organizations.repository.OrganizationRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component


@SpringBootApplication
class GroceryApplication

fun main(args: Array<String>) {
	runApplication<GroceryApplication>(*args)
	println("!!!!!SpringBoot Kotlin RESTFUL Web Services CRUD example !!!!!")
}
@Component
class Migrating(val organization: OrganizationRepository){
	@EventListener
	fun saving(event: ContextRefreshedEvent?){
		println("Event started ${event.toString()}")
		organization.save(Organization("1","Amazon","14035f67-9804-448c-a73c-bf68514d491a"))
		println("Event ended ${event.toString()}")
	}
}
