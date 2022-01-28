package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.tic_tac_toe.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding : ActivityMain2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)


        binding.editMatText.doOnTextChanged { text, start, before, count ->
            if(text!!.length < 4){
                binding.layText.error = "No more"
            }else if (text.length > 4){
                binding.layText.error = null
            }
        }




        setContentView(binding.root)
    }
}