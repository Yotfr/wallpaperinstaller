package ru.yotfr.unisoldevtest.ui.root

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.yotfr.unisoldevtest.ui.navigation.graphs.RootNavGraph
import ru.yotfr.unisoldevtest.ui.navigation.screens.BottomBarScreens
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootScreen() {

    val navController = rememberNavController()

    val bottomBarScreens = listOf(
        BottomBarScreens.Categories,
        BottomBarScreens.FavoriteWallpapers,
        BottomBarScreens.SavedWallpapers
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val isBottomBarDestination = bottomBarScreens.any { it.route == currentDestination?.route }

    Scaffold(
        bottomBar = {
            if (isBottomBarDestination) {
                WallpaperBottomNavBar(
                    navController = navController,
                    bottomBarScreens = bottomBarScreens,
                    isScreenSelected = { screen ->
                        currentDestination?.hierarchy?.any {
                            it.route == screen.route
                        } == true
                    }
                )
            }
        },
        topBar = {
            if (isBottomBarDestination) {
                WallpaperRootTopAppBar(
                    onSettingsClicked = {
                        // TODO
                    }
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) {  innerPadding ->
        RootNavGraph(
            navController = navController,
            modifier = Modifier.then(
                if (isBottomBarDestination) {
                        Modifier
                            .padding(innerPadding)
                    } else Modifier
            )
        )
    }

}