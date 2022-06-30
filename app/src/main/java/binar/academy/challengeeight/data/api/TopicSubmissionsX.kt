package binar.academy.challengeeight.data.api


import com.google.gson.annotations.SerializedName

data class TopicSubmissionsX(
    @SerializedName("experimental")
    val experimental: Experimental,
    @SerializedName("fashion")
    val fashion: Fashion,
    @SerializedName("history")
    val history: History,
    @SerializedName("spirituality")
    val spirituality: Spirituality,
    @SerializedName("travel")
    val travel: Travel,
    @SerializedName("wallpapers")
    val wallpapers: Wallpapers
)