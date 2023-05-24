package com.taurunium.coroutinesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class CoroutineSequenceApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_sequence_app)

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("TAGY", "app started: ")
            val one = async { doSomethingUseful1() }
            val two = async { doSomethingUseful2() }

            val result = one.await() + two.await()
            Log.d("TAGY", "onCreate: " + result)
        }

    }

    suspend fun doSomethingUseful1(): Int {
        delay(5000)
        Log.d("TAGY", "doSomethingUseful1 done: ")
        return 11
    }

    suspend fun doSomethingUseful2(): Int {
        delay(7000)
        Log.d("TAGY", "doSomethingUseful2 done: ")
        return 8
    }
}