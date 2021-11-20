package com.example.mvvmroom.sample_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroom.R

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var userAdapter: UserAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.s4_activity_main)

        val userRepository=UserRepository()
        val userViewModelFactory=UserViewModelFactory(userRepository)
        userViewModel= ViewModelProvider(this,userViewModelFactory)[UserViewModel::class.java]
        userViewModel.getData()
        userViewModel.userMutableLiveData.observe(this, Observer {
            userAdapter.setUserData(it as ArrayList<User>)
        })
        intiRecyclerView()
    }

    private fun intiRecyclerView() {
        recyclerView=findViewById(R.id.recyclerView)
        userAdapter= UserAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter=userAdapter
        }
    }
}