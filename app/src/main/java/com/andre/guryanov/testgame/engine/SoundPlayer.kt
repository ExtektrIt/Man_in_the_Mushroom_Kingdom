package com.andre.guryanov.testgame.engine

import android.content.Context
import android.media.MediaPlayer
import android.util.Log
import androidx.core.net.toUri
import com.andre.guryanov.testgame.R
import kotlinx.coroutines.*

//const val TITLE = R.raw.nine9999_in_1_3_0
//const val GOOMBA = R.raw.veslo_3_4_0_loop_t
//const val BOWSER = R.raw.shnyaga_5_1_0
//const val CONGRATS = R.raw.chillyatina_2_3_t

object SoundPlayer {

    const val SFX_PAUSE = R.raw.game_pause

//    private var isPlaying: Boolean? = null
    private var music: MediaPlayer? = null
    private var lastMusicId: Int? = null
    private val intervalVolChanges: Long = 100  // периодичность изменения громкости при эффектах (в миллисек)
    private val freqVolChanges: Int = 19  // кол-во изменений громкости при эффектах
//    private var enableSoundEffect: Boolean = false

    var musicVolume: Float = 0.8f
        private set
    var sfxVolume: Float = 1f
        private set
    var enableMusic = true
        private set
    var enableSFX = true
        private set
    val sfxDelay = 10L


    init {
        // загрузить параметры, если есть
    }


    fun playMusic(context: Context, resId: Int) {
        lastMusicId = resId
        music = MediaPlayer.create(context, resId)
        play()
    }

    fun playWithEffect(context: Context, resId: Int) {
        lastMusicId = resId
        music = MediaPlayer.create(context, resId)
        music?.setVolume(0f, 0f)
        CoroutineScope(Dispatchers.IO).launch {
            play(false)
            amplificationEffect()
        }
    }

    fun stopWithEffect() {
        if (music?.isPlaying!!) {
            CoroutineScope(Dispatchers.IO).launch {
                attenuationEffect()
            }
        }
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

    private fun play(default: Boolean = true) {
//        isPlaying = true
//        lastMusicId = resId
        if ( ! enableMusic) return
//        if (enableSoundEffect) amplificationEffect()
        if (default) music?.setVolume(musicVolume, musicVolume)
        music?.start()
        music?.isLooping = true
//        music.setOnCompletionListener {
//            play()
//        }
    }



//    private fun playWithEffect(mp: MediaPlayer) {
//        CoroutineScope(Dispatchers.Main).launch {
//            attenuationEffect()
//            music = mp
////            music?.setVolume(0.01f, 0.01f)
//            play()
//            amplificationEffect()
//        }
//
//    }

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

//    fun playMusic(context: Context, resId: Int, effect: Boolean = false) {//path: String) {
////        if (music != null) music!!.reset()
////        music = MediaPlayer.create(context, resId)
//
////        val resId = when(level) {
////            0 -> TITLE
////            1 -> GOOMBA
////            2 -> BOWSER
////            else -> CONGRATS
////        }
//
//        val mp = MediaPlayer.create(context, resId)
////        if (effect) playWithEffect(mp)
////        else
////        {
//            music = mp
//            play()
////        }
//    }

//    fun playSFX(context: Context, path: String) {
//        if ( ! enableSFX) return
//        val sfx = MediaPlayer.create(context, path.toUri())
//        sfx.setVolume(sfxVolume, sfxVolume)
//        sfx.start()
//    }

    fun playSFX(context: Context, resId: Int, delay: Long = sfxDelay, callback: () -> Unit) {
        if ( ! enableSFX) return
        val sfx = MediaPlayer.create(context, resId)
        sfx.setOnCompletionListener {
            sfx.stop()
            sfx.reset()
//            callback()
        }
        CoroutineScope(Dispatchers.Main).launch {
            sfx.setVolume(sfxVolume, sfxVolume)
            delay(delay)
            sfx.start()
        }
    }

    fun enableMusic(context: Context, state: Boolean) {
        if (state == enableMusic) return
        enableMusic = state
        if (enableMusic) {
            music = MediaPlayer.create(context, lastMusicId!!)
            play()
        }
        else stop()//music?.stop()
    }

    fun enableSFX(state: Boolean) {
        enableSFX = state
    }

    fun setMusicVolume(vol: Float) : Boolean {
        return if (vol in 0f..1f) {
            musicVolume = vol
            true
        }
        else false
    }

    fun setSfxVolume(vol: Float) : Boolean {
        return if (vol in 0f..1f) {
            sfxVolume = vol
            true
        }
        else false
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