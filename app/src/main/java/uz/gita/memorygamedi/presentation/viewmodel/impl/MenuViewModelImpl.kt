package uz.gita.memorygamedi.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.memorygamedi.data.model.LevelEnum
import uz.gita.memorygamedi.navigation.NavigationHandler
import uz.gita.memorygamedi.presentation.ui.screens.MenuScreenDirections
import uz.gita.memorygamedi.presentation.viewmodel.MenuViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModelImpl @Inject constructor(private val navigationHandler: NavigationHandler) :
    ViewModel(), MenuViewModel {

    override fun selectLevel(level: LevelEnum) {
        viewModelScope.launch {
            val direction = MenuScreenDirections.actionMenuScreenToGameScreen()
            direction.levels=level
            navigationHandler.navigationTo(direction)
        }
    }
}