package eu.kryl.edu.kotlin.tests.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull

/**
 * Bare CRUD repository - no extra logic.
 */
@Repository
interface BookRepository: CrudRepository<BookEntity, String>

@Entity
data class BookEntity(
    @Id
    val id: String,

    @NotNull
    val title: String,

    @NotNull
    val author: String,

    @NotNull
    val published: LocalDate

)