package `in`.christophers.adapter

import `in`.christophers.R
import `in`.christophers.activity.Course
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import carbon.widget.LinearLayout

class CoursesViewAllAdapter(var list : ArrayList<Int>, var context: Context) : RecyclerView.Adapter<CoursesViewAllAdapter.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val chapters : TextView = view.findViewById(R.id.chapters)
        val layout : LinearLayout = view.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_courses_view_all,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.chapters.text = ("${list[position]} Chapters")
        holder.layout.setOnClickListener{
            context.startActivity(Intent(context, Course::class.java))
        }
    }

}