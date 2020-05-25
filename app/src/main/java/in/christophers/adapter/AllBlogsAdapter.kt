package `in`.christophers.adapter

import `in`.christophers.R
import `in`.christophers.activity.BlogDetail
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import carbon.widget.LinearLayout

class AllBlogsAdapter(var list : ArrayList<Int>, var context : Context) : RecyclerView.Adapter<AllBlogsAdapter.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.title)
        val layout : LinearLayout = view.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_all_blogs,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.title.text = ("Tips and Tricks for Competitive Exams")
        holder.layout.setOnClickListener {
            context.startActivity(Intent(context, BlogDetail::class.java))
        }
    }

}