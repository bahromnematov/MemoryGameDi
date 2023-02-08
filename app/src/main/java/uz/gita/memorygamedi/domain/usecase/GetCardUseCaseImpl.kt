package uz.gita.memorygamedi.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.memorygamedi.data.model.CarData
import uz.gita.memorygamedi.domain.repository.AppRepository
import uz.gita.memorygamedi.data.model.LevelEnum
import javax.inject.Inject

class GetCardUseCaseImpl @Inject constructor(private val repository: AppRepository) :
    GetCardUseCase {

    override fun getCardsByLevel(level: LevelEnum): Flow<List<CarData>> = flow {
        val mustCardCount = (level.horCount * level.verCount) / 2
        val list = repository.getCardDataByCount(mustCardCount)
        val result = ArrayList<CarData>()
        result.addAll(list)
        result.addAll(list)
        result.shuffle()
        emit(result)
    }
}