package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.adapter.TotalPointsAdapter
import `in`.christophers.databinding.FragmentTotalPointsBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager

class TotalPoints : Fragment() {

    private lateinit var binding : FragmentTotalPointsBinding
    private lateinit var mainActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_total_points, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = requireActivity()

        binding.totalPointsRcv.layoutManager = LinearLayoutManager(mainActivity)

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = TotalPointsAdapter(list,mainActivity)
        binding.totalPointsRcv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
