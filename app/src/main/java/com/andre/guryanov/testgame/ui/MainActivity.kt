package com.andre.guryanov.testgame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.activity.contextaware.withContextAvailable
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.databinding.ActivityMainBinding
import com.andre.guryanov.testgame.engine.Game

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)
        init()
//        initListeners()

    }

    override fun onPause() {
        super.onPause()
        Game.pause()
    }

    override fun onResume() {
        super.onResume()
        Game.resume()
    }

    private fun init() {
        Game.setUI(this)
//        Game.launchGame(this)
        Game.launchGame()
    }

//    private fun initListeners() {
//        binding.button2.setOnClickListener {
//            startGame()
//        }
//    }

    fun getBG() : ImageView {
        return binding.background
    }

    fun getMarioPH() : ImageView {
        return binding.marioPlaceholder
    }

    fun getGoombaPH() : ImageView {
        return binding.goombaPlaceholder
    }

    fun getBowserPH() : ImageView {
        return binding.bowserPlaceholder
    }

    fun getBlackout() : ImageView {
        return binding.blackout
    }


    private fun startGame() {
        Game.start()
    }

    private fun pause() {

    }

    private fun resume() {

    }

    fun selectLevel(level: Int) {
        val dest = when(level){
            1 -> R.id.nav_goomba
            2 -> R.id.nav_bowser
            0 -> R.id.nav_title
            else -> R.id.nav_congrats
        }
        navController.navigate(dest)
    }

    override fun onBackPressed() {
        super.onBackPressed()

//        Game
    }

}