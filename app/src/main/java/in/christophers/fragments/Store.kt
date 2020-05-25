package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.databinding.FragmentStoreBinding
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

class Store : Fragment() {

    private lateinit var binding: FragmentStoreBinding
    private lateinit var mainActivity: FragmentActivity
    private var openFromRefer: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_store, container, false)
        openFromRefer = requireArguments().getBoolean("openFromRefer")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity = requireActivity()

        if (openFromRefer) {
            changeTab(1)
        } else {
            changeTab(0)
        }

        binding.tab1Layout.setOnClickListener {
            changeTab(0)
        }

        binding.tab2Layout.setOnClickListener {
            changeTab(1)
        }

    }

    private fun changeTab(position: Int) {
        when (position) {
            0 -> {
                binding.tab1.setTextColor(Color.parseColor("#6200EE"))
                binding.tab1.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    R.drawable.ic_info_blue,
                    0,
                    0
                )
                binding.tab2.setTextColor(Color.parseColor("#8D8D8D"))
                binding.tab2.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    R.drawable.ic_wallet_grey,
                    0,
                    0
                )
                binding.title.text = ("Store")
                addFragment(0)
            }

            1 -> {
                binding.tab1.setTextColor(Color.parseColor("#8D8D8D"))
                binding.tab1.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    R.drawable.ic_info_grey,
                    0,
                    0
                )
                binding.tab2.setTextColor(Color.parseColor("#6200EE"))
                binding.tab2.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    R.drawable.ic_wallet_blue,
                    0,
                    0
                )
                binding.title.text = ("Wallet")
                addFragment(1)
            }
        }
    }

    private fun addFragment(position: Int) {
        when (position) {
            0 -> {
                childFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container2, Store2())
                    .commit()
            }
            1 -> {
                childFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container2, Wallet())
                    .commit()
            }
        }
    }

}
