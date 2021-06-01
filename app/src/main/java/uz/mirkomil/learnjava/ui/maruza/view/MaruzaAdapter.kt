package uz.mirkomil.learnjava.ui.maruza.view

import android.view.View
import uz.intalim.ui.base.SingleTypeAdapter
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.ItemBeginnerBinding
import uz.mirkomil.learnjava.databinding.ItemLessonBinding
import uz.mirkomil.learnjava.model.LessonData

class MaruzaAdapter : SingleTypeAdapter<LessonData>(R.layout.item_lesson, ArrayList()) {

    lateinit var binding: ItemLessonBinding
    var listener: ((Int) -> Unit)? = null

    fun setOnclick(listener: ((Int) -> Unit)?){
        this.listener = listener
    }

    override fun bindData(itemView: View, position: Int) {
        binding = ItemLessonBinding.bind(itemView)
        binding.textLesson.text = data[position].text
        data[position].imgUrl?.let {
            binding.imageLesson.visibility = View.VISIBLE
            binding.imageLesson.setImageResource(it)
        }
    }
}