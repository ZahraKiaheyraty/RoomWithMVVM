package com.kia.roomsample.data.repository

import com.kia.roomsample.data.db.Entity
import com.kia.roomsample.data.source.Local
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(var local: Local) {

    suspend fun insertToDbInRepository(e: Entity) {
        local.insertToDb(e)
    }

    suspend fun deleteDetailsFromDbInRepository(e: Entity) {
        local.deleteItemDb(e)
    }

    fun getDetailsFromDbInRepository(): Flow<List<Entity>> {
        return local.getDetailsFromDb()
    }
}