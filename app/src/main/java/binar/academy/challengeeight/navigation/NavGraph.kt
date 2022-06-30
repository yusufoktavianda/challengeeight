package binar.academy.challengeeight.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import binar.academy.challengeeight.navigation.bottombar.BottomBarScreen
import binar.academy.challengeeight.presentation.detail.DetailScreen
import binar.academy.challengeeight.presentation.favorite.FavoriteScreen
import binar.academy.challengeeight.presentation.home.HomeScreen
import binar.academy.challengeeight.presentation.screen.SearchScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarScreen.Favorite.route) {
            FavoriteScreen(navController)
        }
        composable("DetailScreen/{photoId}") {
            DetailScreen(it.arguments?.getString("photoId"))
        }
//        composable("search_screen"){ SearchScreen(navController = navController)}
    }
}