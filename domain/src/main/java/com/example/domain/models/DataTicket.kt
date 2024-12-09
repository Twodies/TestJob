package com.example.domain.models

data class DataTicket(
    val id: Int,
    val badge: String? = null,
    val price: DataPrice,
    val provider_name: String,
    val company: String,
    val departure: DataFlightDetails,
    val arrival: DataFlightDetails,
    val has_transfer: Boolean,
    val has_visa_transfer: Boolean,
    val luggage: DataLuggage,
    val hand_luggage: DataHandLuggage,
    val is_returnable: Boolean,
    val is_exchangable: Boolean
)