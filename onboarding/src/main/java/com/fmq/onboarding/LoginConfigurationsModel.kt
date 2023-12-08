package com.fmq.onboarding

import com.google.gson.annotations.SerializedName
import java.io.Serial

data class LoginConfigurationsModel(
    @SerializedName("input_fields")
    val inputFields : List<LoginItems>
)


data class LoginItems(
    @SerializedName("id")
    val id : String,
    @SerializedName("isVisible")
    val isVisible : Boolean
)
