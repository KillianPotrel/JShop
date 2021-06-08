package fr.esimed.jshop.model.data

import java.io.Serializable

data class Item(val id:Int, var label : String, var quantity : String, var checked : Boolean, val id_list : Int) :
    Serializable {
    override fun toString(): String {
        return "$label - $quantity"
    }
}