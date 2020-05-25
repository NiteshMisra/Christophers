package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.databinding.FragmentWalletBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

class Wallet : Fragment() {

    private lateinit var binding: FragmentWalletBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_wallet, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addFragment(0)

        binding.totalPoints.setOnClickListener {
            addFragment(0)
        }

        binding.Redeemed.setOnClickListener {
            addFragment(1)
        }
    }

    private fun addFragment(position: Int) {
        when (position) {
            0 -> {
                childFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container3, TotalPoints())
                    .commit()
            }
            1 -> {
                childFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container3, Redeemed())
                    .commit()
            }
        }
    }

}
