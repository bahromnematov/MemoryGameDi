package uz.gita.memorygamedi.navigation

import androidx.navigation.NavDirections

interface NavigationHandler {
    suspend fun back()
   suspend fun navigationTo(direction: NavDirections)
}