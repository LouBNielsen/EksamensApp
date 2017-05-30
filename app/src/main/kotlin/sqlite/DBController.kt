package sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.widget.Toast
import org.jetbrains.anko.db.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.debug
import org.jetbrains.anko.AnkoLogger



// C:\Users\LouiseB\AppData\Local\Android\sdk\platform-tools
// slet DB - adb shell
// data/data/sqlite.app/databases rm VETDB

class DBController(var context: Context = App.instance) : ManagedSQLiteOpenHelper(context, DBController.DB_NAME, null, DBController.DB_VERSION), AnkoLogger  {
    //ManagedSQLiteOpenHelper: helper class til database oprettelse

    // companion object: Kotlin har ikke statiske metoder.. løsning --> companion object

    lateinit var db: SQLiteDatabase

    companion object {
        val DB_NAME = "VETDB"
        val DB_VERSION = 5
        val instance by lazy { DBController() } //delegated property.. Instantieret ved første kald
    }

    override fun onCreate(db: SQLiteDatabase) { // oprettelse af database og tables første gang
    debug("in on create")
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

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) { //upgrader til ny schema version
        debug("in onUpgrade")
        db.dropTable(PersTable.name)
        db.dropTable(PetsTable.name)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) { // kan downgrades igen
        debug("in onDowngrade")
        db.dropTable(PersTable.name)
        db.dropTable(PetsTable.name)
        onCreate(db)
    }

    fun insertData(db: SQLiteDatabase) { //NOTE, INSTANCE.USE ELLER DB.INSERT??????
        debug("in insertData")

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
        debug("in insertPerson")

        instance.use { //brug DBController instans og indsæt person
            insert(
                PersTable.name,
                PersTable.firstName to firstName,
                PersTable.lastName to lastName,
                PersTable.age to age,
                PersTable.email to email,
                PersTable.number to number
        ) }
        context.toast("Person er registreret")
    }


    fun insertPet(firstName: String, type: String){
        debug("in insertPet")

        db = writableDatabase

        instance.use { //brug DBController instans og indsæt pet
            insert(
                PetsTable.name,
                PetsTable.firstName to firstName,
                PetsTable.type to type
        ) }
        context.toast("Pet er registreret")

    }

    fun insertPetFromSMS(pet : Pets){
        debug("in insertPet")

        db = writableDatabase

        instance.use { //brug DBController instans og indsæt pet
            insert(
                    PetsTable.name,
                    PetsTable.firstName to pet.firstName,
                    PetsTable.type to pet.type
            ) }
        context.toast("Pet er registreret")

    }


    fun getAdapterLocations(): List<Map<String, Any?>> {

        db = readableDatabase

        return db.select(PersTable.name).exec {
            parseList(
                    object : MapRowParser<Map<String, Any?>> {
                        override fun parseRow(columns: Map<String, Any?>): Map<String, Any?> {
                            return columns
                        }
                    })
        }
    }
/*
    fun listPeople() : List<Pers> {
        debug("in insertListPeople")

        var person = listOf<Pers>()
        instance.use {
            debug("in select personTable")

            person = select(PersTable.name).parseList(
                    rowParser {
                        id: Int, firstName: String, lastName: String, age: Int, email: String, number: Int ->
                        Pers(id, firstName, lastName, age, email, number)
                    })
        }
        return person
    }
    */
}

