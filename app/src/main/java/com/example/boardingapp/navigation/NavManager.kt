package com.example.boardingapp.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.boardingapp.dataStore.StoreBoarding
import com.example.boardingapp.viewModel.MainViewBoarding
import com.example.boardingapp.views.HomeView
import com.example.boardingapp.views.SplashScreen

@Composable
fun NavManager(){
    val context = LocalContext.current
    val dataStore= StoreBoarding(context)
    val store=dataStore.getStoreBoarding.collectAsState(initial = false)

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Splash") {
        composable("onBoarding"){
            MainViewBoarding(navController, dataStore)
        }
        composable("home"){
            HomeView(navController)
        }

        composable("Splash"){
            SplashScreen(navController)
        }
    }
}