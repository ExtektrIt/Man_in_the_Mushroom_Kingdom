package com.andre.guryanov.testgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andre.guryanov.testgame.databinding.FragmentTitleBinding
import com.andre.guryanov.testgame.engine.Controller
import com.andre.guryanov.testgame.engine.Game
import com.andre.guryanov.testgame.engine.UiManager

class TitleFragment : Fragment(), Controller {

    lateinit var binding: FragmentTitleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            UiManager.openOptions()
        }

        binding.button2.setOnClickListener {
            Game.start()
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