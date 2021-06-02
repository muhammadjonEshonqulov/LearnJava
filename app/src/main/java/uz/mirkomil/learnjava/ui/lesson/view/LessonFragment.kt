package uz.mirkomil.learnjava.ui.lesson.view

import android.view.View
import androidx.core.os.bundleOf
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentLessonBinding
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.lesson.presenter.LessonPresenter
import uz.mirkomil.learnjava.ui.maruza.view.MaruzaFragment
import uz.mirkomil.learnjava.ui.test.TestFragment

class LessonFragment : BaseFragment(R.layout.fragment_lesson), LessonView {

    lateinit var binding: FragmentLessonBinding
    lateinit var presenter: LessonPresenter
    var lessonId = 0
    var subjectId = 0

    override fun onCreate(view: View) {
        binding = FragmentLessonBinding.bind(view)
        presenter = LessonPresenter(this, Repository.getRepositoryWithApiClient(requireContext()))
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
        arguments?.getInt("lesson_id")?.let {
            binding.titleHelp.text = "$it- Dars"
            lessonId = it
        }
        arguments?.getInt("subject_id")?.let {
            subjectId = it
        }

        binding.test.setOnClickListener {
            startFragment(TestFragment(), isAnimate = true)
        }
        binding.maruza.setOnClickListener {
            val bundle = bundleOf("lesson_id" to lessonId, "subject_id" to subjectId)
            startFragment(MaruzaFragment(), bundle, isAnimate = true)
        }
    }

    override fun showError(s: String) {
        toast(s)
    }

}