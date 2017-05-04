package sqlite

/**
 * Created by LouiseB on 29-04-2017.
 */

import java.io.Serializable

data class Contacts(
        var firstName: String,
        var number: Int
) : Serializable

object ContactsTable {
    val name = "contacts"
    val firstName = "firstName"
    val number = "number"
}