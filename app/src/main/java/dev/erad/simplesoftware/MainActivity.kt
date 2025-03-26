package dev.erad.simplesoftware

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dev.erad.simplesoftware.presentation.onboarding.OnBoardingScreen
import dev.erad.simplesoftware.ui.theme.SimplenewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            SimplenewsTheme {
                Box(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                ) {
                    OnBoardingScreen(modifier = Modifier)
                }
            }
        }
    }
}
