package com.example.daftarkehadiranujian.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.daftarkehadiranujian.model.DaftarKehadiran

@Database(entities = [DaftarKehadiran::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun DaftarKehadiranDao(): DaftarKehadiranDao
}