package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.AllBlogsAdapter
import `in`.christophers.adapter.VideoAdapter
import `in`.christophers.databinding.ActivityVideoBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class Video : AppCompatActivity() {

    private var selectedPosition = 0
    private lateinit var binding : ActivityVideoBinding
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var list : ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_video)

        binding.videoRcv.layoutManager = LinearLayoutManager(this)

        list = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        videoAdapter = VideoAdapter(list,selectedPosition,this)
        binding.videoRcv.adapter = videoAdapter
        videoAdapter.notifyDataSetChanged()
    }

    fun rcvClick(position : Int){
        selectedPosition = position
        videoAdapter = VideoAdapter(list,selectedPosition,this)
        binding.videoRcv.adapter = videoAdapter
        videoAdapter.notifyDataSetChanged()
    }
}
