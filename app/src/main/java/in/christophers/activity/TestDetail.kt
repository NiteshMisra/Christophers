package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.TestDetailAdapter
import `in`.christophers.databinding.ActivityTestDetailBinding
import `in`.christophers.model.TestDetailModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

class TestDetail : AppCompatActivity() {

    private lateinit var binding : ActivityTestDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_test_detail)

        binding.back.setOnClickListener {
            onBackPressed()
        }
        binding.courseRcv.layoutManager = LinearLayoutManager(this)

        val list : ArrayList<TestDetailModel> = ArrayList()
        for (i in 0..5){
            val list2 : ArrayList<Boolean> = ArrayList()
            for (j in 0..3){
                if (j%2 == 0){
                    list2.add(true)
                }else{
                    list2.add(false)
                }
            }
            list.add(TestDetailModel("April 20${20 + i}",list2))
        }

        val testDetailAdapter = TestDetailAdapter(list,this)
        binding.courseRcv.adapter = testDetailAdapter
        testDetailAdapter.notifyDataSetChanged()
    }
}
