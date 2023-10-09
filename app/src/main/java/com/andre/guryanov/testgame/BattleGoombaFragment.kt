package com.andre.guryanov.testgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andre.guryanov.testgame.databinding.FragmentBattleGoombaBinding
import com.andre.guryanov.testgame.engine.Animator
import com.andre.guryanov.testgame.engine.Game
import com.andre.guryanov.testgame.engine.Controller
import com.andre.guryanov.testgame.engine.UiManager

class BattleGoombaFragment : Fragment(), Controller {

    lateinit var binding: FragmentBattleGoombaBinding
    var t = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBattleGoombaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        lockActionButtons()

        binding.button.setOnClickListener {
            Game.healPlayer()
        }

        binding.button2.setOnClickListener {
            Game.attack()
//            if (t) {
//                t = false
//                Animator.getJob(UiManager.goomba())?.cancel()
//            }
//            else {
//                t = true
//                Animator.getJob(UiManager.goomba())?.start()
//            }
        }

//        Game.controller = this
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