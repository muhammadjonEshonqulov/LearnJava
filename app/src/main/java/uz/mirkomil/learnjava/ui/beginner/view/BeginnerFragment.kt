package uz.mirkomil.learnjava.ui.beginner.view

import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.FragmentBeginnerBinding
import uz.mirkomil.learnjava.ui.lesson.view.LessonFragment

class BeginnerFragment : BaseFragment(R.layout.fragment_beginner) {


    lateinit var adapter: BeginnerAdapter
    lateinit var binding: FragmentBeginnerBinding

    override fun onCreate(view: View) {
        binding = FragmentBeginnerBinding.bind(view)
        adapter = BeginnerAdapter()
        binding.beginnerLessons.layoutManager = LinearLayoutManager(requireContext())
        binding.beginnerLessons.adapter = adapter
        adapter.swapdata(getLessons())
        adapter.setOnclick {
            val bundleLesson = bundleOf("lesson_name" to it)
            startFragment(LessonFragment(), isAnimate = true,bundle = bundleLesson )
        }
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
    }

    fun getLessons(): ArrayList<String> {
        val data = ArrayList<String>()
        data.clear()
        for (i in 1..15) {
            data.add("$i - Dars")
        }

        return data
    }
}