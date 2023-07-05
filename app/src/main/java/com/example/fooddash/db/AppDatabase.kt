package com.example.fooddash.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    //abstract fun productDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "fooddash.db"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)
                return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}