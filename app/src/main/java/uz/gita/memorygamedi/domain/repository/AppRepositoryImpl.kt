package uz.gita.memorygamedi.domain.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.gita.memorygamedi.R
import uz.gita.memorygamedi.data.model.CarData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepositoryImpl @Inject constructor() : AppRepository {
    private val cardList = ArrayList<CarData>()

    init {
        cardList.add(CarData(R.drawable.image_1, 1))
        cardList.add(CarData(R.drawable.image_2, 2))
        cardList.add(CarData(R.drawable.image_3, 3))
        cardList.add(CarData(R.drawable.image_4, 4))
        cardList.add(CarData(R.drawable.image_5, 5))
        cardList.add(CarData(R.drawable.image_6, 6))
        cardList.add(CarData(R.drawable.image_7, 7))
        cardList.add(CarData(R.drawable.image_8, 8))
        cardList.add(CarData(R.drawable.image_9, 9))
        cardList.add(CarData(R.drawable.image_10, 10))
        cardList.add(CarData(R.drawable.image_11, 11))
        cardList.add(CarData(R.drawable.image_12, 12))
        cardList.add(CarData(R.drawable.image_13, 13))
        cardList.add(CarData(R.drawable.image_14, 14))
        cardList.add(CarData(R.drawable.image_15, 15))
        cardList.add(CarData(R.drawable.image_16, 16))
        cardList.add(CarData(R.drawable.image_17, 17))
        cardList.add(CarData(R.drawable.image_18, 18))
        cardList.add(CarData(R.drawable.image_19, 19))
        cardList.add(CarData(R.drawable.image_20, 20))
        cardList.add(CarData(R.drawable.image_21, 21))
        cardList.add(CarData(R.drawable.image_22, 22))
        cardList.add(CarData(R.drawable.image_23, 23))
        cardList.add(CarData(R.drawable.image_24, 24))
        cardList.add(CarData(R.drawable.image_25, 25))


    }

    override suspend fun getCardDataByCount(count: Int): List<CarData> = withContext(Dispatchers.IO) {
        cardList.shuffle()
        return@withContext cardList.subList(0,count)

    }
}