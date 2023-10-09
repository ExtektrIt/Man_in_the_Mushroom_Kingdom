package com.andre.guryanov.testgame.engine.modelData

import com.andre.guryanov.testgame.R

class GoombaData : ModelData() {

    override val sfxAttack: Int
        get() = R.raw.g_attack

    override val sfxDefense: Int
        get() = R.raw.mgb_defense

    override val sfxDamage: Int
        get() = R.raw.g_damage

    override val sfxLose: Int
        get() = R.raw.g_lose_f_3



    override val animDefault: Array<Int>
        get() = arrayOf(
            R.drawable.g00,
            R.drawable.g01,
        )

    override val animAttack: Array<Int>
        get() = arrayOf(
            R.drawable.g10,
            R.drawable.g11,
            R.drawable.g12,
        )

    override val animDefense: Array<Int>
        get() = arrayOf(
            R.drawable.g30,
            R.drawable.g31,
            R.drawable.g32,
            R.drawable.g33,
            R.drawable.g34,
            R.drawable.g35,
        )

    override val animDamage: Array<Int>
        get() = arrayOf(
            R.drawable.g20,
            R.drawable.g21,
        )

    override val animWin: Array<Int>
        get() = arrayOf(
            R.drawable.g40,
            R.drawable.g41,
            R.drawable.g42,
            R.drawable.g43,
            R.drawable.g44,
            R.drawable.g45,
            R.drawable.g46,
        )

    override val animWinLoop: Array<Int>
        get() = arrayOf(
            R.drawable.g45,
            R.drawable.g46,
        )

    override val animLose: Array<Int>
        get() = arrayOf(
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

    override val animLoseLoop: Array<Int>
        get() = arrayOf()
}