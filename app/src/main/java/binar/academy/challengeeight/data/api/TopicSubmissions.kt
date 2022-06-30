package binar.academy.challengeeight.data.api


import com.google.gson.annotations.SerializedName

data class TopicSubmissions(
    @SerializedName("architecture")
    val architecture: Architecture,
    @SerializedName("color-of-water")
    val colorOfWater: ColorOfWater,
    @SerializedName("nature")
    val nature: Nature,
    @SerializedName("textures-patterns")
    val texturesPatterns: TexturesPatterns,
    @SerializedName("travel")
    val travel: Travel,
    @SerializedName("wallpapers")
    val wallpapers: Wallpapers
)