package com.andre.guryanov.testgame.engine

import android.widget.ImageView
import kotlinx.coroutines.*


class AnimationCreator {

//    private var bgJob: Job? = null
//    private var marioJob: Job? = null
//    private var marioJob: Job? = null
//    private var marioJob: Job? = null

    private val jobs: HashMap<Int, Job> = hashMapOf()

    val animFreq: Long = 300

    fun animateImage(view: ImageView, id: Int, list: ArrayList<Int>, loop: Boolean,
                     freq: Long = animFreq, callback: () -> Unit) {
        jobs[view.id]?.cancel()
//        Log.e("anim","стартует анимация, зацикленность = $loop")
        jobs[view.id] = CoroutineScope(Dispatchers.IO).launch {
            do {
                for (it in list) {
                    withContext(Dispatchers.Main) {
                        view.setImageResource(it)
                    }

//                    Log.e("anim","показано изображение $it")
                    delay(freq)
                }
            }
            while (loop)
            callback()
        }
    }

//    private suspend fun animate()

    fun animateBG() {

    }

    fun stopAllAnim() {
        for(j in jobs.keys) {
            jobs[j]?.cancel()
        }
    }

}