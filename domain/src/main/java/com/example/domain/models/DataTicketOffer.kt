package com.example.domain.models

data class DataTicketOffer(
    val id: Int,
    val title: String,
    val time_range: List<String>,
    val price: DataPrice,
    val town:String
){
    fun priceValue():String{
        return price.value.toString()
    }
}