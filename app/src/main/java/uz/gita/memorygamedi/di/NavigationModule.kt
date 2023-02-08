package uz.gita.memorygamedi.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.memorygamedi.navigation.AppNavigationManager
import uz.gita.memorygamedi.navigation.AppNavigator
import uz.gita.memorygamedi.navigation.NavigationHandler
import uz.gita.memorygamedi.presentation.viewmodel.impl.GameViewModelImpl

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    fun bindsAppNavigator(impl: AppNavigationManager): AppNavigator

    @Binds
    fun bindsNavigationHandler(impl:AppNavigationManager):NavigationHandler
}