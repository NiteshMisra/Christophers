package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.databinding.ActivityBlogDetailBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil

class BlogDetail : AppCompatActivity() {

    private lateinit var binding : ActivityBlogDetailBinding
    private lateinit var desc : String
    private var isShowMore : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_blog_detail)
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        desc = binding.desc.text.toString()
        binding.continueReading.text = ("Continue Reading +")
        isShowMore = true
        binding.desc.text = (desc.substring(0,desc.length/2) + "...")

        binding.continueReading.setOnClickListener {
            if (isShowMore){
                binding.continueReading.text = ("Show Less -")
                isShowMore = false
                binding.desc.text = desc
            }else{
                binding.continueReading.text = ("Continue Reading +")
                isShowMore = true
                binding.desc.text = (desc.substring(0,desc.length/2) + "...")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
