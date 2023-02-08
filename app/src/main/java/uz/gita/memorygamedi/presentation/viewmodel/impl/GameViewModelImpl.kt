package uz.gita.memorygamedi.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.memorygamedi.data.model.CarData
import uz.gita.memorygamedi.domain.usecase.GetCardUseCase
import uz.gita.memorygamedi.presentation.viewmodel.GameViewModel
import uz.gita.memorygamedi.data.model.LevelEnum
import javax.inject.Inject
@HiltViewModel
class GameViewModelImpl @Inject constructor(private val useCase: GetCardUseCase):ViewModel(),GameViewModel {

    override val cardsFlow= MutableStateFlow<List<CarData>>(emptyList())

    override fun getCardsByLevel(level: LevelEnum) {
        useCase.getCardsByLevel(level).onEach {
            cardsFlow.emit(it)
        }.launchIn(viewModelScope)
    }


}