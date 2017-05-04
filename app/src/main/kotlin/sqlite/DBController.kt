package sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import android.util.Log
import org.jetbrains.anko.db.*
import sqlite.PetsTable.type
import org.jetbrains.anko.toast


class DBController(var context: Context = App.instance) : ManagedSQLiteOpenHelper(context, DBController.DB_NAME, null, DBController.DB_VERSION) {

    lateinit var db: SQLiteDatabase

    companion object {
        val DB_NAME = "TESTDB.db"
        val DB_VERSION = 1
        val instance by lazy { DBController() }
    }

    override fun onCreate(db: SQLiteDatabase) {
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    fun personQuery() {
        db = writableDatabase

        db.createTable(
                PersTable.name, true,
                PersTable.id to INTEGER + PRIMARY_KEY,
                PersTable.firstName to TEXT,
                PersTable.lastName to TEXT,
                PersTable.age to INTEGER,
                PersTable.email to TEXT
        )

        db.insert(
                PersTable.name,
                PersTable.id to 1,
                PersTable.firstName to "Kurt",
                PersTable.lastName to "Hansen",
                PersTable.age to 51,
                PersTable.email to "kurt@hansen.dk"
        )
        db.insert(
                PersTable.name,
                PersTable.id to 2,
                PersTable.firstName to "Sonja",
                PersTable.lastName to "Jensen",
                PersTable.age to 15,
                PersTable.email to "sonja@mail.dk"
        )
    }

    fun insertPerson(firstName: String, lastName: String, age: String, email: String){

        db = writableDatabase

        db.insert(
                PersTable.name,
                PersTable.firstName to firstName,
                PersTable.lastName to lastName,
                PersTable.age to age,
                PersTable.email to email
        )
    }

    fun petsQuery() {

        db = writableDatabase

        db.createTable(
                PetsTable.name, true,
                PetsTable.id to INTEGER + PRIMARY_KEY,
                PetsTable.firstName to TEXT,
                PetsTable.type to TEXT
        )
    }

    fun insertPet(firstName: String, type: String){

        db = writableDatabase

        db.insert(
                PetsTable.name,
                PetsTable.firstName to firstName,
                PetsTable.type to type
        )
    }


    fun contactsQuery() {

        db = writableDatabase

        db.createTable(
                ContactsTable.name, true,
                ContactsTable.firstName to TEXT + PRIMARY_KEY,
                ContactsTable.number to INTEGER
        )

        db.insert(
                ContactsTable.name,
                ContactsTable.firstName to "Louise",
                ContactsTable.number to 41100532
        )
    }

    fun getPets(): List<Map<String, Any?>> {
        db = readableDatabase
        println("getPets i db controller")

        return db.select("pets").exec() {
            parseList(
                    object : MapRowParser<Map<String, Any?>> {
                        override fun parseRow(columns: Map<String, Any?>): Map<String, Any?> {
                            return columns
                        }
                    })
        }

        db.close()
    }

}

