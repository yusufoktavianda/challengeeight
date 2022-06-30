package binar.academy.challengeeight.data.api


import com.google.gson.annotations.SerializedName

data class GetAllPhotosResponse(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)