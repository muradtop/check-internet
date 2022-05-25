package com.example.check_internet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.check_internet.databinding.ActivityMainBinding
import com.example.check_internet.internet_conection.ConectionCheckFragment


class MainActivity : AppCompatActivity() {


    private lateinit var  cld : ConectionCheckFragment
    private lateinit var binding: ActivityMainBinding
    private lateinit var internet_check : ConstraintLayout
    private lateinit var internet_check2 : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkNetworkConnection()
        R.id.internet_check
        R.id.internet_check2
    }

    private fun checkNetworkConnection() {
        cld = ConectionCheckFragment(application)

        cld.observe(this) { isConnected ->

            if (isConnected) {

                internet_check.visibility = View.GONE
                internet_check2.visibility = View.VISIBLE

            }else{
                internet_check.visibility = View.VISIBLE
                internet_check2.visibility = View.GONE
            }


        }

    }
}