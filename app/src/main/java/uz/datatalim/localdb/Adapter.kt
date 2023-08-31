package uz.datatalim.localdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.datatalim.localdb.model.UsersModel

class Adapter :RecyclerView.Adapter<Adapter.ViewHolder>(){

    val list:ArrayList<UsersModel>?=null
    fun submitList(list: ArrayList<UsersModel>){

        this.list?.clear()
        this.list?.addAll(list)

    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){

        val tvUsername:TextView=view.findViewById(R.id.tv_name)
        val tvPhone:TextView=view.findViewById(R.id.tv_phone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_imo,parent,false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.apply {

            tvUsername.text=list!![position].userName
            tvPhone.text= list[position].phonNumber

        }

    }

    override fun getItemCount(): Int {
        return list!!.size
    }

}