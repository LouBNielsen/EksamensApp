package sqlite

import java.io.Serializable

data class Pers(
        val id: Int,
        var firstName: String,
        var lastName: String,
        var age: Int,
        var email: String,
        var number: Int
) : Serializable

object PersTable {
    val name = "pers"
    val id = "id"
    val firstName = "firstName"
    val lastName = "lastName"
    val age = "age"
    val email = "email"
    val number = "number"
}