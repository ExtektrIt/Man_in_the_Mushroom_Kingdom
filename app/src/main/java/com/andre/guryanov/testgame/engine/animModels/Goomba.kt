package com.andre.guryanov.testgame.engine.animModels

import com.andre.guryanov.testgame.R

object Goomba {

    fun default() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.g00,
            R.drawable.g01,
        )
    }

    fun attack() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.g10,
            R.drawable.g11,
            R.drawable.g12,
        )
    }

    fun defense() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.g30,
            R.drawable.g31,
            R.drawable.g32,
            R.drawable.g33,
            R.drawable.g34,
            R.drawable.g35,
        )
    }

    fun damage() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.g20,
            R.drawable.g21,
        )
    }

    fun win() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.g40,
            R.drawable.g41,
            R.drawable.g42,
            R.drawable.g43,
            R.drawable.g44,
            R.drawable.g45,
            R.drawable.g46,
        )
    }

    fun winLoop() : ArrayList<Int> {
        return arrayListOf(

        )
    }

    fun lose() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.g50,
            R.drawable.g51,
            R.drawable.g52,
            R.drawable.g53,
            R.drawable.g54,
            R.drawable.g55,
            R.drawable.g56,
            R.drawable.g57,
            R.drawable.g58,
            R.drawable.g59,
        )
    }
}