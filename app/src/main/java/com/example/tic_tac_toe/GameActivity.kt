package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tic_tac_toe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {


    private lateinit var binding: ActivityGameBinding
    var red: Int = R.drawable.red
    var yellow: Int = R.drawable.yellow
    var hod: Boolean = false
    var list: ArrayList<Position>? = ArrayList()
    private var selectedColor: Int = 0
    val matrix = arrayOf( //   1=x || 2= o
        arrayOf(0, 0, 0),  //a1,a2,a3
        arrayOf(0, 0, 0),  //b1,b2,b3
        arrayOf(0, 0, 0)   //c1,c2,c3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        binding = ActivityGameBinding.inflate(layoutInflater)

        list?.add(Position(1, 1, 1))
        list?.add(Position(2, 2, 1))
        list?.add(Position(3, 3, 1))


//            list?.get(0)!!.image = 1
//            list?.get(1)!!.image = 1
//            list?.get(2)!!.image = 1




        val numbers = intArrayOf(

        )

        binding.one.setOnClickListener {
//            list?.get(0)!!.isClicked = truem
            matrix!![0][0] = 1
            if (!hod) {
                list!!.get(0).image = yellow
                binding.one.setImageResource(list!!.get(0).image)
                hod = true
            } else {
                list!!.get(0).image = red
                binding.one.setImageResource(list!!.get(0).image)
                hod = false
            }


        }

        binding.two.setOnClickListener {
            matrix!![1][0] = 1

            if (!hod) {
                list!!.get(1).image = yellow
                binding.two.setImageResource(yellow)
                hod = true
            } else {
                list!!.get(1).image = red
                binding.two.setImageResource(red)
                hod = false
            }


        }

        binding.three.setOnClickListener {
            matrix!![2][0] = 1
            if (!hod) {
                list!!.get(2).image = yellow
                binding.three.setImageResource(yellow)
                hod = true
            } else {
                list!!.get(2).image = red
                binding.three.setImageResource(red)
                hod = false
            }

        }

        binding.four.setOnClickListener {

            if (!hod) {
                binding.four.setImageResource(yellow)
                hod = true
            } else {
                binding.four.setImageResource(red)
                hod = false
            }

        }

        binding.five.setOnClickListener {

            if (!hod) {
                binding.five.setImageResource(yellow)
                hod = true
            } else {
                binding.five.setImageResource(red)
                hod = false
            }

        }

        binding.six.setOnClickListener {

            if (!hod) {
                binding.six.setImageResource(yellow)
                hod = true
            } else {
                binding.six.setImageResource(red)
                hod = false
            }

        }
        binding.seven.setOnClickListener {

            if (!hod) {
                binding.seven.setImageResource(yellow)
                hod = true
            } else {
                binding.seven.setImageResource(red)
                hod = false
            }

        }

        binding.eight.setOnClickListener {

            if (!hod) {
                binding.eight.setImageResource(yellow)
                hod = true
            } else {
                binding.eight.setImageResource(red)
                hod = false
            }

        }

        binding.nine.setOnClickListener {

            if (!hod) {
                binding.nine.setImageResource(yellow)
                hod = true
            } else {
                binding.nine.setImageResource(red)
                hod = false
            }

        }





        game()

//        list?.add(Position(0,0,0))
//        for (o in list!!) {
//            if (o.id == 1 && o.id == 2 && o.id == 3)
//                binding.play1Text.setText("победа")
//        }


//        fun game(): Unit? {
//
//            for (o in list!!) {
//                if (o.id == 1 && o.id == 2 && o.id == 3) {
//                    binding.play1Text.text = "победа"
//                } else {
//                    binding.play1Text.text = "непобеда"
//                }
//            }
//            return null
//
//        }


        setContentView(binding.root)
    }

    private fun game() {

        for (o in list!!) {
            if (o.image == red) {
                if (matrix!![0][0] == 1 && matrix!![1][0] == 1 && matrix!![2][0] == 1) {
                    binding.play1Text.text = "победа"
                }
            } else {
                binding.play1Text.text = "непобеда"

            }
        }

//            if (o.id == 1 && o.image  && o.id == 2 && o.id == 3) {
//                binding.play1Text.text = "победа"
//            } else {
//            }
    }
}

//    private  fun itog(position: Position): String{
//
////        return when (selectedColor) {
////            1 -> {
////                "победа"
////            }
////            2 -> {
////                "победа"
////            }
////            3 -> {
////                "победа"
////            }
////
////            else -> {
////                "победа"
////            }
////        }
//
//
//        if (position.id ==1 && position.id == 2 && position.id == 3){
//            binding.play1Text.text = "победа"
//        }
//        for (o in list!!) {
//            if (o.id == 1 && o.id == 2 && o.id == 3) {
//            } else if (o.id == 4 && o.id == 5 && o.id == 6) {
//
//            } else if (o.id == 7 && o.id == 8 && o.id == 8) {
//
//            } else if (o.id == 1 && o.id == 5 && o.id == 9) {
//
//            } else if (o.id == 3 && o.id == 5 && o.id == 7) {
//
//            } else if (o.id == 1 && o.id == 4 && o.id == 7) {
//
//            } else if (o.id == 2 && o.id == 5 && o.id == 8)  {
//
//            }else if (o.id == 3 && o.id == 6 && o.id == 9){
//
//            }
//        }
//        return ""
//    }

