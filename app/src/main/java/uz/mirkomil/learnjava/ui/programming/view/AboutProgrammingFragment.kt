package uz.mirkomil.learnjava.ui.programming.view

import android.view.View
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.FragmentAboutProgrammigBinding

class AboutProgrammingFragment : BaseFragment(R.layout.fragment_about_programmig) {

    lateinit var binding: FragmentAboutProgrammigBinding
    override fun onCreate(view: View) {
        binding = FragmentAboutProgrammigBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
    }
}