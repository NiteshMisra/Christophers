package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.databinding.ActivityMainBinding
import `in`.christophers.fragments.Home
import `in`.christophers.fragments.Store
import `in`.christophers.fragments.Test
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isFromRefer: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        binding.toolbar.title = ""
        setSupportActionBar(binding.toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawer,
            binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        toggle.isDrawerIndicatorEnabled = false
        toggle.setHomeAsUpIndicator(R.drawable.ic_dehaze)
        toggle.setToolbarNavigationClickListener {
            if (binding.drawer.isDrawerVisible(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
            } else {
                binding.drawer.openDrawer(GravityCompat.START)
            }
        }
        binding.drawer.addDrawerListener(toggle)
        toggle.syncState()

        binding.bottomNavigation.itemIconTintList = null
        binding.bottomNavigation.setOnNavigationItemSelectedListener(mListener)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, Home())
            .commit()
    }

    fun navigateToStore() {
        isFromRefer = true
        binding.bottomNavigation.selectedItemId = R.id.nav_store
    }

    private val mListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val homeFragment = Home()
                    addFragment(homeFragment)
                }

                R.id.nav_test -> {
                    val testFragment = Test()
                    addFragment(testFragment)
                }

                R.id.nav_store -> {
                    if (isFromRefer) {
                        val bundle = Bundle()
                        bundle.putBoolean("openFromRefer", true)
                        val storeFragment = Store()
                        storeFragment.arguments = bundle
                        addFragment(storeFragment)
                        isFromRefer = false
                    } else {
                        val bundle = Bundle()
                        bundle.putBoolean("openFromRefer", false)
                        val storeFragment = Store()
                        storeFragment.arguments = bundle
                        addFragment(storeFragment)
                        isFromRefer = false
                    }
                }
            }

            true
        }

    private fun addFragment(fragment: Fragment) {

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("tag")
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_notify, menu)
        return true
    }

    override fun onBackPressed() {

        if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
            binding.drawer.closeDrawer(GravityCompat.START)
        } else {
            if (binding.bottomNavigation.selectedItemId == R.id.nav_home) {
                finish()
            } else {
                binding.bottomNavigation.selectedItemId = R.id.nav_home
                supportFragmentManager.beginTransaction().addToBackStack(null).commit()
            }
        }
    }


}
