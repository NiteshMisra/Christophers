package `in`.christophers.adapter

import `in`.christophers.R
import `in`.christophers.activity.BlogDetail
import `in`.christophers.model.TestDetailModel
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import carbon.widget.LinearLayout

class TestDetailAdapter(var list : ArrayList<TestDetailModel>, var context : Context) : RecyclerView.Adapter<TestDetailAdapter.VH>(){

    class VH(view : View) : RecyclerView.ViewHolder(view){
        val date : TextView = view.findViewById(R.id.date)
        val recyclerView : RecyclerView = view.findViewById(R.id.rcv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.element_test_detail,parent,false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val current = list[position]
        holder.date.text = current.date
        holder.recyclerView.layoutManager = LinearLayoutManager(context)

        val adapter = TestDetailAdapter2(current.list,context)
        holder.recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }

}