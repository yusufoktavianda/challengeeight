package binar.academy.challengeeight.presentation.detail


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import binar.academy.challengeeight.data.local.FavoriteRepository
import binar.academy.challengeeight.data.remote.PhotoRemoteDataSource
import binar.academy.challengeeight.data.remote.PhotoRepository
import binar.academy.challengeeight.data.api.Result
import binar.academy.challengeeight.data.local.Photo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class DetailViewModel(
    private val repository: PhotoRepository,
    private val favoriteRepository: FavoriteRepository

) : ViewModel() {
    private val detailPhoto: MutableLiveData<Result> by lazy {
        MutableLiveData<Result>()
    }
    fun searchPhoto(id:String){
        repository.detailPhoto(object : PhotoRemoteDataSource.DetailCallBack{
            override fun onComplete(listResult: Result) {
                detailPhoto.value = listResult
            }
            override fun onError() {
                Log.d("Error","error")
            }
        },id)
    }


    fun detailPhoto(): LiveData<Result> {
        return detailPhoto
    }


    fun insertPhoto(photo: Photo){
        viewModelScope.launch(Dispatchers.IO){
            val result = favoriteRepository.insertPhoto(photo)
            runBlocking(Dispatchers.Main){
                if (result !=0. toLong()){
                    Log.d("Done","Done")
                }
            }
        }
    }
}