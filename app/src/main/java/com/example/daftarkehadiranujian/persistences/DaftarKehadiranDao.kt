package com.example.daftarkehadiranujian.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.daftarkehadiranujian.model.DaftarKehadiran

@Dao
interface DaftarKehadiranDao {
    @Query("SELECT * FROM DaftarKehadiran")
    fun loadAll(): LiveData<List<DaftarKehadiran>>

    @Query("SELECT * FROM DaftarKehadiran WHERE id = :id")
    fun find(id: String): DaftarKehadiran?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: DaftarKehadiran)
    @Delete
    fun delete(item: DaftarKehadiran)
}