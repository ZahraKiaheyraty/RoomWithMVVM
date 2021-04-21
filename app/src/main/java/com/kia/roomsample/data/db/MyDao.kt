package com.kia.roomsample.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(e: Entity)


    @Delete
    suspend fun deleteDetails(e: Entity)


    @Query("SELECT * FROM entity")
    fun getCheckStatusList(): Flow<List<Entity>>
}