package `in`.christophers.adapter

import `in`.christophers.R
import `in`.christophers.activity.Attempted
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import carbon.widget.LinearLayout

class TestDetailAdapter2(var list : ArrayList<Boolean>, var context : Context) : RecyclerView.Adapter<TestDetailAdapter2.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val attempted : TextView = view.findViewById(R.id.attempted)
        val layout : LinearLayout = view.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_test_detail_item,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        if (list[position]){
            holder.attempted.visibility = View.VISIBLE
        }else{
            holder.attempted.visibility = View.GONE
        }

        /*holder.layout.setOnClickListener {
            if (holder.attempted.visibility == View.VISIBLE){
                context.startActivity(Intent(context,Attempted::class.java))
            }
        }*/
    }

}