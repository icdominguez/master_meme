package com.icdominguez.icdominguez.master_meme.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.icdominguez.icdominguez.master_meme.presentation.navigation.Navigation
import com.icdominguez.icdominguez.master_meme.ui.theme.MasterMemeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MasterMemeTheme {
                Navigation()
            }
        }
    }
}