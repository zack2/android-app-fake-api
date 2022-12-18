package com.olivierloukombo.android_app_fake_api

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.olivierloukombo.android_app_fake_api.navigation.SetupNavGraph
import com.olivierloukombo.android_app_fake_api.ui.theme.AndroidappfakeapiTheme
import com.olivierloukombo.android_app_fake_api.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel  by viewModels<MainViewModel>()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      /*  installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }*/
        setContent {
            AndroidappfakeapiTheme {
                val navController = rememberNavController()
                SetupNavGraph(navController = navController, viewModel)
            }
        }
    }
}


