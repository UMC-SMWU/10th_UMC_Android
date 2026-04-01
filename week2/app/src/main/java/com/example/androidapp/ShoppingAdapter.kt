package com.example.androidapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class ShoppingAdapter(
    private val itemList: List<ShoppingData>
) : RecyclerView.Adapter<ShoppingAdapter.ItemViewHolder>() {

    // ViewHolder
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btnLike: ImageView = itemView.findViewById(R.id.btnLike)
        val icShopping: ImageView = itemView.findViewById(R.id.ic_shoppingItem)
        val tvName: TextView = itemView.findViewById(R.id.tvShoppingItem)

        val tvCategory: TextView = itemView.findViewById(R.id.tvShoppingCategory)

        val tvColor: TextView = itemView.findViewById(R.id.tvShoppingColor)
        val tvPrice: TextView = itemView.findViewById(R.id.tvShoppingPrice)
    }

    // ViewHolder 생성
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.shopping_item, parent, false)
        return ItemViewHolder(view)
    }

    // 데이터 연결
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]

        holder.icShopping.setImageResource(item.icon)
        holder.tvName.text = item.name
        holder.tvCategory.text = item.category
        holder.tvColor.text = item.color
        holder.tvPrice.text = item.price

        if (item.isLiked) {
            holder.btnLike.setImageResource(R.drawable.ic_filledheart)
        } else {
            holder.btnLike.setImageResource(R.drawable.ic_emptyheart)
        }

        // 클릭 이벤트
        holder.btnLike.setOnClickListener {
            item.isLiked = !item.isLiked
            notifyItemChanged(position)
        }
    }

    // 아이템 개수
    override fun getItemCount(): Int = itemList.size
}