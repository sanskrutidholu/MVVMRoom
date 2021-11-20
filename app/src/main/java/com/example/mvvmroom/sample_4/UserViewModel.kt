package com.example.mvvmroom.sample_4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    val userMutableLiveData: MutableLiveData<List<User>> = MutableLiveData()

    fun getData()
    {
        val response=userRepository.getUserData()
        userMutableLiveData.value=response
    }
}