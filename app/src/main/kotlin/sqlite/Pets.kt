package sqlite

/**
 * Created by LouiseB on 23-03-2017.
 */
import java.io.Serializable

data class Pets(
        val id: Int,
        var firstName: String,
        var type: String

) : Serializable

object PetsTable {
    val name = "pets"
    val id = "id"
    val firstName = "firstName"
    val type = "type"
}