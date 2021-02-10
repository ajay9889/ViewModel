package com.asystechs.viewmodel.jitpack

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {

    // to encapsulate data object to access by other class
    private var mutableLiveData = MutableLiveData<Int>();

    val getFinalData : LiveData<Int>
    get() = mutableLiveData

    init {
        mutableLiveData.value = startingTotal
    }

    fun setTotal(input:Int){
        mutableLiveData.value=  mutableLiveData.value?.plus(input);
    }
}