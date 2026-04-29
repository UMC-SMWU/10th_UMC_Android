package com.example.androidapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private var itemList: List<ItemData>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    fun updateList(newList: List<ItemData>) {
        itemList = newList
        notifyDataSetChanged()
    }

    // ViewHolder
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icHome: ImageView = itemView.findViewById(R.id.ic_homeItem)
        val tvName: TextView = itemView.findViewById(R.id.tvHomeItem)
        val tvPrice: TextView = itemView.findViewById(R.id.tvHomePrice)
    }

    // ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.home_item, parent, false)
        return ItemViewHolder(view)
    }

    // 데이터 연결
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]

        holder.icHome.setImageResource(item.icon)
        holder.tvName.text = item.name
        holder.tvPrice.text = item.price
    }

    // 아이템 개수
    override fun getItemCount(): Int = itemList.size
}