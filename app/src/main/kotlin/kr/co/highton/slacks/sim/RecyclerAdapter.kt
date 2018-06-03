package kr.co.highton.slacks.sim

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_c2c.view.*
import java.util.*


internal class RecyclerAdapter(private val dataList: ArrayList<Data>) : RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(parent)

    override fun onBindViewHolder(holder: Holder, position: Int) {

        with(holder.itemView) {
            val data = dataList[position]

            writeTv.text = data.writer
            dateTv.text = data.content
            contentTv.text = data.date

        }
    }

    override fun getItemCount(): Int = dataList.size

    inner class Holder(parent: ViewGroup)
        : RecyclerView.ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_c2c, parent, false))
}