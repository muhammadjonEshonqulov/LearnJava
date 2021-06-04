package uz.mirkomil.learnjava.ui.test.view

import android.view.View
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentTestBinding
import uz.mirkomil.learnjava.model.Test
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.test.presenter.TestPresenter

class TestFragment : BaseFragment(R.layout.fragment_test), TestView {

    lateinit var binding: FragmentTestBinding
    lateinit var presenter:TestPresenter

    override fun onCreate(view: View) {
        binding = FragmentTestBinding.bind(view)
        presenter = TestPresenter(this, Repository.getRepositoryWithApiClient(requireContext()))
        arguments?.getInt("lesson_id")?.let { lesson_id ->
            arguments?.getInt("subject_id")?.let { subject_id ->
                presenter.getTest(subject_id, lesson_id)
            }
        }
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
      //  binding.pager.offscreenPageLimit =
    }

    override fun showError(s: String) {
        toast(s)
    }

    override fun getTest(it: List<Test>?) {
        it?.size?.let {
            binding.pager.offscreenPageLimit = it
        }

    }
}