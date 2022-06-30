package binar.academy.challengeeight.data.api


import com.google.gson.annotations.SerializedName

data class History(
    @SerializedName("approved_on")
    val approvedOn: String,
    @SerializedName("status")
    val status: String
)