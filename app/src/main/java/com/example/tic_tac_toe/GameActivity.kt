package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tic_tac_toe.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {


    private lateinit var binding: ActivityGameBinding
    var red: Int = R.drawable.red
    var yellow: Int = R.drawable.yellow
    var hod: Boolean = false
    val winTitle = "ВЫ́ИГРЫШ"
    val loseTitle = "НИЧЬЯ"
    var list: ArrayList<Position>? = ArrayList()
    private var selectedColor: Int = 0
    var matrix = arrayOf( //   1=x || 2= o
        arrayOf(0, 0, 0),  //a1,a2,a3
        arrayOf(0, 0, 0),  //b1,b2,b3
        arrayOf(0, 0, 0)   //c1,c2,c3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        binding = ActivityGameBinding.inflate(layoutInflater)


        val name1 = intent.extras?.get("name1")
        val name2 = intent.extras?.get("name2")

        binding.play1Text.text = name1.toString()
        binding.play2Text.text = name2.toString()

        list?.add(Position(0, 1, 1))
        list?.add(Position(1, 2, 1))
        list?.add(Position(2, 3, 1))
        list?.add(Position(3, 1, 2))
        list?.add(Position(4, 3, 2))
        list?.add(Position(5, 3, 2))
        list?.add(Position(6, 1, 3))
        list?.add(Position(7, 2, 3))
        list?.add(Position(8, 3, 3))

        binding.one.setOnClickListener {

            if (!list!!.get(0).isClicked) {
//                Log.i("myTag"," ${matrix[0][0]}")
                if (!hod) {
                    matrix[0][0] = yellow
//                selectedColor =1
                    list!!.get(0).image = yellow
                    binding.one.setImageResource(list!!.get(0).image)
                    hod = true
                } else {
//                selectedColor = 2
                    list!!.get(0).image = red
                    matrix[0][0] = red
                    binding.one.setImageResource(list!!.get(0).image)
                    hod = false
                }
                list!!.get(0).isClicked = true
            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }

            game()

        }

        binding.two.setOnClickListener {
            if (!list!!.get(1).isClicked) {
                if (!hod) {
//                selectedColor =1
                    matrix[0][1] = yellow
                    list!!.get(1).image = yellow
                    binding.two.setImageResource(list!!.get(1).image)
                    hod = true
                } else {
                    matrix[0][1] = red
                    list!!.get(1).image = red
                    binding.two.setImageResource(list!!.get(1).image)
                    hod = false
                }
                list!!.get(1).isClicked = true
            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }

            game()
        }

        binding.three.setOnClickListener {

            if (!list!!.get(2).isClicked) {
                if (!hod) {
//                selectedColor =1
                    matrix[0][2] = yellow
                    list!!.get(2).image = yellow
                    binding.three.setImageResource(yellow)
                    hod = true
                } else {
//                selectedColor = 2
                    matrix[0][2] = red
                    list!!.get(2).image = red
                    binding.three.setImageResource(red)
                    hod = false
                }
                list!!.get(2).isClicked = true
            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }

            game()
        }

        binding.four.setOnClickListener {
            if (!list!!.get(3).isClicked) {
                if (!hod) {
                    matrix[1][0] = yellow
                    binding.four.setImageResource(yellow)
                    hod = true
                } else {
                    matrix[1][0] = red
                    binding.four.setImageResource(red)
                    hod = false
                }
                list!!.get(3).isClicked = true
            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }

            game()
        }

        binding.five.setOnClickListener {
            if (!list!!.get(4).isClicked) {
                if (!hod) {
                    matrix[1][1] = yellow
                    binding.five.setImageResource(yellow)
                    hod = true
                } else {
                    matrix[1][1] = red
                    binding.five.setImageResource(red)
                    hod = false
                }
                list!!.get(4).isClicked = true

            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }

            game()


        }

        binding.six.setOnClickListener {
            if (!list!!.get(5).isClicked) {
                if (!hod) {
                    binding.six.setImageResource(yellow)
                    hod = true
                    matrix[1][2] = yellow
                } else {
                    matrix[1][2] = red
                    binding.six.setImageResource(red)
                    hod = false
                }
                list!!.get(5).isClicked = true
            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }
            game()

        }
        binding.seven.setOnClickListener {

            if (!list!!.get(6).isClicked) {
                if (!hod) {
                    matrix[2][0] = yellow
                    binding.seven.setImageResource(yellow)
                    hod = true
                } else {
                    matrix[2][0] = red
                    binding.seven.setImageResource(red)
                    hod = false
                }
                list!!.get(6).isClicked = true
            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }
            game()
        }

        binding.eight.setOnClickListener {
            if (!list!!.get(7).isClicked) {
                if (!hod) {
                    matrix[2][1] = yellow
                    binding.eight.setImageResource(yellow)
                    hod = true
                } else {
                    matrix[2][1] = red
                    binding.eight.setImageResource(red)
                    hod = false
                }

                list!!.get(7).isClicked = true
            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }
            game()

        }

        binding.nine.setOnClickListener {
            if (!list!!.get(8).isClicked) {
                if (!hod) {
                    matrix[2][2] = yellow
                    binding.nine.setImageResource(yellow)
                    hod = true
                } else {
                    matrix[2][2] = red
                    binding.nine.setImageResource(red)
                    hod = false
                }
                list!!.get(8).isClicked = true
            } else {
                Toast.makeText(this, "поля занято", Toast.LENGTH_SHORT).show()
            }
            game()
        }

        binding.refresh.setOnClickListener {
            for (o in list!!) {
                o.isClicked = false
            }
            binding.one.setImageResource(0)
            binding.two.setImageResource(0)
            binding.three.setImageResource(0)
            binding.four.setImageResource(0)
            binding.five.setImageResource(0)
            binding.six.setImageResource(0)
            binding.seven.setImageResource(0)
            binding.eight.setImageResource(0)
            binding.nine.setImageResource(0)
            hod = false
            for (o in matrix) {

            }
            Toast.makeText(this, "играем заново", Toast.LENGTH_SHORT).show()

        }




        setContentView(binding.root)
    }

    private fun resetBoard() {
        for (o in list!!) {
            o.isClicked = false
        }

        matrix = arrayOf( //   1=x || 2= o
            arrayOf(0, 0, 0),  //a1,a2,a3
            arrayOf(0, 0, 0),  //b1,b2,b3
            arrayOf(0, 0, 0)   //c1,c2,c3
        )

//        for (j in matrix.count()){
//            for (i in j){
//                matrix[j][i]=0
//            }
//        }

        binding.one.setImageResource(0)
        binding.two.setImageResource(0)
        binding.three.setImageResource(0)
        binding.four.setImageResource(0)
        binding.five.setImageResource(0)
        binding.six.setImageResource(0)
        binding.seven.setImageResource(0)
        binding.eight.setImageResource(0)
        binding.nine.setImageResource(0)
        hod = false
        Toast.makeText(this, "играем заново", Toast.LENGTH_SHORT).show()
    }

    private fun alert(title: String, result: String, unresult: String) {

        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(title)
                .setMessage("Выиграл: $result\n\nПроиграл: $unresult")
            setPositiveButton("reset") { dialog, which ->
                resetBoard()
            }
//            setNegativeButton("cancel") { dialog, which ->
//                dialog.dismiss()
//            }
                .setCancelable(false).show()
        }


    }

    private fun alert2() {

        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(loseTitle)
//                .setMessage("Выиграл: $result\n\nПроиграл: $unresult")
            setPositiveButton("reset") { dialog, which ->
                resetBoard()
            }
//            setNegativeButton("cancel") { dialog, which ->
//                dialog.dismiss()
//            }
                .setCancelable(false).show()
        }


    }


    private fun game() {

        if (matrix[0][0] == red && matrix[0][1] == red && matrix[0][2] == red) {
            alert(winTitle, binding.play2Text.text as String, binding.play1Text.text as String)

        } else if (matrix[1][0] == red && matrix[1][1] == red && matrix[1][2] == red) {
            alert(winTitle, binding.play2Text.text as String, binding.play1Text.text as String)

        } else if (matrix[2][0] == red && matrix[2][1] == red && matrix[2][2] == red) {
            alert(winTitle, binding.play2Text.text as String, binding.play1Text.text as String)

        } else if (matrix[0][0] == red && matrix[1][0] == red && matrix[2][0] == red) {
            alert(winTitle, binding.play2Text.text as String, binding.play1Text.text as String)

        } else if (matrix[0][1] == red && matrix[1][1] == red && matrix[2][1] == red) {
            alert(winTitle, binding.play2Text.text as String, binding.play1Text.text as String)

        } else if (matrix[0][2] == red && matrix[1][2] == red && matrix[2][2] == red) {
            alert(winTitle, binding.play2Text.text as String, binding.play1Text.text as String)

        } else if (matrix[0][0] == red && matrix[1][1] == red && matrix[2][2] == red) {
            alert(winTitle, binding.play2Text.text as String, binding.play1Text.text as String)

        } else if (matrix[0][2] == red && matrix[1][1] == red && matrix[2][0] == red) {
            alert(winTitle, binding.play2Text.text as String, binding.play1Text.text as String)
        } else {

        }

        /////////////////////////////////////////////*/*/*/*/*////////////////////////////////
        if (matrix[0][0] == yellow && matrix[0][1] == yellow && matrix[0][2] == yellow) {
            alert(winTitle, binding.play1Text.text as String, binding.play2Text.text as String)

        } else if (matrix[1][0] == yellow && matrix[1][1] == yellow && matrix[1][2] == yellow) {
            alert(winTitle, binding.play1Text.text as String, binding.play2Text.text as String)
        }
        else if (matrix[2][0] == yellow && matrix[2][1] == yellow && matrix[2][2] == yellow) {
            alert(winTitle, binding.play1Text.text as String, binding.play2Text.text as String)
        }
        else if (matrix[0][0] == yellow && matrix[1][0] == yellow && matrix[2][0] == yellow) {
            alert(winTitle, binding.play1Text.text as String, binding.play2Text.text as String)
        }
        else if (matrix[0][1] == yellow && matrix[1][1] == yellow && matrix[2][1] == yellow) {
            alert(winTitle, binding.play1Text.text as String, binding.play2Text.text as String)
        }
        else if (matrix[0][2] == yellow && matrix[1][2] == yellow && matrix[2][2] == yellow) {
            alert(winTitle, binding.play1Text.text as String, binding.play2Text.text as String)
        }
        else if (matrix[0][0] == yellow && matrix[1][1] == yellow && matrix[2][2] == yellow) {
            alert(winTitle, binding.play1Text.text as String, binding.play2Text.text as String)
        }
        else if (matrix[0][2] == yellow && matrix[1][1] == yellow && matrix[2][0] == yellow) {
            alert(winTitle, binding.play1Text.text as String, binding.play2Text.text as String)
        } else {

        }
//        if (selectedColor == 2) {
//            Log.i("list","List Correct")
////            if (o.image == red) {
//                Log.i("MaList","list")
////                if(o.id == 1&& o.id ==2 && o.id ==3){
//                if (matrix[0][0] ==1 && matrix[0][1] == 1 && matrix[0][2] ==1) {
//                    Log.i("Matrix","matrix")
//                    binding.play1Text.text = "победа"
//                }
//
//        }

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

