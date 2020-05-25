package `in`.christophers.adapter

import `in`.christophers.R
import `in`.christophers.activity.Video
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class AllVideosAdapter(var list : ArrayList<Int>, var context : Context) : RecyclerView.Adapter<AllVideosAdapter.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.title)
        val card : CardView = view.findViewById(R.id.card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_all_videos,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.title.text = ("Score 50/50 in English SSC (Pre) 2019")
        holder.card.setOnClickListener {
            context.startActivity(Intent(context,Video::class.java))
        }
    }

}