package com.github.shalva97.digidentity.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.github.shalva97.digidentity.presentation.navigation.Home
import com.github.shalva97.digidentity.presentation.navigation.ItemDetails
import com.github.shalva97.digidentity.presentation.screens.details.DetailsScreen
import com.github.shalva97.digidentity.presentation.screens.details.DetailsViewModel
import com.github.shalva97.digidentity.presentation.screens.home.HomeScreen
import com.github.shalva97.digidentity.presentation.screens.home.HomeViewModel
import com.github.shalva97.digidentity.presentation.theme.DigidentityTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Home
        ) {
            composable<Home> {
                val viewmodel: HomeViewModel = hiltViewModel()
                val catalogs = viewmodel.catalogs.collectAsLazyPagingItems()
                HomeScreen(catalogs)
            }
            composable<ItemDetails> {
                val viewModel: DetailsViewModel = hiltViewModel()
                val state by viewModel.state.collectAsState()
                DetailsScreen(state)
            }
        }
    }
}
