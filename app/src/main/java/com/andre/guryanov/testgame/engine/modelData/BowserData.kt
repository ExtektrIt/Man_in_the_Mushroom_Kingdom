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
}