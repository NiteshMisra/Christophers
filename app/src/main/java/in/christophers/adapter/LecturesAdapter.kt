package `in`.christophers.adapter

import `in`.christophers.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LecturesAdapter(var list : ArrayList<Int>) : RecyclerView.Adapter<LecturesAdapter.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val image : ImageView = view.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_lectures,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
       if (position%2 == 0){
           holder.image.setImageResource(R.drawable.ic_play)
       }else{
           holder.image.setImageResource(R.drawable.ic_stop)
       }
    }

}