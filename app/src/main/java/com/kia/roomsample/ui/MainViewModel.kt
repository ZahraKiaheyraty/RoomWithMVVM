package com.kia.roomsample.ui

import androidx.lifecycle.*
import androidx.room.Delete
import com.kia.roomsample.data.db.Entity
import com.kia.roomsample.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(var rep: Repository) : ViewModel() {






    val date = rep.getDetailsFromDbInRepository()

    var getDetails = MutableStateFlow<CollectDataBase>(CollectDataBase.Empty)
    var collectDetails: StateFlow<CollectDataBase> = getDetails

    fun insertToDb(e: Entity) {
        viewModelScope.launch(Dispatchers.IO) {
            rep.insertToDbInRepository(e)
        }
    }

    fun deleteItemDb(e: Entity){
        viewModelScope.launch(Dispatchers.IO) {

            rep.deleteDetailsFromDbInRepository(e)

        }
    }


    fun getDetails() {

        viewModelScope.launch(Dispatchers.IO) {
            getDetails.value = CollectDataBase.GetDetails(date)
        }


    }


    sealed class CollectDataBase() {
        object Empty : CollectDataBase()
        class GetDetails(var listStatus: Flow<List<Entity>>) : CollectDataBase()
    }


}





