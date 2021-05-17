package uz.mirkomil.learnjava.ui.second.view

import android.view.View
import uz.intalim.ui.base.BaseFragment
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.FragmentSecondBinding
import uz.mirkomil.learnjava.ui.beginner.view.BeginnerFragment

class SecondFragment:BaseFragment(R.layout.fragment_second) {

    lateinit var binding:FragmentSecondBinding
    override fun onCreate(view: View) {
        binding = FragmentSecondBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
        binding.beginners.setOnClickListener {
            startFragment(BeginnerFragment(),isAnimate = true)
        }
    }
}