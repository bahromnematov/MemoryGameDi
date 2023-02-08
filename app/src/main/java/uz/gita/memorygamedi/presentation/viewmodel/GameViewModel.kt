package uz.gita.memorygamedi.presentation.viewmodel

import kotlinx.coroutines.flow.StateFlow
import uz.gita.memorygamedi.data.model.CarData
import uz.gita.memorygamedi.data.model.LevelEnum

interface GameViewModel {
val cardsFlow:StateFlow<List<CarData>>

fun getCardsByLevel(level: LevelEnum)
}