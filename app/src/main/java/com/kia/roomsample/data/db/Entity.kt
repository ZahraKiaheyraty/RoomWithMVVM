package com.kia.roomsample.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entity")
data class Entity(
    var title: String? = null,
    var text: String? = null,
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
)
