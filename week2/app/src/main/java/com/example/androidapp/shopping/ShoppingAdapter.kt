package com.example.androidapp.shopping

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapp.R
import com.example.androidapp.shopping.ShoppingData
import com.example.androidapp.shopping.ShoppingViewModel
import com.example.androidapp.databinding.ShoppingItemBinding

class ShoppingAdapter(
    private var itemList: List<ShoppingData>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ShoppingItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ShoppingItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]

        holder.binding.apply {
            icShoppingItem.setImageResource(item.icon)
            tvShoppingItem.text = item.name
            tvShoppingCategory.text = item.category
            tvShoppingColor.text = item.color
            tvShoppingPrice.text = item.price ?: ""

            // 하트 상태 반영
            btnLike.setImageResource(
                if (item.isLiked) R.drawable.ic_filledheart
                else R.drawable.ic_emptyheart
            )

            btnLike.setOnClickListener {
                item.isLiked = !item.isLiked

                // 전체 리스트 갱신 후 저장
                val updatedList = itemList.toMutableList()
                updatedList[position] = item

                viewModel.saveItems(updatedList)
                notifyItemChanged(position)
            }
        }
    }

    fun updateList(newList: List<ShoppingData>) {
        itemList = newList
        notifyDataSetChanged()
    }
}