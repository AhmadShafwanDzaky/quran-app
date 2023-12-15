package com.d121211053.quranapplication

import android.app.Application
import com.d121211053.quranapplication.data.DefaultHadithAppContainer
import com.d121211053.quranapplication.data.HadithAppContainer

class MyApplication: Application() {

    lateinit var container: HadithAppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultHadithAppContainer()
    }

}