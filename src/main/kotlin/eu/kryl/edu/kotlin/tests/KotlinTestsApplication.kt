package eu.kryl.edu.kotlin.tests

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinTestsApplication

fun main(args: Array<String>) {
    runApplication<KotlinTestsApplication>(*args)
}
