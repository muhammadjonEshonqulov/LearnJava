package uz.mirkomil.learnjava.ui.beginner.view

import android.view.View
import uz.intalim.ui.base.SingleTypeAdapter
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.ItemBeginnerBinding

class BeginnerAdapter : SingleTypeAdapter<String>(R.layout.item_beginner, ArrayList()) {

    lateinit var binding: ItemBeginnerBinding
    var listener: ((Int) -> Unit)? = null

    fun setOnclick(listener: ((Int) -> Unit)?){
        this.listener = listener
    }

    override fun bindData(itemView: View, position: Int) {
        binding = ItemBeginnerBinding.bind(itemView)
        binding.itemName.text = data[position]
        binding.itemBack.setOnClickListener {
            listener?.invoke(position)
        }
    }
}