package com.andre.guryanov.testgame.engine.animModels

import com.andre.guryanov.testgame.R

object Mario {

    fun default() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m00,
            R.drawable.m01
        )
    }

    fun attack() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m10,
            R.drawable.m11,
            R.drawable.m12,
        )
    }

    fun defense() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m30,
            R.drawable.m31,
            R.drawable.m32,
            R.drawable.m33,
            R.drawable.m34,
        )
    }

    fun damage() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m20,
            R.drawable.m21,
            R.drawable.m22,
        )
    }

    fun win() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m50,
            R.drawable.m51,
            R.drawable.m52,
            R.drawable.m53,
            R.drawable.m54,
            R.drawable.m55,
            R.drawable.m52,
        )
    }

    fun winLoop() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m53,
            R.drawable.m54,
            R.drawable.m55,
            R.drawable.m52,
        )
    }

    fun lose() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m60,
            R.drawable.m61,
            R.drawable.m62,
            R.drawable.m63,
            R.drawable.m64,
            R.drawable.m65,
        )
    }


    fun appearance() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m70,
            R.drawable.m71,
            R.drawable.m72,
            R.drawable.m73,
            R.drawable.m74,
            R.drawable.m75,
            R.drawable.m76,
        )
    }

    fun heal() : ArrayList<Int> {
        return arrayListOf(
            R.drawable.m40,
            R.drawable.m41,
            R.drawable.m42,
            R.drawable.m43,
            R.drawable.m44,
        )
    }
}