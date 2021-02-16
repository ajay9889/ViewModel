package com.asystechs.viewmodel.jitpack

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.asystechs.viewmodel.UserDataManager
import com.asystechs.viewmodel.jitpack.databinding.FragmentHomeBinding
import kotlinx.coroutines.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding : FragmentHomeBinding;
    private lateinit var viewModelFactory: MainActivityViewModelFactory;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false )
        binding.button.setOnClickListener {
            val bundle: Bundle = bundleOf("user_input" to binding.editTextTextPersonName.text.toString())
            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment,bundle)
        }


        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)

//        viewModel .getUserList();
        viewModel.mUserMutableList.observe(viewLifecycleOwner, Observer {

            it.forEach {
                Log.d("USER: ", ""+it.name);
            }
        } )

        binding.countinCoroutines.setOnClickListener {

            // NORMAL COROUTINES
            /*logPrint();*/


            // ASYNC & AWAIT IN BACKGROUND THREAD TO RUNT HE TASK SEQUENTIAL

            /*CoroutineScope(Dispatchers.IO).launch{
                Log.d("THIS IS COROUTINES", "Starting calculations....")
                val start1 = getStock1();
                val start2 = getStock2();
                val total = start1 + start2;
                Log.d("THIS IS COROUTINES", "Total finished task: ${total}")
            }*/

            // ASYNC & AWAIT IN BACKGROUND THREAD TO RUN IN PARALLEL
            CoroutineScope(Dispatchers.IO).launch{
                Log.d("THIS IS COROUTINES", "Starting calculations....")
                val start1 = async { getStock1(); }
                val start2 = async {  getStock2();}
                val total = start1.await() + start2.await();
                Log.d("THIS IS COROUTINES", "Total finished task: ${total}")
            }


            // structured coroutines

            CoroutineScope(Dispatchers.Main).launch {
                // Unstructured coroutines:
                binding. labelTxt.text=UserDataManager()?.getUnStrcuturedTotalCount().toString()

                // structured coroutines
//                binding. labelTxt.text=UserDataManager()?.getTotalCount().toString()
            }

        }





        return binding.root
    }

    // log process
    fun logPrint(){
        for( i in 1..2000000){
          Log.d("THIS IS COROUTINES", "Index: ${i} , running in ${Thread().name}")
        }
    }

    suspend fun getStock1(): Int{

        delay(10000)
        Log.d("COROUTINES","Stock 1 return")

        return 1232
    }

    suspend fun getStock2(): Int{

        delay(8000)
        Log.d("COROUTINES","Stock 2 return")
        return 1232

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}