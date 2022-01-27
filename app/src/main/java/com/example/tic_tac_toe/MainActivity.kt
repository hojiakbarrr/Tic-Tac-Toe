package com.example.tic_tac_toe

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.tic_tac_toe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var startNewGameButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.ticTac.setOnClickListener {
            binding.player1.visibility  = View.VISIBLE
            binding.player2.visibility  = View.VISIBLE
            binding.startNewGameButton.visibility  = View.VISIBLE
            binding.image1.visibility  = View.VISIBLE
            binding.image2.visibility  = View.VISIBLE
        }

        val name1 = binding.player1.text
        val name2 = binding.player2.text

        binding.startNewGameButton.setOnClickListener {
            val intent = Intent(MainActivity@this, GameActivity::class.java)
            intent.putExtra("name1", name1 )
            intent.putExtra("name2", name2 )
            startActivity(intent)
        }




        setContentView(binding.root)
    }
}