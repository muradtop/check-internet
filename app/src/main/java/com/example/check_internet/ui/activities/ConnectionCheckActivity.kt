package com.example.check_internet.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.check_internet.databinding.CheckConectionBinding
import com.example.check_internet.internet_conection.CheckInternet


class ConnectionCheckActivity : AppCompatActivity() {

    private lateinit var cld : CheckInternet
    private lateinit var binding : CheckConectionBinding
    private lateinit var internet : ConstraintLayout
    private lateinit var internet2 : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CheckConectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkNetworkConnection()

      internet = binding.internet
      internet2 = binding.internet2

    }

    private fun checkNetworkConnection() {
        cld = CheckInternet(application)

        cld.observe(this) { isConnected ->

            if (isConnected) {

                internet.visibility = View.GONE
                internet2.visibility = View.VISIBLE

            } else {
                internet.visibility = View.VISIBLE
                internet2.visibility = View.GONE
            }

        }
    }
}