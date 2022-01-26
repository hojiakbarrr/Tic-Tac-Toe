package com.example.tic_tac_toe

import java.io.Serializable

class Position(

    var id: Int = 0,
    var column: Int = 0,
    var row: Int = 0,
    var isClicked: Boolean = false


    ) : Serializable{
    var image: Int = 0
}