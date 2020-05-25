package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.AllBlogsAdapter
import `in`.christophers.adapter.CourseItemAdapter
import `in`.christophers.databinding.ActivityCourseBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class Course : AppCompatActivity() {

    private lateinit var binding : ActivityCourseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_course)

        binding.courseRcv.layoutManager = LinearLayoutManager(this)
        binding.courseRcv.setHasFixedSize(true)
        binding.back.setOnClickListener {
            onBackPressed()
        }

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = CourseItemAdapter(list,this)
        binding.courseRcv.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}
