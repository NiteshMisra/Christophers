package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.CourseItemAdapter2
import `in`.christophers.databinding.ActivityCourse2Binding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class Course2 : AppCompatActivity() {

    private lateinit var binding : ActivityCourse2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_course2)

        binding.courseRcv.layoutManager = LinearLayoutManager(this)
        binding.courseRcv.setHasFixedSize(true)
        binding.back.setOnClickListener {
            onBackPressed()
        }

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = CourseItemAdapter2(list,this)
        binding.courseRcv.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
