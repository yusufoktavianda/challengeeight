package binar.academy.challengeeight.network

import binar.academy.challengeeight.data.api.GetAllPhotosResponse
import binar.academy.challengeeight.data.api.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    //home
    @GET("photos/?client_id=6DX3T0BscoqFp2i298xq23I-Mxy30jJ3uLrYElKf8Ck")
    suspend fun allPhoto(): Response<List<Result>>

    //id
    @GET("photos/{id}?client_id=M7EaUVLsM_2BuWsVMhDcAL9R2duqDsWGkDQweVr9_lc&=")
    suspend fun searchPhotoWithId(
        @Path("id")id:String
    ):Response<Result>

    @GET("search/photos/?client_id=M7EaUVLsM_2BuWsVMhDcAL9R2duqDsWGkDQweVr9_lc")
    suspend fun searchPhoto(
        @Query("query") query: String
    ):Response<GetAllPhotosResponse>
}