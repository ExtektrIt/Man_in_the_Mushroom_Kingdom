package com.andre.guryanov.testgame.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.andre.guryanov.testgame.R
import com.andre.guryanov.testgame.databinding.ActivityMainBinding
import com.andre.guryanov.testgame.engine.CreatureConfigurator
import com.andre.guryanov.testgame.engine.Game
import com.andre.guryanov.testgame.engine.SoundPlayer
import com.andre.guryanov.testgame.engine.UiManager
import com.andre.guryanov.testgame.models.Creature
import com.andre.guryanov.testgame.models.PlayerMario

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private var options: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment)
        init()
        initListeners()

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
//        Game.setUI(this)
        UiManager.init(this)
//        Game.launchGame(this)
        Game.launchGame()
    }

    private fun initListeners() = with(binding) {
        ivMario.setOnClickListener {
            val mario = CreatureConfigurator.createMario()
            showDialogOverrideCreature(mario, R.string.override_mario, mario.firstAidCount)
        }

        ivGoomba.setOnClickListener {
            showDialogOverrideCreature(CreatureConfigurator.createGoomba(), R.string.override_goomba, -1)
        }

        ivBowser.setOnClickListener {
            showDialogOverrideCreature(CreatureConfigurator.createBowser(), R.string.override_bowser, -1)
        }

        swMusic.setOnCheckedChangeListener { _, isChecked ->
            SoundPlayer.enableMusic(this@MainActivity, isChecked)
        }

        swSfx.setOnCheckedChangeListener { _, isChecked ->
            SoundPlayer.enableSFX(isChecked)
        }

        btnRestoreMario.setOnClickListener {
            CreatureConfigurator.mario = null
            showOrHideRestoreButtons()
        }

        btnRestoreGoomba.setOnClickListener {
            CreatureConfigurator.goomba = null
            showOrHideRestoreButtons()
        }

        btnRestoreBowser.setOnClickListener {
            CreatureConfigurator.bowser = null
            showOrHideRestoreButtons()
        }
    }

    private fun showDialogOverrideCreature(creature: Creature, creatureName: Int, aids: Int) {
        val view = layoutInflater.inflate(R.layout.override_creature, null)

        val attack = view.findViewById<EditText>(R.id.field_attack)
        val defense = view.findViewById<EditText>(R.id.field_defense)
        val health = view.findViewById<EditText>(R.id.field_max_health)
        val damage = view.findViewById<EditText>(R.id.field_damage_min)
        val damageMax = view.findViewById<EditText>(R.id.field_damage_max)
        val firstAid = view.findViewById<EditText>(R.id.field_first_aid)
        val aidLayout = view.findViewById<LinearLayout>(R.id.layout_first_aid)

        attack.setText(creature.attack.toString())
        defense.setText(creature.defense.toString())
        health.setText(creature.maxHealth.toString())
        damage.setText(creature.damage.first.toString())
        damageMax.setText(creature.damage.last.toString())

        val fAid = if ( aids < 0 ) {
            aidLayout.visibility = View.GONE
            0
        }
        else aids
        firstAid.setText(fAid.toString())


        val builder = AlertDialog.Builder(this)
        builder.setTitle(creatureName)
            .setView(view)
            .setPositiveButton(R.string.confirm) { _, _ ->
                try {
                    val message = if (CreatureConfigurator.overrideCreature(creatureName,
                            attack.text.toString().toInt(),
                            defense.text.toString().toInt(),
                            health.text.toString().toInt(),
                            damage.text.toString().toInt()..damageMax.text.toString().toInt(),
                            firstAid.text.toString().toInt()
                        )) R.string.success
                    else R.string.fail
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
                    showOrHideRestoreButtons()
                }
                catch (e: java.lang.NumberFormatException) {
                    Toast.makeText(this, R.string.fill_all_fields, Toast.LENGTH_LONG).show()
                }
                catch (e: Exception) {
                    Toast.makeText(this, R.string.only_integer, Toast.LENGTH_LONG).show()
                }
            }
            .setNegativeButton(R.string.cancel, null)
        val dialog = builder.create()
        dialog.show()
    }

    fun openOptions() {
        navController.navigate(R.id.nav_options)
        binding.tvMessage.text = getString(R.string.options)
        binding.swMusic.isChecked = SoundPlayer.enableMusic
        binding.swSfx.isChecked = SoundPlayer.enableSFX

        binding.options.visibility = View.VISIBLE
        showOrHideRestoreButtons()
    }

    fun closeOptions() {
        binding.options.visibility = View.GONE
        UiManager.restoreScreenBrightness()
        binding.tvMessage.text = getString(R.string.game)
//        navController.navigate(R.id.nav_title)
    }

    private fun showOrHideRestoreButtons() {
        val vis = View.VISIBLE
        val invis = View.INVISIBLE

        binding.btnRestoreMario.visibility = if (CreatureConfigurator.mario == null) invis
        else vis

        binding.btnRestoreGoomba.visibility= if (CreatureConfigurator.goomba == null) invis
        else vis

        binding.btnRestoreBowser.visibility = if (CreatureConfigurator.bowser == null) invis
        else vis


//        if (CreatureConfigurator.mario == null)
//            binding.btnRestoreMario.visibility = invis
//        else vis
//
//        if (CreatureConfigurator.goomba == null)
//            binding.btnRestoreGoomba.visibility = invis
//        else vis
//
//        if (CreatureConfigurator.bowser == null)
//            binding.btnRestoreBowser.visibility = invis
//        else vis
    }


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

    fun getPlayerHealth() : TextView {
        return binding.textView
    }

    fun getMonsterHealth() : TextView {
        return binding.textView2
    }

    fun getFirstAid() : TextView {
        return binding.textView3
    }

    fun getLivesGroup() : ConstraintLayout {
        return binding.livesGroup
    }

    fun getMessage() : TextView {
        return binding.tvMessage
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
//        super.onBackPressed()

//        if (Game.isPlaying) Game.pause()
//        else Game.resume()
    }

}