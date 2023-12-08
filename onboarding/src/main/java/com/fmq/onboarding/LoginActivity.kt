package com.fmq.onboarding

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.fmq.onboarding.databinding.ActivityLoginLayoutBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginLayoutBinding
    private var mReceivedData : LoginConfigurationsModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("config")?.let {
            mReceivedData = Gson().fromJson(it, LoginConfigurationsModel::class.java)
            Log.e("Tag", Gson().toJson(mReceivedData))
            setupUI()
        }
    }

    private fun setupUI() {

        mReceivedData?.let {

            if(!it.inputFields.isEmpty()) {

                val filterForgotPwd = it.inputFields.filter { it.id == "forgot_password" }

                filterForgotPwd.let {item->
                    if(item[0].isVisible) {
                        binding.txtForgotPassword.visibility = View.VISIBLE
                    }
                    else {
                        binding.txtForgotPassword.visibility = View.GONE
                    }
                }
            }

        }

    }
}