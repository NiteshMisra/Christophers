package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.adapter.HinduPracticeAdapter
import `in`.christophers.adapter.PracticeAdapter
import `in`.christophers.databinding.FragmentHinduPracticeBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity

class HinduPractice : Fragment() {

    private lateinit var binding : FragmentHinduPracticeBinding
    private lateinit var hinduActivity : FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_hindu_practice, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hinduActivity = requireActivity()

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = HinduPracticeAdapter(list)
        binding.practiceRcv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
