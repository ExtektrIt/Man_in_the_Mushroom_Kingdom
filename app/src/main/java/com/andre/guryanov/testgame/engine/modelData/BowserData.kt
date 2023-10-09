package com.andre.guryanov.testgame.engine.modelData

import com.andre.guryanov.testgame.R

class BowserData : ModelData() {

    override val sfxAttack: Int
        get() = R.raw.b_attack

    override val sfxDefense: Int
        get() = R.raw.mgb_defense

    override val sfxDamage: Int
        get() = R.raw.b_damage

    override val sfxLose: Int
        get() = R.raw.b_lose


    override val animDefault: Array<Int>
        get() = arrayOf(
            R.drawable.b00,
            R.drawable.b01,
        )

    override val animAttack: Array<Int>
        get() = arrayOf(
            R.drawable.b10,
            R.drawable.b11,
            R.drawable.b12,
            R.drawable.b13,
        )

    override val animDefense: Array<Int>
        get() = arrayOf(
            R.drawable.b30,
            R.drawable.b31,
            R.drawable.b32,
            R.drawable.b33,
            R.drawable.b34,
        )

    override val animDamage: Array<Int>
        get() = arrayOf(
            R.drawable.b20,
            R.drawable.b21,
            R.drawable.b22,
            R.drawable.b23,
        )

    override val animWin: Array<Int>
        get() = arrayOf(
            R.drawable.b40,
            R.drawable.b41,
            R.drawable.b42,
        )

    override val animWinLoop: Array<Int>
        get() = arrayOf(
            R.drawable.b41,
            R.drawable.b42,
        )

    override val animLose: Array<Int>
        get() = arrayOf(
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

    override val animLoseLoop: Array<Int>
        get() = arrayOf(
            R.drawable.b58,
            R.drawable.b59,
        )

    val animAttack2: Array<Int> = arrayOf(
        R.drawable.b10_0,
        R.drawable.b10_1,
        R.drawable.b10_2,
        R.drawable.b10_3,
    )


//    private fun animAttack() : Array<Int> {
//        return if ((1..4).random() == 4)arrayOf(
//            R.drawable.b10_0,
//            R.drawable.b10_1,
//            R.drawable.b10_2,
//            R.drawable.b10_3,
//        )
//        else arrayOf(
//            R.drawable.b10,
//            R.drawable.b11,
//            R.drawable.b12,
//            R.drawable.b13,
//        )
//    }

//
//    fun default() : Array<Int> {
//        return arrayOf(
//            R.drawable.b00,
//            R.drawable.b01,
//        )
//    }
//
//    fun attack() : Array<Int> {
//        return arrayOf(
//            R.drawable.b10,
//            R.drawable.b11,
//            R.drawable.b12,
//            R.drawable.b13,
//        )
//    }
//
//    fun defense() : Array<Int> {
//        return arrayOf(
//            R.drawable.b30,
//            R.drawable.b31,
//            R.drawable.b32,
//            R.drawable.b33,
//            R.drawable.b34,
//        )
//    }
//
//    fun damage() : Array<Int> {
//        return arrayOf(
//            R.drawable.b20,
//            R.drawable.b21,
//            R.drawable.b22,
//            R.drawable.b23,
//        )
//    }
//
//    fun win() : Array<Int> {
//        return arrayOf(
//            R.drawable.b40,
//            R.drawable.b41,
//            R.drawable.b42,
//        )
//    }
//
//    fun winLoop() : Array<Int> {
//        return arrayOf(
//            R.drawable.b41,
//            R.drawable.b42,
//        )
//    }
//
//    fun lose() : Array<Int> {
//        return arrayOf(
//            R.drawable.b50,
//            R.drawable.b51,
//            R.drawable.b52,
//            R.drawable.b53,
//            R.drawable.b54,
//            R.drawable.b55,
//            R.drawable.b56,
//            R.drawable.b57,
//            R.drawable.b58,
//            R.drawable.b59,
//        )
//    }
//
//    fun loseLoop() : Array<Int> {
//        return arrayOf(
//            R.drawable.b58,
//            R.drawable.b59,
//        )
//    }
//
//
//    fun attack2() : Array<Int> {
//        return arrayOf(
//            R.drawable.b10_0,
//            R.drawable.b10_1,
//            R.drawable.b10_2,
//            R.drawable.b10_3,
//        )
//    }


}