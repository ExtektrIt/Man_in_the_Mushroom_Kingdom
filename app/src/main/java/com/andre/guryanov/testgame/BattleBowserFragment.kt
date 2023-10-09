package com.andre.guryanov.testgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andre.guryanov.testgame.databinding.FragmentBattleBowserBinding
import com.andre.guryanov.testgame.engine.Game
import com.andre.guryanov.testgame.engine.Controller

class BattleBowserFragment : Fragment(), Controller {

    lateinit var binding:FragmentBattleBowserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBattleBowserBinding.inflate(inflater, container, false)
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

        bindController()
    }

    override fun lockActionButtons() {
        binding.button.visibility = View.INVISIBLE
        binding.button2.visibility = View.INVISIBLE
    }

    override fun unlockActionButtons() {
        binding.button.visibility = View.VISIBLE
        binding.button2.visibility = View.VISIBLE
    }
}