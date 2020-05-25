package `in`.christophers.adapter

import `in`.christophers.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import carbon.widget.RelativeLayout

class TotalPointsAdapter(var list: ArrayList<Int>, var context: Context) :
    RecyclerView.Adapter<TotalPointsAdapter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val points: TextView = view.findViewById(R.id.points)
        val layout: RelativeLayout = view.findViewById(R.id.layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.element_total_points, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.points.text = ("+50")
        holder.layout.setOnClickListener {
            val dialogView: View =
                LayoutInflater.from(context).inflate(R.layout.refer_dialog, null, false)
            val builder = AlertDialog.Builder(context)
            val close: TextView = dialogView.findViewById(R.id.close)
            builder.setView(dialogView)
            val dialog: AlertDialog = builder.create()
            close.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }
    }

}