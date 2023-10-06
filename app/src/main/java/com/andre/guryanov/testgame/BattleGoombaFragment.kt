package com.andre.guryanov.testgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andre.guryanov.testgame.databinding.FragmentBattleGoombaBinding
import com.andre.guryanov.testgame.engine.Game

class BattleGoombaFragment : Fragment() {

    lateinit var binding: FragmentBattleGoombaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBattleGoombaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            Game.healPlayer()
        }

        binding.button2.setOnClickListener {
            Game.attack()
        }
    }

}