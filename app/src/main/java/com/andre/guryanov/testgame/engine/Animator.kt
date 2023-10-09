package com.andre.guryanov.testgame.engine

import android.widget.ImageView
import kotlinx.coroutines.*

object Animator {

    private val jobs: HashMap<Int, Job> = hashMapOf()

    val animFreq: Long = 300

    fun animateImage(view: ImageView, arr: Array<Int>, loop: Boolean,
                     freq: Long = animFreq, callback: () -> Unit
    ) : Job {
        jobs[view.id]?.cancel()
        jobs[view.id] = CoroutineScope(Dispatchers.IO).launch {
            do {
                for (it in arr) {
                    withContext(Dispatchers.Main) {
                        view.setImageResource(it)
                    }
                    delay(freq)
                }
            }
            while (loop)
            jobs[ callbackId(view.id) ] = CoroutineScope(Dispatchers.Main).launch {
                callback()
            }
        }
        return jobs[view.id]!!
    }

    fun callbackId(id: Int) : Int {
        return 0 - id
    }

    fun stopAllAnimations() {
        for(j in jobs.keys) {
            jobs[j]?.cancel()
        }

    }
}