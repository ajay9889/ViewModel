package com.asystechs.viewmodel

import kotlinx.coroutines.*

class UserDataManager {
    var count : Int=0
    lateinit var deferred: Deferred<Int>;
    suspend fun getUnStrcuturedTotalCount(): Int{
        coroutineScope {
            launch (Dispatchers.IO){
                delay(3000)
                count  = 50;
            }

            /*deferred = async(Dispatchers.IO){
                delay(3000)
                count  = 70;
                return@async count;
            }*/
        }

        return count;
    }
    suspend fun getTotalCount(): Int{
        coroutineScope {
            launch (Dispatchers.IO){
                delay(3000)
                count  = 50;
            }

            deferred = async(Dispatchers.IO){
                delay(3000)
                count  = 70;
                return@async count;
            }
        }

        return count +deferred.await();
    }
}