package com.example.e_commercewatches.data.presistentstorage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.e_commercewatches.data.entity.watche.Watches
import com.example.e_commercewatches.data.presistentstorage.room.CartDao

@Database(entities = [Watches::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}