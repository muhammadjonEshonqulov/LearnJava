package uz.mirkomil.learnjava.ui.author.view

import android.view.View
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.FragmentAuthorBinding

class HistoryOfJavaFragment : BaseFragment(R.layout.fragment_author) {

    lateinit var binding: FragmentAuthorBinding
    override fun onCreate(view: View) {
        binding = FragmentAuthorBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
    }
}