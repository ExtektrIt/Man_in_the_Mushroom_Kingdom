package com.andre.guryanov.testgame.engine.modelData

import com.andre.guryanov.testgame.R

class MarioData : ModelData() {

    override val sfxAttack: Int
        get() = R.raw.m_attack

    override val sfxDefense: Int
        get() = R.raw.mgb_defense

    override val sfxDamage: Int
        get() = R.raw.m_gamage

    override val sfxLose: Int
        get() = R.raw.m_lose_2

    val sfxWin: Int
        get() = R.raw.m_win

    val sfxHeal: Int
        get() = R.raw.m_heal

    val sfxAppearance: Int
        get() = R.raw.m_appearance


    override val animDefault: Array<Int>
        get() = arrayOf(
            R.drawable.m00,
            R.drawable.m01
        )

    override val animAttack: Array<Int>
        get() = arrayOf(
            R.drawable.m10,
            R.drawable.m11,
            R.drawable.m12,
        )

    override val animDefense: Array<Int>
        get() = arrayOf(
            R.drawable.m30,
            R.drawable.m31,
            R.drawable.m32,
            R.drawable.m33,
            R.drawable.m34,
        )

    override val animDamage: Array<Int>
        get() = arrayOf(
            R.drawable.m20,
            R.drawable.m21,
            R.drawable.m22,
        )

    override val animWin: Array<Int>
        get() = arrayOf(
            R.drawable.m50,
            R.drawable.m51,
        )

    override val animWinLoop: Array<Int>
        get() = arrayOf(
            R.drawable.m52,
            R.drawable.m53,
            R.drawable.m54,
            R.drawable.m55,
            R.drawable.m52,
        )

    override val animLose: Array<Int>
        get() = arrayOf(
            R.drawable.m60,
            R.drawable.m61,
            R.drawable.m62,
            R.drawable.m63,
            R.drawable.m64,
            R.drawable.m65,
        )

    override val animLoseLoop: Array<Int>
        get() = arrayOf(
            R.drawable.m64,
            R.drawable.m65,
        )


    val animHeal: Array<Int>
        get() = arrayOf(
            R.drawable.m40,
            R.drawable.m41,
            R.drawable.m42,
            R.drawable.m43,
            R.drawable.m44,
        )
    val animAppearance: Array<Int>
        get() = arrayOf(
            R.drawable.m70,
            R.drawable.m71,
            R.drawable.m72,
            R.drawable.m73,
            R.drawable.m74,
            R.drawable.m75,
            R.drawable.m76,
        )

//
//    fun default() : Array<Int> {
//        return arrayOf(
//            R.drawable.m00,
//            R.drawable.m01
//        )
//    }
//
//    fun attack() : Array<Int> {
//        return arrayOf(
//            R.drawable.m10,
//            R.drawable.m11,
//            R.drawable.m12,
//        )
//    }
//
//    fun defense() : Array<Int> {
//        return arrayOf(
//            R.drawable.m30,
//            R.drawable.m31,
//            R.drawable.m32,
//            R.drawable.m33,
//            R.drawable.m34,
//        )
//    }
//
//    fun damage() : Array<Int> {
//        return arrayOf(
//            R.drawable.m20,
//            R.drawable.m21,
//            R.drawable.m22,
//        )
//    }
//
//    fun win() : Array<Int> {
//        return arrayOf(
//            R.drawable.m50,
//            R.drawable.m51,
//        )
//    }
//
//    fun winLoop() : Array<Int> {
//        return arrayOf(
//            R.drawable.m52,
//            R.drawable.m53,
//            R.drawable.m54,
//            R.drawable.m55,
//            R.drawable.m52,
//        )
//    }
//
//    fun lose() : Array<Int> {
//        return arrayOf(
//            R.drawable.m60,
//            R.drawable.m61,
//            R.drawable.m62,
//            R.drawable.m63,
//            R.drawable.m64,
//            R.drawable.m65,
//        )
//    }
//
//    fun loseLoop() : Array<Int> {
//        return arrayOf(
//            R.drawable.m64,
//            R.drawable.m65,
//        )
//    }
//
//    fun appearance() : Array<Int> {
//        return arrayOf(
//            R.drawable.m70,
//            R.drawable.m71,
//            R.drawable.m72,
//            R.drawable.m73,
//            R.drawable.m74,
//            R.drawable.m75,
//            R.drawable.m76,
//        )
//    }
//
//    fun heal() : Array<Int> {
//        return arrayOf(
//            R.drawable.m40,
//            R.drawable.m41,
//            R.drawable.m42,
//            R.drawable.m43,
//            R.drawable.m44,
//        )
//    }
}