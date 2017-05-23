package sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase

import android.util.Log
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.db.*
import org.jetbrains.anko.debug


class DBController(var context: Context = App.instance) : ManagedSQLiteOpenHelper(context, DBController.DB_NAME, null, DBController.DB_VERSION), AnkoLogger {

    companion object {
        val DB_NAME = "VETDB"
        val DB_VERSION = 4
        val instance by lazy { DBController() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        Log.d("vetApp", "in oncreate")

        db.createTable(
                PersTable.name, true,
                PersTable.id to INTEGER + PRIMARY_KEY,
                PersTable.firstName to TEXT,
                PersTable.lastName to TEXT,
                PersTable.age to INTEGER,
                PersTable.email to TEXT,
                PersTable.number to INTEGER
        )
        db.createTable(
                PetsTable.name, true,
                PetsTable.id to INTEGER + PRIMARY_KEY,
                PetsTable.firstName to TEXT,
                PetsTable.type to TEXT
        )

        insertData(db)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        Log.d("vetApp", "in on upgrade")
        db.dropTable(PersTable.name)
        db.dropTable(PetsTable.name)
        if(oldVersion == 3)
        {
            db.dropTable("contacts")
        }
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    fun insertData(db: SQLiteDatabase) {
        Log.d("vetApp", "in insert data")

        db.insert(
                PersTable.name,
                PersTable.id to 1,
                PersTable.firstName to "Louise",
                PersTable.lastName to "Nielsen",
                PersTable.age to 21,
                PersTable.email to "louise@mail.dk",
                PersTable.number to 41100532
        )
        db.insert(
                PersTable.name,
                PersTable.id to 2,
                PersTable.firstName to "Emilie",
                PersTable.lastName to "Nielsen",
                PersTable.age to 22,
                PersTable.email to "emilie@mail.dk",
                PersTable.number to 26807741
        )
    }

    fun insertPerson(firstName: String, lastName: String, age: String, email: String, number: String){

        instance.use {
            insert(
                PersTable.name,
                PersTable.firstName to firstName,
                PersTable.lastName to lastName,
                PersTable.age to age,
                PersTable.email to email,
                PersTable.number to number
        ) }
    }


    fun insertPet(firstName: String, type: String){
        debug("in  insertPet")

        instance.use {
            insert(
                PetsTable.name,
                PetsTable.firstName to firstName,
                PetsTable.type to type
        ) }
    }

    fun insertPetFromSMS(firstName: String, type: String){
        instance.use {
            insert(
                    PetsTable.name,
                    PetsTable.firstName to firstName,
                    PetsTable.type to type
            ) }
    }

    fun listPeople() : List<Pers> {
        var person = listOf<Pers>()
        instance.use {
            person = select(PersTable.name).parseList(
                    rowParser {
                        id: Int, firstName: String, lastName: String, age: Int, email: String, number: Int ->
                        Pers(id, firstName, lastName, age, email, number)
                    })
        }
        Log.i("DBC", "People: ${person.size}")
        return person
    }
}

