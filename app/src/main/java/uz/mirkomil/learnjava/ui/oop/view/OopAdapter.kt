package uz.mirkomil.learnjava.ui.oop.view

import android.view.View
import uz.intalim.ui.base.SingleTypeAdapter
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.ItemBeginnerBinding

class OopAdapter : SingleTypeAdapter<String>(R.layout.item_beginner, ArrayList()) {

    lateinit var binding: ItemBeginnerBinding
    var listener: ((String) -> Unit)? = null

    fun setOnclick(listener: ((String) -> Unit)?){
        this.listener = listener
    }

    override fun bindData(itemView: View, position: Int) {
        binding = ItemBeginnerBinding.bind(itemView)
        binding.itemName.text = data[position]
        binding.itemBack.setOnClickListener {
            listener?.invoke(data[position])
        }
    }
}