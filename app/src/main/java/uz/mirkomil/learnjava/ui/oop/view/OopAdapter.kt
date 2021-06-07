package uz.mirkomil.learnjava.ui.oop.view

import android.annotation.SuppressLint
import android.view.View
import uz.intalim.ui.base.SingleTypeAdapter
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.ItemBeginnerBinding
import uz.mirkomil.learnjava.model.LessonData

class OopAdapter : SingleTypeAdapter<LessonData>(R.layout.item_beginner, ArrayList()) {

    lateinit var binding: ItemBeginnerBinding
    var listener: ((Int, String) -> Unit)? = null

    fun setOnclick(listener: ((Int, String) -> Unit)?){
        this.listener = listener
    }

    @SuppressLint("SetTextI18n")
    override fun bindData(itemView: View, position: Int) {
        binding = ItemBeginnerBinding.bind(itemView)
        binding.itemName.text = ""+(position+1)+"-Dars. "+data[position].tittle
        binding.itemBack.setOnClickListener {
            listener?.invoke(position,data[position].tittle)
        }
    }
}