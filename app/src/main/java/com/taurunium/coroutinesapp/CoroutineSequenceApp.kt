package com.taurunium.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutineSequenceApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_sequence_app)

        CoroutineScope(Dispatchers.IO).launch {
            val one = doSomethingUseful1()
            val two = doSomethingUseful2()

            val result = one + two
            Log.d("TAGY", "onCreate: "+result)
        }

    }
    suspend fun doSomethingUseful1(): Int{
        delay(5000)
        Log.d("TAGY", "doSomethingUseful1 done: ")
        return 11
    }

    suspend fun doSomethingUseful2(): Int{
        delay(7000)
        Log.d("TAGY", "doSomethingUseful2 done: ")
        return 8
    }
}