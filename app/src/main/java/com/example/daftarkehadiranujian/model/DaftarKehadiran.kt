package com.example.daftarkehadiranujian.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DaftarKehadiran(
    @PrimaryKey val id: String,
    val nrp: String,
    val nama: String,
    val kelas: String,
    val kodemk: String,
)