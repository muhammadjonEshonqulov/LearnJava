package uz.mirkomil.learnjava.ui.beginner.view

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.FragmentBeginnerBinding

class BeginnerFragment : BaseFragment(R.layout.fragment_beginner) {


    lateinit var adapter: BeginnerAdapter
    lateinit var binding: FragmentBeginnerBinding

    override fun onCreate(view: View) {
        binding = FragmentBeginnerBinding.bind(view)
        adapter = BeginnerAdapter()
        binding.beginnerLessons.layoutManager = LinearLayoutManager(requireContext())
        binding.beginnerLessons.adapter = adapter
        adapter.swapdata(getLessons())
        binding.backBtnHelp.setOnClickListener {
            finish()
        }
    }

    fun getLessons(): ArrayList<String> {
        val data = ArrayList<String>()
        data.clear()
        for (i in 1..30) {
            data.add("$i - Dars")
        }

        return data
    }
}