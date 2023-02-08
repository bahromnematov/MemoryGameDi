package uz.gita.memorygamedi.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.memorygamedi.navigation.NavigationHandler
import uz.gita.memorygamedi.presentation.ui.screens.SplashScreen
import uz.gita.memorygamedi.presentation.ui.screens.SplashScreenDirections
import uz.gita.memorygamedi.presentation.viewmodel.SplashViewModel
import javax.inject.Inject

class SplashViewModelImpl @Inject constructor(private val navigationHandler: NavigationHandler):ViewModel(),SplashViewModel {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1500)
            navigationHandler.navigationTo(SplashScreenDirections.actionSplashScreenToMenuScreen())
        }
    }
}