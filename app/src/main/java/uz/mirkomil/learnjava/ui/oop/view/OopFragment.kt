package uz.mirkomil.learnjava.ui.oop.view

import android.view.View
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentOopBinding

class OopFragment : BaseFragment(R.layout.fragment_oop) {

    lateinit var binding: FragmentOopBinding
    override fun onCreate(view: View) {
        binding = FragmentOopBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
    }
}