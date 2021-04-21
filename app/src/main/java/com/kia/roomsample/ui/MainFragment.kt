package com.kia.roomsample.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.kia.roomsample.R
import com.kia.roomsample.data.db.Entity
import com.kia.roomsample.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main), Adapter.CallBackAdapter {
    private val viewModel: MainViewModel by viewModels()
    private val scopeRequest = CoroutineScope(Dispatchers.Main)
    var status = 0

    @Inject
    @Named("b")
    lateinit var t: String


    lateinit var binding: FragmentMainBinding
    lateinit var adapter: Adapter
    lateinit var myData:ArrayList<Entity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMainBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)


        Log.e("TAG", "onViewCreated ")



        collectDetails()
        viewModel.getDetails()




        binding.insert.setOnClickListener {


            lifecycleScope.launch {

                insert()

            }


        }



    }

    private fun insert() {
        viewModel.insertToDb(Entity(binding.editInsert.text.toString(),binding.editFamilyname.text.toString()))
        viewModel.getDetails()


    }

    private fun collectDetails() {
        scopeRequest.launch {
            viewModel.collectDetails.collect {
                when (it) {
                    is MainViewModel.CollectDataBase.GetDetails -> {
                        it.listStatus.collect {list->

                          setUpRecyclerView(list)

                        }
                    }
                    is MainViewModel.CollectDataBase.Empty -> Unit
                }
            }
        }
    }



    private fun setUpRecyclerView(item:List<Entity>){
        adapter = Adapter(item,this)
        binding.apply {
            mainRecyclerView.adapter = adapter
        }
    }

    override fun sendData(view: ImageView,e: Entity) {


       view.setOnClickListener {
           viewModel.deleteItemDb(e)
           viewModel.getDetails()
       }
    }


}
