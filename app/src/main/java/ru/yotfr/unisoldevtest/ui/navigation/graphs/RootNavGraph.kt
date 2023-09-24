package ru.yotfr.unisoldevtest.ui.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.yotfr.unisoldevtest.domain.model.Category
import ru.yotfr.unisoldevtest.ui.categorywallpapers.screen.CategoryWallpaperScreen
import ru.yotfr.unisoldevtest.ui.navigation.screens.BottomBarScreens
import ru.yotfr.unisoldevtest.ui.navigation.screens.RootScreens
import ru.yotfr.unisoldevtest.ui.wallpaper.screen.WallpaperScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = RootScreens.BottomNav.route,
        modifier = modifier
    ) {
        bottomBarNavGraph(navController)
        composable(
            route = RootScreens.WallpapersByCategory.route,
            arguments = listOf(
                navArgument(RootScreens.CATEGORY_KEY) {}
            )
        ) { backStackEntry ->
            val category = Category.valueOf(
                backStackEntry.arguments?.getString(
                    RootScreens.CATEGORY_KEY
                ) ?: throw IllegalArgumentException("Navigated with wrong Category")
            )
            CategoryWallpaperScreen(
                category = category,
                navigateBack = { navController.popBackStack() },
                navigateToWallpaper = { wallpaper ->
                    navController.navigate(
                        RootScreens.WallpaperDetails.passId(
                            wallpaper.id
                        )
                    )
                }
            )
        }
        composable(
            route = RootScreens.WallpaperDetails.route,
            arguments = listOf(
                navArgument(RootScreens.WALLPAPER_ID_KEY) {}
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString(
                RootScreens.WALLPAPER_ID_KEY
            ) ?: throw IllegalArgumentException("Navigated with wrong WallpaperID")
            WallpaperScreen(
                id = id,
                navigateBack = { navController.popBackStack() }
            )
        }
    }
}