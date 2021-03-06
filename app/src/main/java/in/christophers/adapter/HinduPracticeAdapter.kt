package `in`.christophers.adapter

import `in`.christophers.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HinduPracticeAdapter(var list : ArrayList<Int>) : RecyclerView.Adapter<HinduPracticeAdapter.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_practice,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
       holder.title.text = ("Practice Hindu News Paper")
    }

}