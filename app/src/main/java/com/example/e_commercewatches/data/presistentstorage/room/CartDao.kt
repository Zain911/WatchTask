package com.example.e_commercewatches.data.presistentstorage.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.e_commercewatches.data.entity.watche.Watches


@Dao
interface CartDao {
    @Insert(onConflict = REPLACE)
    fun addToCart(watch: Watches)

    @Query("Select * From Watches")
    fun getCartProducts(): LiveData<List<Watches>>

    @Delete
    fun deleteItem(watch: Watches)

    @Update
    fun updateItem(watch: Watches)

    @Query("SELECT COUNT(id) FROM Watches")
    fun getCartItemsCount(): LiveData<Int>

    @Query("DELETE FROM Watches")
    fun clearCart()

    @Query("DELETE FROM Watches")
    fun deleteAllData()


}