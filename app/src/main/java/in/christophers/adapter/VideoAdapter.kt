package `in`.christophers.adapter

import `in`.christophers.R
import `in`.christophers.activity.Video
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideoAdapter(var list : ArrayList<Int>, var selectedPosition : Int, var context: Context) : RecyclerView.Adapter<VideoAdapter.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.title)
        val layout : LinearLayout = view.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_video,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.title.text = ("Score 50/50 in English SSC (Pre) 2019")
        if (position == selectedPosition){
            holder.layout.setBackgroundColor(Color.parseColor("#ECDFFF"))
        }

        holder.layout.setOnClickListener {
            if (context is Video){
                (context as Video).rcvClick(position)
            }
        }
    }

}