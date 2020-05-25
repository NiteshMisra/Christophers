package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.AllVideosAdapter
import `in`.christophers.databinding.ActivityAllVideosBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class AllVideos : AppCompatActivity() {

    private lateinit var binding : ActivityAllVideosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_all_videos)

        binding.allVideoRcv.layoutManager = LinearLayoutManager(this)
        binding.back.setOnClickListener {
            onBackPressed()
        }

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..16){
            list.add(i)
        }

        val adapter = AllVideosAdapter(list,this)
        binding.allVideoRcv.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}
