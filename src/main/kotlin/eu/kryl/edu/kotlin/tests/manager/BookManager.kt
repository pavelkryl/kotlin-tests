package eu.kryl.edu.kotlin.tests.manager

import eu.kryl.edu.kotlin.tests.repository.BookEntity
import eu.kryl.edu.kotlin.tests.repository.BookRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import java.time.LocalDate
import java.util.UUID

/**
 *
 */
@Component
class BookManager(
    val bookRepository: BookRepository
) {

    fun getBookById(bookId: String): BookEntity =
        bookRepository.findById(bookId).orElseThrow { BookNotFoundException(bookId) }

    fun insertBook(title: String, author: String, published: LocalDate) =
        bookRepository.save(BookEntity(UUID.randomUUID().toString(), title, author ,published))

    fun getAllBooks(): Iterable<BookEntity> =
        bookRepository.findAll()

}

class BookNotFoundException(bookId: String): ResponseStatusException(HttpStatus.NOT_FOUND, "book $bookId cannot be found")