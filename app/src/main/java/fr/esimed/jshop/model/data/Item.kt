package fr.esimed.jshop.model.data

import java.io.Serializable

data class Item(var id:Integer, val label : String, var quantity : String, val checked : Boolean, var id_list : Integer) :
    Serializable {
    override fun toString(): String {
        return "$label - $quantity"
    }
}