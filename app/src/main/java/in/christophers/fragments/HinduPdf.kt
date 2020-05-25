package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.adapter.HinduPdfAdapter
import `in`.christophers.adapter.PdfNotesAdapter
import `in`.christophers.databinding.FragmentHinduPdfBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager

class HinduPdf : Fragment() {

    private lateinit var binding: FragmentHinduPdfBinding
    private lateinit var hinduActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_hindu_pdf, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hinduActivity = requireActivity()

        binding.pdfNotesRcv.layoutManager = LinearLayoutManager(hinduActivity)

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = HinduPdfAdapter(list)
        binding.pdfNotesRcv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
