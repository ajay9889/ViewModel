package com.asystechs.viewmodel.jitpack

import androidx.lifecycle.*
import com.asystechs.viewmodel.model.UserRepository
import com.asystechs.viewmodel.model.Users
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityViewModel(startingTotal : Int) : ViewModel() {
    val userRepository:UserRepository = UserRepository();
    // to encapsulate user list data object to access by other class
    public var mUserMutableList = liveData<List<Users>>(Dispatchers.IO) {

       val result = userRepository.getListOfUser();
        emit(result)

    }//MutableLiveData<List<Users>>();

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
    fun getUserList(){
        /*viewModelScope.launch {
            var result : List<Users>?=null;
            withContext(Dispatchers.IO){
                result=   userRepository.getListOfUser();
            }
            mUserMutableList.value=result!!;

        }*/
    }
}