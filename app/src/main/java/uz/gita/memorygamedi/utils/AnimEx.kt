package uz.gita.memorygamedi.utils

import android.widget.ImageView
import uz.gita.memorygamedi.data.model.CarData

fun ImageView.openAnim(block: () -> Unit) {
    this.animate().setDuration(250).rotationY(89f).withEndAction {
        this.rotationY = 91f
        val data = this.tag as CarData
        this.setImageResource(data.imgUrl)
        this.animate().setDuration(250).rotationY(180f).withEndAction {
            block.invoke()
        }.start()
    }.start()
}
