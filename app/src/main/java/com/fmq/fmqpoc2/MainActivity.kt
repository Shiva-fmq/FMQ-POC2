package com.fmq.fmqpoc2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.fmq.onboarding.LoginActivity
import com.fmq.onboarding.LoginConfigurationsModel
import com.fmq.onboarding.LoginItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        readConfigurationsFromJson()

    }

    private fun readConfigurationsFromJson() {

        val data = JsonUtils.readJsonData(this, R.raw.login_config)

    //    val myType = object : TypeToken<List<LoginConfigurationsModel>>() {}.type
        val loginConfigurations = Gson().fromJson(data, LoginConfigurationsModel::class.java)

        Intent(this,LoginActivity::class.java).apply {
            putExtra("config",Gson().toJson(loginConfigurations))
            loginActivityLauncher.launch(this)
        }
    }

    private var loginActivityLauncher: ActivityResultLauncher<Intent> =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                Log.e("Tag",result?.data?.getStringExtra("data")!!)

            }
        }

}