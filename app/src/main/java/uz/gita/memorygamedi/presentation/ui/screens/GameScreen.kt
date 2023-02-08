package uz.gita.memorygamedi.presentation.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import uz.gita.memorygamedi.R
import uz.gita.memorygamedi.data.model.CarData
import uz.gita.memorygamedi.databinding.ScreenGameBinding
import uz.gita.memorygamedi.presentation.viewmodel.GameViewModel
import uz.gita.memorygamedi.presentation.viewmodel.impl.GameViewModelImpl
import uz.gita.memorygamedi.utils.myApply
import uz.gita.memorygamedi.utils.myLog
import uz.gita.memorygamedi.utils.openAnim
import uz.gita.memorygamedi.data.model.LevelEnum

@AndroidEntryPoint
class GameScreen : Fragment(R.layout.screen_game) {
    private val viewModel: GameViewModel by viewModels<GameViewModelImpl>()
    private val binding by viewBinding(ScreenGameBinding::bind)
    private val navArg by navArgs<GameScreenArgs>()
    private var level = LevelEnum.EASY
    private var _hight = 0
    private var _width = 0
    private var isEnabled = true
    private var count = 0
    private lateinit var firstData: CarData
    private lateinit var secondData: CarData
    private val images = ArrayList<ImageView>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        level = navArg.levels
        main.post {
            _hight = space.height / level.verCount
            _width = space.width / level.horCount
            viewModel.getCardsByLevel(level)
        }
        viewModel.cardsFlow.onEach {
            describeImages(it)
        }
    }

    private fun describeImages(list: List<CarData>) {
        if (list.isEmpty())
            return
        for (i in 0 until level.verCount) {
            for (j in 0 until level.horCount) {
                val imageView = ImageView(requireContext())
                imageView.tag = list[i * level.horCount + j]
                binding.container.addView(imageView)
                val lp = imageView.layoutParams as ConstraintLayout.LayoutParams
                lp.apply {
                    this.height = _hight
                    this.width = _width
                }
                lp.setMargins(4, 4, 4, 4)
                imageView.layoutParams = lp
                imageView.x = (j * _width).toFloat()
                imageView.y = (i * _hight).toFloat()
                imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                imageView.setImageResource(R.drawable.image_back)
                images.add(imageView)

                val data = list[i * level.horCount + j]
                myLog("($i: $j) ${data.amount} ->  ${data.imgUrl}")
            }
        }
        addClickListener()
    }

    private fun addClickListener() {
        images.forEach { view ->
            view.setOnClickListener {
                if (!isEnabled || it.rotationY == 180f) return@setOnClickListener
                if (count == 0) {
                    firstData = view.tag as CarData
                    count++
                } else if (count == 1) {
                    secondData = view.tag as CarData
                    count++
                    isEnabled = false
                }
                view.openAnim {
                    if (count == 2)
                        Toast.makeText(
                            requireContext(),
                            "${secondData.amount == firstData.amount}",
                            Toast.LENGTH_SHORT
                        ).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        images.clear()
    }


}