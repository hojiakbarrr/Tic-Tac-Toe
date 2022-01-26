package com.example.tic_tac_toe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.tic_tac_toe.Nolik.Companion.NOUGHT
import com.example.tic_tac_toe.databinding.ActivityNolikBinding

class Nolik : AppCompatActivity() {

    enum class Turn{

        NOUCHT,
        CROSS
    }

    private var firstTurn = Turn.CROSS
    private var currentTurn = Turn.CROSS
    private var boardList = mutableListOf<Button>()

    private var crossesScore = 0
    private var noughtsScore = 0

    private lateinit var binding: ActivityNolikBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNolikBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBoard()
    }

    private fun initBoard() {
        boardList.add(binding.a1)
        boardList.add(binding.a2)
        boardList.add(binding.a3)
        boardList.add(binding.b1)
        boardList.add(binding.b2)
        boardList.add(binding.b3)
        boardList.add(binding.c1)
        boardList.add(binding.c2)
        boardList.add(binding.c3)
    }

    fun boardTapped(view: android.view.View) {
        if (view !is Button)
            return
        addBoard(view)

        if (checkForVictory(NOUGHT)){
            result("Noughts Win")
            noughtsScore++
        }

        if (checkForVictory(CROSS)){
            result("CROSS Win")
            crossesScore++
        }

        if (fullBoard()){
            result("Draw")
        }
        
    }

    private fun checkForVictory(s: String): Boolean {

        //////////////horizontal Victory
        if (match(binding.a1,s) && match(binding.a2,s) && match(binding.a3,s))
            return true

        if (match(binding.b1,s) && match(binding.b2,s) && match(binding.b3,s))
            return true

        if (match(binding.c1,s) && match(binding.c2,s) && match(binding.c3,s))
            return true

        //////////////vertical Victory
        if (match(binding.a1,s) && match(binding.b1,s) && match(binding.c1,s))
            return true

        if (match(binding.a2,s) && match(binding.b2,s) && match(binding.c2,s))
            return true

        if (match(binding.a3,s) && match(binding.b3,s) && match(binding.c3,s))
            return true

        //////////////diagonal Victory
        if (match(binding.a1,s) && match(binding.b2,s) && match(binding.c3,s))
            return true

        if (match(binding.a3,s) && match(binding.b2,s) && match(binding.c1,s))
            return true

            return false
    }

    private fun match(button: Button, symbol : String): Boolean = button.text == symbol

    private fun result(title: String) {

        val message = "\nNoughts $noughtsScore\n\nCrosses $crossesScore"

        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("Reset"){
                _,_ -> resetBoard()
            }.setCancelable(false).show()
    }

    private fun resetBoard() {

        for (button in boardList){
            button.text = ""
        }
        if (firstTurn == Turn.NOUCHT)
            firstTurn = Turn.CROSS
        else if (firstTurn == Turn.CROSS)
            firstTurn = Turn.NOUCHT

        currentTurn = firstTurn
        setTurnLabel()
    }

    private fun fullBoard(): Boolean {

        for (button in boardList){
            if (button.text == "")
                return false
        }
        return true
    }

    private fun addBoard(button: Button) {
        if (button.text != "")
            return
        if (currentTurn == Turn.NOUCHT){
            button.text = NOUGHT
            currentTurn = Turn.CROSS
        } else if(currentTurn  == Turn.CROSS){
            button.text = CROSS
            currentTurn = Turn.NOUCHT
        }

        setTurnLabel()
    }

    private fun setTurnLabel() {
        var turnText = ""
        if (currentTurn == Turn.CROSS)
            turnText = "Turn $CROSS"
        else if(currentTurn == Turn.NOUCHT)
            turnText = "Turn $NOUGHT"

        binding.turnTV.text = turnText
    }

    companion object{
        const val NOUGHT = "O"
        const val CROSS = "X"
    }

}