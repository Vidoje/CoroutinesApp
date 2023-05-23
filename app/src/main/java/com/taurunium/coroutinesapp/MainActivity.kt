package com.taurunium.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.taurunium.coroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.countBtn.setOnClickListener{
            binding.counterText.text = counter++.toString()
        }

        binding.downloadBtn.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                downloadBigFileFromNet()
            }
        }
    }

    private suspend fun downloadBigFileFromNet() {
        for(i in 1..100000){
//            Log.i("TAGY", "Downloading $i in ${Thread.currentThread().name}")

            //switching between background and main thread
            withContext(Dispatchers.Main){
                binding.text2.text =  "Downloading $i in ${Thread.currentThread().name}"
            }
        }
    }
}