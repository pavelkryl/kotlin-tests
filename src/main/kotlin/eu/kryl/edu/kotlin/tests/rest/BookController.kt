package eu.kryl.edu.kotlin.tests.rest

import eu.kryl.edu.kotlin.tests.manager.BookManager
import eu.kryl.edu.kotlin.tests.repository.BookEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

/**
 *
 */
@RestController
class BookController(
    val manager: BookManager
) {

    @GetMapping("/book/{bookId}")
    fun getBookById(@PathVariable bookId: String): BookEntity =
        // simply delegate
        manager.getBookById(bookId)

    @GetMapping("/book")
    fun getAllBooks(): Iterable<BookEntity> =
        // simply delegate
        manager.getAllBooks()


    @PostMapping("/book")
    fun insertBook(@RequestBody request: InsertBookRequest) =
        manager.insertBook(request.title, request.author, request.published)

}

data class InsertBookRequest(
    val title: String,
    val author: String,
    val published: LocalDate
)