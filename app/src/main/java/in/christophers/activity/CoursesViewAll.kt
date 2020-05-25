package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.CoursesViewAllAdapter
import `in`.christophers.databinding.ActivityCoursesViewAllBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager

class CoursesViewAll : AppCompatActivity() {

    private lateinit var binding : ActivityCoursesViewAllBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_courses_view_all)

        binding.viewAllRcv.layoutManager = GridLayoutManager(this,2)
        binding.back.setOnClickListener {
            onBackPressed()
        }

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = CoursesViewAllAdapter(list,this)
        binding.viewAllRcv.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}
