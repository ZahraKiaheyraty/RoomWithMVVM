package com.kia.roomsample.data.source

import com.kia.roomsample.data.db.Entity
import com.kia.roomsample.data.db.MyDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*

import javax.inject.Inject

class Local @Inject constructor( var db: MyDao) {






    suspend fun insertToDb(e: Entity){
        db.insert(e)
    }

    suspend fun deleteItemDb(e: Entity){
        db.deleteDetails(e)
    }




    fun getDetailsFromDb(): Flow<List<Entity>> {
        return db.getCheckStatusList()
    }

}