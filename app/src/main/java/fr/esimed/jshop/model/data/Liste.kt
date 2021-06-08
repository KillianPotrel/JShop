package fr.esimed.jshop.model.data

import java.io.Serializable
import java.util.*

data class Liste (var id:Int, val shop : String, var date : Date, val archived : Boolean, var id_user : Int) :
    Serializable {
    override fun toString(): String {
        return "$shop - $date"
    }
}