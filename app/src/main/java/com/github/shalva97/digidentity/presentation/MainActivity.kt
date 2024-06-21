package com.github.shalva97.digidentity.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.shalva97.digidentity.presentation.navigation.Home
import com.github.shalva97.digidentity.presentation.screens.HomeScreen
import com.github.shalva97.digidentity.presentation.screens.HomeViewModel
import com.github.shalva97.digidentity.ui.theme.DigidentityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DigidentityTheme {
                DigidentityApp()
            }
        }
    }
}

@Composable
fun DigidentityApp() {
    // TODO
}
