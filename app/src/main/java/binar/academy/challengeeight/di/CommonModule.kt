package binar.academy.challengeeight.di

import androidx.room.Room
import binar.academy.challengeeight.data.local.ApplicationDB
import binar.academy.challengeeight.network.Service
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import binar.academy.challengeeight.data.remote.PhotoRemoteDataSource
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val localModule = module {
    factory { get<ApplicationDB>().photoDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            ApplicationDB::class.java, "Photo18dd56665s242309.db").fallbackToDestructiveMigration().build()
    }
}

val networkModule= module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(
                ChuckerInterceptor.Builder(androidContext())
                    .collector(ChuckerCollector(androidContext()))
                    .maxContentLength(250000L)
                    .redactHeaders(emptySet())
                    .alwaysReadResponseBody(false)
                    .build()
            )
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(Service::class.java)
    }

}
val remoteDataSourceModule = module {
    single { PhotoRemoteDataSource(get()) }
}