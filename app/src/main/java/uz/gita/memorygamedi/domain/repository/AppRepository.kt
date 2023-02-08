package uz.gita.memorygamedi.domain.repository

import uz.gita.memorygamedi.data.model.CarData

interface AppRepository {
    suspend fun getCardDataByCount(count: Int): List<CarData>
}