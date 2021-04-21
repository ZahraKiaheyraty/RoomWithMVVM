package com.kia.roomsample.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class MyDataBase : RoomDatabase() {
    abstract fun getDao(): MyDao


}