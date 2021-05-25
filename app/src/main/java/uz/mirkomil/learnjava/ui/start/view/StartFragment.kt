package uz.mirkomil.learnjava.ui.start.view

import android.view.View
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.FragmentStartBinding
import uz.mirkomil.learnjava.ui.author.view.HistoryOfJavaFragment
import uz.mirkomil.learnjava.ui.programming.view.AboutProgrammingFragment
import uz.mirkomil.learnjava.ui.second.view.SecondFragment


class StartFragment : BaseFragment(R.layout.fragment_start, canswipe = true), View.OnClickListener {
    var downloadedSize = 0
    var totalsize: Int = 0
    lateinit var binding: FragmentStartBinding
    var per = 0f
    override fun onCreate(view: View) {
        binding = FragmentStartBinding.bind(view)
        binding.aboutProgramming.setOnClickListener(this)
        binding.historyOfJava.setOnClickListener(this)
        binding.start.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.about_programming -> {
                startFragment(AboutProgrammingFragment(), isAnimate = true)
            }
            R.id.history_of_java -> {
                startFragment(HistoryOfJavaFragment(), isAnimate = true)
            }
            R.id.start -> {
                startFragment(SecondFragment(), isAnimate = true)
            }
        }
    }

}
