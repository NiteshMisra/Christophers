package `in`.christophers.adapter

import `in`.christophers.R
import `in`.christophers.activity.Video
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BlogsAdapter(val list : ArrayList<Int>, var context: Context) : RecyclerView.Adapter<BlogsAdapter.Vh>() {

    class Vh(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.name)
        val layout : LinearLayout = view.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_videos,parent,false)
        return Vh(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.title.text = ("This is the Title of the video")
        holder.layout.setOnClickListener {
            context.startActivity(Intent(context,Video::class.java))
        }
    }
}