package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.activity.AllBlogs
import `in`.christophers.activity.Hindu1
import `in`.christophers.activity.MainActivity
import `in`.christophers.adapter.BlogsAdapter
import `in`.christophers.databinding.FragmentBlogsBinding
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Blogs : Fragment() {

    private lateinit var binding: FragmentBlogsBinding
    private lateinit var mainActivity : FragmentActivity

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_blogs, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = requireActivity()

        binding.videoRcv.layoutManager = LinearLayoutManager(mainActivity,
            RecyclerView.HORIZONTAL,false)
        binding.videoRcv.setHasFixedSize(true)

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val vAdapter = BlogsAdapter(list,mainActivity)
        binding.videoRcv.adapter = vAdapter
        vAdapter.notifyDataSetChanged()

        binding.viewAll.setOnClickListener {
            startActivity(Intent(mainActivity,AllBlogs::class.java))
        }

        binding.accessNow.setOnClickListener {
            startActivity(Intent(mainActivity,Hindu1::class.java))
        }

        binding.referAndEarn.setOnClickListener {
            if (mainActivity is MainActivity){
                (mainActivity as MainActivity).navigateToStore()
            }
        }

    }

}
