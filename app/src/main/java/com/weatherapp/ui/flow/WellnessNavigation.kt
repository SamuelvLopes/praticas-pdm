package com.weatherapp.ui.flow

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.weatherapp.ui.pages.InsightsScreen
import com.weatherapp.ui.pages.JourneysScreen
import com.weatherapp.ui.pages.LoginScreen
import com.weatherapp.ui.pages.OnboardingScreen
import com.weatherapp.ui.pages.ProfileDashboardScreen
import com.weatherapp.ui.pages.WelcomeScreen

enum class WellnessScreen(val route: String) {
    Onboarding("onboarding"),
    Welcome("welcome"),
    Login("login"),
    Profile("profile"),
    Insights("insights"),
    Journeys("journeys")
}

@Composable
fun WellnessNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = WellnessScreen.Onboarding.route,
        modifier = modifier
    ) {
        composable(WellnessScreen.Onboarding.route) {
            OnboardingScreen(
                onContinue = { navController.navigate(WellnessScreen.Welcome.route) }
            )
        }
        composable(WellnessScreen.Welcome.route) {
            WelcomeScreen(
                onGoogle = { navController.navigate(WellnessScreen.Profile.route) },
                onCreateAccount = { navController.navigate(WellnessScreen.Login.route) },
                onLogin = { navController.navigate(WellnessScreen.Login.route) }
            )
        }
        composable(WellnessScreen.Login.route) {
            LoginScreen(
                onLogin = { navController.navigate(WellnessScreen.Profile.route) },
                onForgotPassword = {},
                onBackToWelcome = { navController.popBackStack() }
            )
        }
        composable(WellnessScreen.Profile.route) {
            ProfileDashboardScreen(
                onOpenIntegrations = { navController.navigate(WellnessScreen.Insights.route) }
            )
        }
        composable(WellnessScreen.Insights.route) {
            InsightsScreen(
                onSeeJourneys = { navController.navigate(WellnessScreen.Journeys.route) }
            )
        }
        composable(WellnessScreen.Journeys.route) {
            JourneysScreen(
                onRestartFlow = {
                    navController.navigate(WellnessScreen.Onboarding.route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }
            )
        }
    }
}
