package `in`.christophers.activity

import `in`.christophers.R
import `in`.christophers.databinding.ActivityAttemptedBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil

class Attempted : AppCompatActivity() {

    private lateinit var binding : ActivityAttemptedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_attempted)

        binding.back.setOnClickListener {
            onBackPressed()
        }
    }
}
