package com.example.mvvmroom.sample_4

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroom.R

class UserAdapter(private val context: Context, private var userList:ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.s4_each_row,parent,false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user=userList[position]
        holder.name.text=user.name
    }

    override fun getItemCount(): Int= userList.size

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView =itemView.findViewById(R.id.name)

    }
    fun setUserData(userList: ArrayList<User>)
    {
        this.userList=userList

    }
}