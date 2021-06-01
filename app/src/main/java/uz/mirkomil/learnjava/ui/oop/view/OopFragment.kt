package uz.mirkomil.learnjava.ui.oop.view

import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentOopBinding
import uz.mirkomil.learnjava.ui.lesson.view.LessonFragment

class OopFragment : BaseFragment(R.layout.fragment_oop) {

    lateinit var binding: FragmentOopBinding
    lateinit var adapter: OopAdapter
    override fun onCreate(view: View) {
        binding = FragmentOopBinding.bind(view)
        adapter = OopAdapter()
        binding.listOop.layoutManager = LinearLayoutManager(requireContext())
        binding.listOop.adapter = adapter
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
        for (i in 1..11) {
            data.add("$i - Dars")
        }
        return data
    }
}