package uz.mirkomil.learnjava.ui.lesson.view

import android.view.View
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentLessonBinding
import uz.mirkomil.learnjava.databinding.FragmentOopBinding

class LessonFragment : BaseFragment(R.layout.fragment_lesson) {

    lateinit var binding: FragmentLessonBinding
    override fun onCreate(view: View) {
        binding = FragmentLessonBinding.bind(view)
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
        arguments?.getString("lesson_name")?.let {
            binding.titleHelp.text = it
            binding.lessonName.text = it
        }
    }
}