package com.gtech.atektickting

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gtech.atektickting.controller.NavBarController
import com.gtech.atektickting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        NavBarController.setNavContent(this, mainBinding)

    }

}