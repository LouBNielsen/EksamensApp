package sqlite

import java.io.Serializable

data class Pers( // data class: holder data.
        val id: Int, // var mutable, val immutable
        var firstName: String,
        var lastName: String,
        var age: Int,
        var email: String,
        var number: Int
) : Serializable // serializable - kan persisteres

object PersTable {
    val name = "pers"
    val id = "id"
    val firstName = "firstName"
    val lastName = "lastName"
    val age = "age"
    val email = "email"
    val number = "number"
}


