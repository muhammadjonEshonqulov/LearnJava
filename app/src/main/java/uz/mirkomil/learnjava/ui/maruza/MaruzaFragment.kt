package uz.mirkomil.learnjava.ui.maruza

import android.view.View
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentMaruzaBinding

class MaruzaFragment : BaseFragment(R.layout.fragment_maruza) {


    lateinit var binding: FragmentMaruzaBinding

    override fun onCreate(view: View) {
        binding = FragmentMaruzaBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
    }
}