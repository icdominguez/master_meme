package com.icdominguez.master_meme.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.icdominguez.master_meme.presentation.screens.newmeme.NewMemeScreen
import com.icdominguez.master_meme.presentation.screens.newmeme.NewMemeViewModel
import com.icdominguez.master_meme.presentation.screens.yourmemes.YourMemeScreen
import com.icdominguez.master_meme.presentation.screens.yourmemes.YourMemesViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavItem.YourMemes.route
    ) {
        composable(route = NavItem.YourMemes.route) { backStackEntry ->
            val yourMemesViewModel: YourMemesViewModel = hiltViewModel(backStackEntry)

            YourMemeScreen(
                state = yourMemesViewModel.state.collectAsStateWithLifecycle().value,
                uiEvent = yourMemesViewModel::uiEvent,
                onClick = { memeTemplate ->
                    navController.navigate(NavItem.NewMeme.createNavRoute(memeTemplate))
                },
            )
        }
        composable(
            route = NavItem.NewMeme.route,
            arguments = NavItem.NewMeme.args
        ) { backStackEntry ->
            val newMemeViewModel: NewMemeViewModel = hiltViewModel(backStackEntry)
            val memeTemplate = backStackEntry.arguments?.getString(NavArg.MemeTemplate.key)
            requireNotNull(memeTemplate) { "Can't be null, new meme requires a template" }

            NewMemeScreen(
                state = newMemeViewModel.state.collectAsStateWithLifecycle().value,
                uiEvent = newMemeViewModel::uiEvent,
                navController = navController,
                memeTemplate = memeTemplate
            )
        }
    }
}