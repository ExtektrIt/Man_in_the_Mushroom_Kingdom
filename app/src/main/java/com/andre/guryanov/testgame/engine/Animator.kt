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

//            job?.invokeOnCompletion {
//
//            }
//            var i = loop
            do {
                for (it in arr) {
                    withContext(Dispatchers.Main) {
                        view.setImageResource(it)
                    }
                    delay(freq)
                }
            }
            while (loop)

//            while (i <= loop) {
//                for (it in arr) {
//                    withContext(Dispatchers.Main) {
//                        view.setImageResource(it)
//                    }
//                    delay(freq)
//                }
//                i++
//            }

//            withContext(Dispatchers.Main) {
//                callback()
//            }
            jobs[ callbackId(view.id) ] = CoroutineScope(Dispatchers.Main).launch {
                callback()
            }

        }
        return jobs[view.id]!!
    }

    fun join(job: Job, func: () -> Unit) {
        CoroutineScope(Dispatchers.Main).launch {
            job.join()
            func()
        }
    }

    fun getJob(view: ImageView) : Job? {
        return jobs[view.id]
    }

    fun callbackId(id: Int) : Int {
        return 0 - id
    }

    fun stopAllAnimations() {
        for(j in jobs.keys) {
            jobs[j]?.cancel()
        }

    }

    fun marioAttack(success: Boolean, monsterId: Int, callback: () -> Unit) {

    }

    fun marioDefense(monsterId: Int, callback: () -> Unit) {

    }





}