package uz.mirkomil.learnjava.ui.second.view

import android.view.View
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.FragmentSecondBinding
import uz.mirkomil.learnjava.ui.beginner.view.BeginnerFragment
import uz.mirkomil.learnjava.ui.maruza.view.MaruzaFragment
import uz.mirkomil.learnjava.ui.library.view.LibraryFragment
import uz.mirkomil.learnjava.ui.oop.view.OopFragment

class SecondFragment: BaseFragment(R.layout.fragment_second) {

    lateinit var binding:FragmentSecondBinding
    override fun onCreate(view: View) {
        binding = FragmentSecondBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
        binding.beginners.setOnClickListener {
            startFragment(BeginnerFragment(),isAnimate = true)
        }
        binding.oop.setOnClickListener {
            startFragment(OopFragment(),isAnimate = true)
        }
        binding.library.setOnClickListener {
            startFragment(LibraryFragment(),isAnimate = true)
        }
    }
}