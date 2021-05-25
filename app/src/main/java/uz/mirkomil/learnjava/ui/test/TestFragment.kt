package uz.mirkomil.learnjava.ui.test

import android.view.View
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentTestBinding

class TestFragment : BaseFragment(R.layout.fragment_test) {

    lateinit var binding: FragmentTestBinding
    override fun onCreate(view: View) {
        binding = FragmentTestBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
    }
}