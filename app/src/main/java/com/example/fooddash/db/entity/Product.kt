package com.example.fooddash.db.entity

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Product(
    var uid: String? = null,
    val fullName: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val category: Int = -1,
    val ranking: Double = 0.0,
    val pictureUrl: String? = null
)