package com.example.fooddash.repository

import com.example.fooddash.db.entity.Product
import com.example.fooddash.tools.Utils.CATEGORY_TITLE_DRINKS
import com.example.fooddash.tools.Utils.CATEGORY_TITLE_MAIN_DISHES
import com.example.fooddash.tools.Utils.CATEGORY_TITLE_SALADS
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

object CustomRepository {

    private lateinit var database: DatabaseReference

    fun getProductsByCategoryDrinks(): MutableList<Product> {
        database = Firebase.database.reference
        val listValues: MutableList<Product> = mutableListOf()
        database.child(CATEGORY_TITLE_DRINKS).orderByChild("fullName")
            .addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    for (productSnapshot in snapshot.children) {
                        val item = productSnapshot.getValue<Product>()
                        item?.let {
                            it.uid = productSnapshot.key
                            listValues.add(it)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Getting Post failed, log a message
                    println("onCancelled: ${error.toException()}")
                }

            })
        return listValues
    }

    fun getProductsByCategoryMainDishes(): MutableList<Product> {
        database = Firebase.database.reference
        val listValues: MutableList<Product> = mutableListOf()
        database.child(CATEGORY_TITLE_MAIN_DISHES).orderByChild("fullName")
            .addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    for (productSnapshot in snapshot.children) {
                        val item = productSnapshot.getValue<Product>()
                        item?.let {
                            it.uid = productSnapshot.key
                            listValues.add(it)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Getting Post failed, log a message
                    println("onCancelled: ${error.toException()}")
                }

            })
        return listValues
    }

    fun getProductsByCategorySalads(): MutableList<Product> {
        database = Firebase.database.reference
        val listValues: MutableList<Product> = mutableListOf()
        database.child(CATEGORY_TITLE_SALADS).orderByChild("fullName")
            .addValueEventListener(object : ValueEventListener {

                override fun onDataChange(snapshot: DataSnapshot) {
                    for (productSnapshot in snapshot.children) {
                        val item = productSnapshot.getValue<Product>()
                        item?.let {
                            it.uid = productSnapshot.key
                            listValues.add(it)
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Getting Post failed, log a message
                    println("onCancelled: ${error.toException()}")
                }

            })
        return listValues
    }

}