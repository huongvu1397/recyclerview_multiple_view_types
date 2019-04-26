package com.solar.file.multiplercvdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter(
    private val travels: List<Travel>,
    private val listener: (Travel) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        if (viewHolder is MainViewHolder) {
            viewHolder.itemView.tvName.text = "Huong"
            viewHolder.itemView.tvDescription.text = "Mota"
        }
    }

    companion object {
        private const val TYPE_FOOTER = 0
        private const val TYPE_ITEM = 1
    }


    override fun onCreateViewHolder(parent: ViewGroup, type: Int): RecyclerView.ViewHolder {
        if (type == TYPE_FOOTER) {
            return FooterViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.footer_view, parent, false))
        } else {
            return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 20) {
            TYPE_FOOTER
        } else {
            TYPE_ITEM
        }
    }


    override fun getItemCount() = 21

    inner class MainViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        init {
            fun bind(travel: Travel, listener: (Travel) -> Unit) {
                view.tvName.text = travel.name
                view.tvDescription.text = travel.description
                view.setOnClickListener { listener(travel) }
            }
        }
    }

    inner class FooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {

        }
    }
}