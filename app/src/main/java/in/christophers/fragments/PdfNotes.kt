package `in`.christophers.fragments

import `in`.christophers.R
import `in`.christophers.adapter.LecturesAdapter
import `in`.christophers.adapter.PdfNotesAdapter
import `in`.christophers.databinding.FragmentPdfNotesBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager

class PdfNotes : Fragment() {

    private lateinit var binding : FragmentPdfNotesBinding
    private lateinit var detailActivity: FragmentActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_pdf_notes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailActivity = requireActivity()

        binding.pdfNotesRcv.layoutManager = LinearLayoutManager(detailActivity)

        val list : ArrayList<Int> = ArrayList()
        for (i in 0..15){
            list.add(i)
        }

        val adapter = PdfNotesAdapter(list)
        binding.pdfNotesRcv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}
