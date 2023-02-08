package uz.gita.memorygamedi.presentation.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.memorygamedi.R
import uz.gita.memorygamedi.data.model.LevelEnum
import uz.gita.memorygamedi.databinding.ScreenMenuBinding
import uz.gita.memorygamedi.presentation.viewmodel.MenuViewModel
import uz.gita.memorygamedi.presentation.viewmodel.impl.MenuViewModelImpl
import uz.gita.memorygamedi.utils.myApply

@AndroidEntryPoint
class MenuScreen : Fragment(R.layout.screen_menu) {
    private val binding by viewBinding(ScreenMenuBinding::bind)
    private val viewModel: MenuViewModel by viewModels<MenuViewModelImpl>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        easy.setOnClickListener { viewModel.selectLevel(LevelEnum.EASY) }
        medium.setOnClickListener { viewModel.selectLevel(LevelEnum.MEDIUM) }
        hard.setOnClickListener { viewModel.selectLevel(LevelEnum.HARD) }
    }

}