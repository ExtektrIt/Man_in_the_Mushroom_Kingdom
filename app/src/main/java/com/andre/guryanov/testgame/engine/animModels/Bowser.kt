package com.andre.guryanov.testgame.engine.animModels

import com.andre.guryanov.testgame.R

object Bowser {

    fun default() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.b00,
            R.drawable.b01,
        )
    }

    fun attack() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.b10,
            R.drawable.b11,
            R.drawable.b12,
            R.drawable.b13,
        )
    }

    fun defense() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.b30,
            R.drawable.b31,
            R.drawable.b32,
            R.drawable.b33,
            R.drawable.b34,
        )
    }

    fun damage() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.b20,
            R.drawable.b21,
            R.drawable.b22,
            R.drawable.b23,
        )
    }

    fun win() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.b40,
            R.drawable.b41,
            R.drawable.b42,
        )
    }

    fun winLoop() : ArrayList<Int> {
        return arrayListOf(

        )
    }

    fun lose() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.b50,
            R.drawable.b51,
            R.drawable.b52,
            R.drawable.b53,
            R.drawable.b54,
            R.drawable.b55,
            R.drawable.b56,
            R.drawable.b57,
            R.drawable.b58,
            R.drawable.b59,
        )
    }

    fun loseLoop() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.b58,
            R.drawable.b59,
        )
    }


    fun attack2() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.b10_0,
            R.drawable.b10_1,
            R.drawable.b10_2,
            R.drawable.b10_3,
        )
    }
}