package `in`.christophers.adapter

import `in`.christophers.R
import `in`.christophers.activity.StoreDetail
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoreAdapter(var list : ArrayList<Int>, var context : Context) : RecyclerView.Adapter<StoreAdapter.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.title)
        val next : ImageView = view.findViewById(R.id.arrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_store,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val text = "CGL (Pre) 2 Mains"
        if (text.length > 15){
            holder.title.text = (text.substring(0,12) + "...")
        }else{
            holder.title.text = text
        }
        holder.next.setOnClickListener {
            context.startActivity(Intent(context, StoreDetail::class.java))
        }
    }

}