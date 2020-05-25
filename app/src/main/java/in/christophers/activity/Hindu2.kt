package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.HinduAdapter2
import `in`.christophers.databinding.ActivityHindu2Binding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class Hindu2 : AppCompatActivity() {

    private lateinit var binding : ActivityHindu2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_hindu2)

        binding.hinduRcv.layoutManager = LinearLayoutManager(this)
        binding.back.setOnClickListener {
            onBackPressed()
        }

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = HinduAdapter2(list,this)
        binding.hinduRcv.adapter = adapter
        adapter.notifyDataSetChanged()

    }
}
