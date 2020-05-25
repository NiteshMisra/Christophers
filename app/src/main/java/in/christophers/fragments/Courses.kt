package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.activity.CoursesViewAll
import `in`.christophers.activity.Hindu1
import `in`.christophers.activity.MainActivity
import `in`.christophers.adapter.CourseAdapter
import `in`.christophers.databinding.FragmentCoursesBinding
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

class Courses : Fragment() {

    private lateinit var binding : FragmentCoursesBinding
    private lateinit var mainActivity : FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_courses, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainActivity = requireActivity()
        binding.rcv.layoutManager = LinearLayoutManager(mainActivity,RecyclerView.HORIZONTAL,false)

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..10){
            list.add(i)
        }

        val cAdapter = CourseAdapter(list,mainActivity)
        binding.rcv.adapter = cAdapter
        cAdapter.notifyDataSetChanged()

        binding.viewAll2.setOnClickListener {
            startActivity(Intent(mainActivity,CoursesViewAll::class.java))
        }

        binding.accessNow.setOnClickListener {
            startActivity(Intent(mainActivity, Hindu1::class.java))
        }

        binding.referAndEarn.setOnClickListener {
            if (mainActivity is MainActivity){
                (mainActivity as MainActivity).navigateToStore()
            }
        }

    }

}
