package binar.academy.challengeeight.di

import binar.academy.challengeeight.data.local.FavoriteRepository
import binar.academy.challengeeight.presentation.detail.DetailViewModel
import binar.academy.challengeeight.presentation.favorite.FavoriteViewModel
import binar.academy.challengeeight.presentation.home.HomeViewModel
import binar.academy.challengeeight.presentation.search.SearchViewModel
import binar.academy.challengeeight.data.remote.PhotoRepository


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get(),get()) }
    viewModel { FavoriteViewModel(get()) }
    viewModel{ SearchViewModel(get()) }
}

val repositoryModule= module {
    single {
        PhotoRepository(get())
    }
    single {
        FavoriteRepository(get())
    }
}