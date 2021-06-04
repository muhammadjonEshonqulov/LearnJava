package uz.mirkomil.learnjava.ui.test.view

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.view.View
import androidx.core.content.ContextCompat
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.base.BaseFragment
import uz.mirkomil.learnjava.databinding.FragmentTestBinding
import uz.mirkomil.learnjava.model.Test
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.test.presenter.TestPresenter

class TestFragment : BaseFragment(R.layout.fragment_test), TestView {

    lateinit var binding: FragmentTestBinding
    lateinit var presenter: TestPresenter
    lateinit var data : ArrayList<Test>
    var current_pos = 0
    @SuppressLint("SetTextI18n")
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
        binding.next.setOnClickListener {
            if (current_pos != data.size-1){
                when(data[current_pos].isCheckd){
                    0 -> {
                        binding.radioBtnTest1.setImageResource(R.drawable.radio_button)
                        binding.radioBtnTest2.setImageResource(R.drawable.radio_button)
                        binding.radioBtnTest3.setImageResource(R.drawable.radio_button)
                        binding.answearA.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                        binding.answearB.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                        binding.answearC.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                    }
                    1 -> {
                        binding.radioBtnTest1.setImageResource(R.drawable.ic_checked_test)
                        binding.answearA.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.correct_back_color))
                        binding.answearB.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                        binding.answearC.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                        binding.radioBtnTest2.setImageResource(R.drawable.radio_button)
                        binding.radioBtnTest3.setImageResource(R.drawable.radio_button)
                    }
                    2 -> {
                        binding.radioBtnTest1.setImageResource(R.drawable.radio_button)
                        binding.answearA.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                        binding.answearC.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                        binding.answearB.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.correct_back_color))
                        binding.radioBtnTest2.setImageResource(R.drawable.ic_checked_test)
                        binding.radioBtnTest3.setImageResource(R.drawable.radio_button)
                    }
                    3 -> {
                        binding.radioBtnTest1.setImageResource(R.drawable.radio_button)
                        binding.radioBtnTest2.setImageResource(R.drawable.radio_button)
                        binding.answearC.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.correct_back_color))
                        binding.answearA.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                        binding.answearB.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
                        binding.radioBtnTest3.setImageResource(R.drawable.ic_checked_test)
                    }
                }
                current_pos += 1
                binding.question.text = data[current_pos].question
                binding.testAnswerTxt1.text = data[current_pos].answearA
                binding.testAnswerTxt2.text = data[current_pos].answearB
                binding.testAnswerTxt3.text = data[current_pos].answearC
                binding.testPos.text = "Savol ${current_pos+1}/"+data.size
            }
//            else {
//                toast("Testni oxiriga yetdingiz!")
//            }
        }
        binding.answearA.setOnClickListener {
            binding.answearA.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.correct_back_color))
            binding.answearB.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
            binding.answearC.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
            binding.radioBtnTest1.setImageResource(R.drawable.ic_checked_test)
            binding.radioBtnTest2.setImageResource(R.drawable.radio_button)
            binding.radioBtnTest3.setImageResource(R.drawable.radio_button)
            data[current_pos].isCheckd = 1

        }
        binding.answearB.setOnClickListener {
            binding.answearA.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
            binding.answearC.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
            binding.answearB.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.correct_back_color))
            binding.radioBtnTest1.setImageResource(R.drawable.radio_button)
            binding.radioBtnTest2.setImageResource(R.drawable.ic_checked_test)
            data[current_pos].isCheckd = 2
            binding.radioBtnTest3.setImageResource(R.drawable.radio_button)
        }
        binding.answearC.setOnClickListener {
            binding.answearA.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
            binding.answearB.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.backgroun_color))
            binding.answearC.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.correct_back_color))
            binding.radioBtnTest1.setImageResource(R.drawable.radio_button)
            binding.radioBtnTest2.setImageResource(R.drawable.radio_button)
            data[current_pos].isCheckd = 3
            binding.radioBtnTest3.setImageResource(R.drawable.ic_checked_test)
        }
        binding.previous.setOnClickListener {
            if (current_pos != 0){
                current_pos -= 1
                binding.question.text = data[current_pos].question
                binding.testAnswerTxt1.text = data[current_pos].answearA
                binding.testAnswerTxt2.text = data[current_pos].answearB
                binding.testAnswerTxt3.text = data[current_pos].answearC
                binding.testPos.text = "Savol ${current_pos+1}/"+data.size
            }
//            else {
//                toast("Testni boshiga yetdingiz!")
//            }
        }
        binding.finishTest.setOnClickListener {

        }
        //  binding.pager.offscreenPageLimit =
    }

    override fun showError(s: String) {
        toast(s)
    }
    val timer = object : CountDownTimer( 61000 ,1000){     // 601000

        @SuppressLint("SetTextI18n")
        override fun onTick(millisUntilFinished: Long) {
          //  time = (61000-millisUntilFinished).toInt()
            binding.timeTest.text =""+ (millisUntilFinished / 60000) /10 +""+(millisUntilFinished / 60000) %10 + ":"+ (( millisUntilFinished % 60000 ) / 1000) / 10 +""+(( millisUntilFinished % 60000 ) / 1000) % 10
        }

        override fun onFinish() {
            toast("Test yechishga berilgan vaqt tugadi..!")
//            finish_dialog = LogoutDialog(requireContext(),"","","","",themeManager.currentTheme)

            finishTest()
        }

    }

    private fun finishTest() {

    }

    @SuppressLint("SetTextI18n")
    override fun getTest(it: List<Test>?) {
        binding.testPos.text = "Savol 1/"+it?.size
        data = ArrayList<Test>()
        it?.let { it1 -> data.addAll(it1) }
        binding.question.text = data[0].question
        binding.testAnswerTxt1.text = data[0].answearA
        binding.testAnswerTxt2.text = data[0].answearB
        binding.testAnswerTxt3.text = data[0].answearC

        timer.start()
    }
}