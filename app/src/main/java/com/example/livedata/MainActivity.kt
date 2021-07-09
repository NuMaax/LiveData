/*
https://www.youtube.com/watch?v=ASWrCDBLfE4
*/
package com.example.livedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val myLiveData = MyLiveData()
    private lateinit var observer : Observer<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observer = Observer {
            binding.tvTextViewMain.text = it
        }

        binding.btnGo.setOnClickListener {
            myLiveData.setChangeLiveData(binding.etAnyValue.text.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        myLiveData.observe(this, observer)
    }

    override fun onStop() {
        super.onStop()
        myLiveData.removeObserver(observer)
    }
}
