package uz.mirkomil.learnjava.ui.maruza.view

import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.FragmentBeginnerBinding
import uz.mirkomil.learnjava.databinding.FragmentMaruzaBinding
import uz.mirkomil.learnjava.model.LessonData
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.beginner.view.MaruzaView
import uz.mirkomil.learnjava.ui.maruza.presenter.MaruzaPresenter
import uz.mirkomil.learnjava.ui.lesson.view.LessonFragment

class MaruzaFragment : BaseFragment(R.layout.fragment_maruza), MaruzaView {


    lateinit var adapter: MaruzaAdapter
    lateinit var binding: FragmentMaruzaBinding
    lateinit var presenter: MaruzaPresenter

    override fun onCreate(view: View) {
        binding = FragmentMaruzaBinding.bind(view)
        presenter = MaruzaPresenter(this, Repository.getRepositoryWithApiClient(requireContext()))

        arguments?.getInt("lesson_id")?.let {
            presenter.getLessonData(it)
        }

        binding.backBtnHelp.setOnClickListener {
            finish()
        }
    }

    override fun showError(message: String) {
        toast(message)
    }

    override fun savedLesson(data: List<LessonData>) {
        adapter =MaruzaAdapter()
        binding.listMaruza.layoutManager = LinearLayoutManager(requireContext())
        binding.listMaruza.adapter = adapter
        val list = ArrayList<LessonData>()
        list.addAll(data)
        Log.d("TTT", "l"+list.size)
        Log.d("TTT", "d"+data.size)
        adapter.swapdata(list)
    }
}