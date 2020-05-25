package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.adapter.TabAdapter
import `in`.christophers.databinding.FragmentHomeBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class Home : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var mainActivity : FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = requireActivity()
        val adapter = TabAdapter(mainActivity.supportFragmentManager)
        adapter.addFragment(Courses(),"Courses")
        adapter.addFragment(Videos(),"Videos")
        adapter.addFragment(Blogs(),"Blogs")

        binding.viewPager.adapter = adapter

        binding.tabs.setupWithViewPager(binding.viewPager)
    }
}
