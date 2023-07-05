package com.example.fooddash.db.dao

import androidx.room.Dao

@Dao
interface ProductDao {

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(vararg products: Product)

    @Update
    fun updateProducts(vararg products: Product)

    @Delete
    fun delete(product: Product)

    @Query("SELECT * FROM product")
    fun getAllProducts(): List<Product>

    @Query("SELECT * FROM product WHERE category = :categoryId")
    fun getProductsByCategory(categoryId: Int): List<Product>*/

}