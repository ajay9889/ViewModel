package com.asystechs.viewmodel.jitpack

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal : Int) : ViewModel() {
    var multableLiveData = MutableLiveData<Int>();
    init {
        multableLiveData.value = startingTotal
    }

    fun setTotal(input:Int){
        multableLiveData.value=  multableLiveData.value?.plus(input);
    }
}