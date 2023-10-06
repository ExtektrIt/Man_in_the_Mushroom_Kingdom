package com.andre.guryanov.testgame.engine

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import androidx.core.net.toUri
import com.andre.guryanov.testgame.R
import kotlinx.coroutines.*

const val TITLE = R.raw.nine9999_in_1_3_0
const val GOOMBA = R.raw.veslo_3_4_0_loop_t
const val BOWSER = R.raw.shnyaga_5_1_0
const val CONGRATS = R.raw.chillyatina_2_3_t

class SoundPlayer {

//    private var isPlaying: Boolean? = null
    private var music: MediaPlayer? = null
    private val intervalVolChanges: Long = 100  // периодичность изменения громкости при эффектах (в миллисек)
    private val freqVolChanges: Int = 19  // кол-во изменений громкости при эффектах
    private var enableSoundEffect: Boolean = false

    private var musicVolume: Float = 1f
    private var sfxVolume: Float = 1f
    private var enableMusic = true
    private var enableSFX = true


    init {
        // загрузить параметры, если есть
    }

    fun nextLevel() {

    }



//    fun playTitleMusic(path: String) {
//
//    }
//
//    fun t() {
//        music.setVolume(0.5f, 0.5f)
//        music.setDataSource("")
//        music.setOnCompletionListener {
//            music.start()
//        }
//    }
//
//    fun playLevel1() {
//
//    }
//
//    fun playLevel2() {
//
//    }
//
//    fun playCongrats() {
//
//    {

    private fun play() {
//        isPlaying = true
        if ( ! enableMusic) return
//        if (enableSoundEffect) amplificationEffect()
        music?.start()
        music?.isLooping = true
//        music.setOnCompletionListener {
//            play()
//        }
    }

    private fun playWithEffect(mp: MediaPlayer) {
        CoroutineScope(Dispatchers.Main).launch {
            attenuationEffect()
            music = mp
//            music?.setVolume(0.01f, 0.01f)
            play()
            amplificationEffect()
        }

    }

    private fun stop() {
//        isPlaying = null
        music?.stop()
        music?.reset()
    }

    fun pause() {
//        isPlaying = false
        if (enableMusic) music?.pause()
    }

    fun resume() {
        if (enableMusic) music?.start()
    }

//    fun pauseOrResume() {
//        if (music.isPlaying) music.pause()
//        else music.start()
//    }

//    fun replay() {
//
//    }

    fun playMusic(context: Context, level: Int) {//path: String) {
//        if (music != null) music!!.reset()
//        music = MediaPlayer.create(context, resId)
        val resId = when(level) {
            0 -> TITLE
            1 -> GOOMBA
            2 -> BOWSER
            else -> CONGRATS
        }

        val mp = MediaPlayer.create(context, resId)
        if ((music != null) && (music!!.isPlaying)) playWithEffect(mp)
        else {
            music = mp
            play()
        }
    }

    fun playSFX(context: Context, path: String) {
        if ( ! enableSFX) return
        val sfx = MediaPlayer.create(context, path.toUri())
        sfx.setVolume(sfxVolume, sfxVolume)
        sfx.start()
    }

    fun enableMusic(state: Boolean) {
        if (state == enableMusic) return
        enableMusic = state
        if (enableMusic) play()
        else stop()
    }

    fun enableSFX(state: Boolean) {
        enableSFX = state
    }

    fun setMusicVolume(vol: Float) {
        musicVolume = vol
    }

    fun setSfxVolume(vol: Float) {
        sfxVolume = vol
    }

    private suspend fun attenuationEffect() { // эффект затухания музыки
        for (i in 1..freqVolChanges) {
            val diffVol = i * musicVolume / freqVolChanges
            val vol = musicVolume - diffVol
            music?.setVolume(vol, vol)
            delay(intervalVolChanges)
//            Log.e("vol", "дифференциал: $diffVol, громкость: $vol")
        }
        stop()
    }

    private suspend fun amplificationEffect() {   // эффект усиления громкости
        for (i in freqVolChanges downTo 1) {
            val diffVol: Float = i * musicVolume / freqVolChanges
            val vol = musicVolume - diffVol
            music?.setVolume(vol, vol)
            delay(intervalVolChanges)
//            Log.e("vol", "дифференциал: $diffVol, громкость: $vol")
        }
        music?.setVolume(musicVolume, musicVolume)
    }

}