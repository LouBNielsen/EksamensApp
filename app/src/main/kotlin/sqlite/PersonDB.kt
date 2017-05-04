package sqlite

import org.jetbrains.anko.db.select

class PersonDB(
        val DBCtrl : DBController = DBController.instance
){
/*
    fun requestPersonByMinAge(age: Int) = DBCtrl.use{
        val request = "${PersonTable.age} >= ?"
        select(PersonTable.name)
                .whereSimple(request, age.toString())
                .parseList{ Person(HashMap(it)) }
    }

    fun savePerson(person: Person) = DBCtrl.use {
        insert(PersonTable.name, *person.map.toVarargArray())
    }
*/
}