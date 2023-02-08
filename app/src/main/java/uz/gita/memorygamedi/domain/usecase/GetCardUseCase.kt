package uz.gita.memorygamedi.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.memorygamedi.data.model.CarData
import uz.gita.memorygamedi.data.model.LevelEnum

interface GetCardUseCase {
    fun  getCardsByLevel(level: LevelEnum): Flow<List<CarData>>
}