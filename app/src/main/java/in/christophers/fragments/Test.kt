package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.adapter.TestAdapter
import `in`.christophers.databinding.FragmentTestBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager

class Test : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private lateinit var mainActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity = requireActivity()
        binding.rcv.layoutManager = GridLayoutManager(mainActivity, 2)


        val list: ArrayList<Int> = ArrayList()
        for (i in 0..15) {
            list.add(i)
        }

        val adapter = TestAdapter(list, mainActivity)
        binding.rcv.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
