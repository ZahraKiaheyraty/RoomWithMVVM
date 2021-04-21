package com.kia.roomsample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.kia.roomsample.R
import com.kia.roomsample.data.db.Entity
import kotlinx.android.synthetic.main.custom_item.view.*


class Adapter(
    var item: List<Entity>, var data: CallBackAdapter
) : RecyclerView.Adapter<Adapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_item, parent, false)
        return TodoViewHolder(view)
    }


    override fun getItemCount(): Int = item.size
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.itemView.apply {

            txt_name_item.text = item[position].title
            txt_familyname_item.text=item[position].text
            data.sendData(clear,item[position])

        }
    }
    
    
    
    
    interface CallBackAdapter{
        fun sendData(view:ImageView,data: Entity)
    }


}
