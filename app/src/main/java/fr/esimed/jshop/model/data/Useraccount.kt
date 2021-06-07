package fr.esimed.jshop.model.data

import java.io.Serializable
import java.util.*

class Useraccount (var id:Integer, val display_name : String, var login : String, val challenge : String,
                   var blocked : Boolean, var validate : Boolean, var key : String, var date_expire_key : Date, var date_created : Date
) : Serializable {
    override fun toString(): String {
        return "$display_name - $login"
    }
}