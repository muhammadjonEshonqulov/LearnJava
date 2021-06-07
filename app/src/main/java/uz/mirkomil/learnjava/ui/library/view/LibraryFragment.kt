package uz.mirkomil.learnjava.ui.library.view

import android.text.method.LinkMovementMethod
import android.view.View
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentLibraryBinding
import uz.mirkomil.learnjava.databinding.FragmentOopBinding

class LibraryFragment : BaseFragment(R.layout.fragment_library) {

    lateinit var binding: FragmentLibraryBinding
    override fun onCreate(view: View) {
        binding = FragmentLibraryBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
        binding.link1.setMovementMethod(LinkMovementMethod.getInstance())
        binding.link2.setMovementMethod(LinkMovementMethod.getInstance())
    }
}