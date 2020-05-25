package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.AllBlogsAdapter
import `in`.christophers.databinding.ActivityAllBlogsBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class AllBlogs : AppCompatActivity() {

    private lateinit var binding : ActivityAllBlogsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_all_blogs)

        binding.allVideoRcv.layoutManager = LinearLayoutManager(this)

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = AllBlogsAdapter(list,this)
        binding.allVideoRcv.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
