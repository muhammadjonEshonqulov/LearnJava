package uz.mirkomil.learnjava.ui.lesson.view

import android.view.View
import androidx.core.os.bundleOf
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentLessonBinding
import uz.mirkomil.learnjava.model.Test
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.lesson.presenter.LessonPresenter
import uz.mirkomil.learnjava.ui.maruza.view.MaruzaFragment
import uz.mirkomil.learnjava.ui.test.view.TestFragment

class LessonFragment : BaseFragment(R.layout.fragment_lesson), LessonView {

    lateinit var binding: FragmentLessonBinding
    lateinit var presenter: LessonPresenter
    var lessonId = 0
    var subjectId = 0

    override fun onCreate(view: View) {
        binding = FragmentLessonBinding.bind(view)
        presenter = LessonPresenter(this, Repository.getRepositoryWithApiClient(requireContext()))
        presenter.saveTest(getTestAll())
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
            val bundle = bundleOf("lesson_id" to lessonId, "subject_id" to subjectId)
            startFragment(TestFragment(),bundle, isAnimate = true)
        }
        binding.maruza.setOnClickListener {
            val bundle = bundleOf("lesson_id" to lessonId, "subject_id" to subjectId)
            startFragment(MaruzaFragment(), bundle, isAnimate = true)
        }
    }

    fun getTestAll() : ArrayList<Test>{
        val data  = ArrayList<Test>()
        data.add(Test(1,1, 1, "jdk nima", "Java Runtime Environment ", "Java Development Kit (Java dashturlash uskunasi)", "dasturlash muhiti","2"))
        data.add(Test(2,1, 1, "Jdk ni qaysi operatsion tizimlarga yuklasa buladi", "Android operatsion tizim ", "Linux OT", "hamma operatsion tizimlarga","3"))
        data.add(Test(3,1, 1, "jdk qaysi faylda saqlanadi", "d:/program files/java/bin", "c:/program files/java/bin", "c. hech faylda sqalanmaydi,","2"))

        data.add(Test(4,1, 2, "Netbeans nima", "dasturlash muhiti", "dasturlash tili", "komponenta","1"))
        data.add(Test(5,1, 2, "Netbeans qachon ishlab chiqilgan", "1988", "1996","2000","2"))
        data.add(Test(6,1, 2, "Netbeans qaysi dasturlash tillarini qullab quvatlaydi.", "python,html,css", "PHP,c,c++,java","java ,python","2"))
        data.add(Test(7,1, 2, "Netbeans qaysi davlatda paydo bo’lgan", "Rossiya", " CHexiya","Aqsh","2"))
        data.add(Test(8,1, 2, "U 90-yillarning oxirida qaysi korxona tomonidan sotib olingan ", "Sun Microsystems", "Apple","Amazon","1"))

//        data.add(Test(1,2, 5, "", "", "","","2"))

        return data
    }
    override fun showError(s: String) {
        toast(s)
    }

}