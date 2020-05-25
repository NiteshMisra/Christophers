package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.adapter.StoreAdapter
import `in`.christophers.databinding.FragmentStore2Binding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.GridLayoutManager

class Store2 : Fragment() {

    private lateinit var binding: FragmentStore2Binding
    private lateinit var storeActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store2, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        storeActivity = requireActivity()

        binding.storeRcv.layoutManager = GridLayoutManager(storeActivity, 2)
        binding.storeRcv.setHasFixedSize(true)

        val list: ArrayList<Int> = ArrayList()
        for (i in 0..15) {
            list.add(i)
        }

        val storeAdapter = StoreAdapter(list, storeActivity)
        binding.storeRcv.adapter = storeAdapter
        storeAdapter.notifyDataSetChanged()
    }

}
