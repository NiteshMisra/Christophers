package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.adapter.TabAdapter
import `in`.christophers.databinding.ActivityCourseDetailBinding
import `in`.christophers.fragments.Lectures
import `in`.christophers.fragments.PdfNotes
import `in`.christophers.fragments.Practice
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import android.widget.ImageView
import carbon.widget.LinearLayout
import com.google.android.material.tabs.TabLayout

class CourseDetail : AppCompatActivity() {

    private lateinit var binding : ActivityCourseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_course_detail)

        binding.back.setOnClickListener {
            onBackPressed()
        }

        val adapter = TabAdapter(supportFragmentManager)
        adapter.addFragment(Lectures(),"Lectures")
        adapter.addFragment(PdfNotes(),"Pdf Notes")
        adapter.addFragment(Practice(),"Practice")

        binding.detailViewPager.adapter = adapter

        binding.detailTab.setupWithViewPager(binding.detailViewPager)

        val headerView = (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.tab_items,null,false)
        val tabCard1 : LinearLayout = headerView.findViewById(R.id.tab1)
        val tabCard2 : LinearLayout = headerView.findViewById(R.id.tab2)
        val tabCard3 : LinearLayout = headerView.findViewById(R.id.tab3)
        val text1 : TextView = headerView.findViewById(R.id.text)
        val text2 : TextView = headerView.findViewById(R.id.text2)
        val text3 : TextView = headerView.findViewById(R.id.text3)
        val image1 : ImageView = headerView.findViewById(R.id.image)
        val image2 : ImageView = headerView.findViewById(R.id.image2)
        val image3 : ImageView = headerView.findViewById(R.id.image3)

        text1.setTextColor(Color.parseColor("#6200EE"))
        text2.setTextColor(Color.parseColor("#838383"))
        text3.setTextColor(Color.parseColor("#838383"))

        binding.detailTab.getTabAt(0)!!.customView = tabCard1
        binding.detailTab.getTabAt(1)!!.customView = tabCard2
        binding.detailTab.getTabAt(2)!!.customView = tabCard3

        binding.detailTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(binding.detailTab.selectedTabPosition){
                    0 -> {
                        text1.setTextColor(Color.parseColor("#6200EE"))
                        text2.setTextColor(Color.parseColor("#838383"))
                        text3.setTextColor(Color.parseColor("#838383"))
                    }
                    1 -> {
                        text1.setTextColor(Color.parseColor("#838383"))
                        text2.setTextColor(Color.parseColor("#6200EE"))
                        text3.setTextColor(Color.parseColor("#838383"))
                    }
                    2 -> {
                        text1.setTextColor(Color.parseColor("#838383"))
                        text2.setTextColor(Color.parseColor("#838383"))
                        text3.setTextColor(Color.parseColor("#6200EE"))
                    }
                }
            }

        })
    }
}
