package com.asystechs.viewmodel.jitpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.asystechs.viewmodel.jitpack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainActivityViewModel::class.java)

        /**
         * View Model
         * *
        binding.resultTextView.text = viewModel.getTotal().toString()

        binding.insertButton.setOnClickListener {
            if(!TextUtils.isEmpty(binding.inputEditText.text.toString())) {
                viewModel.setTotal(binding.inputEditText.text.toString()?.toInt())
                binding.resultTextView.text = viewModel.getTotal()?.toString()
            }
        }

         */
        /*
        *Beuty of Live Data
        * */

        viewModel.multableLiveData.observe(this, Observer {
            binding.resultTextView.text =it.toString()
        })

        binding.insertButton.setOnClickListener {
            if(!(TextUtils.isEmpty(binding.inputEditText.text))){
                viewModel.setTotal(binding.inputEditText.text.toString().toInt());
            }
        }

    }
}
