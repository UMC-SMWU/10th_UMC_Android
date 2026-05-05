package com.example.androidapp.shopping.tab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentShoppingBinding
import com.example.androidapp.shopping.ShoppingAdapter
import com.example.androidapp.shopping.ShoppingData
import com.example.androidapp.shopping.ShoppingViewModel

class ShoppingFragment : Fragment() {
    private var _binding: FragmentShoppingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShoppingViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = listOf(
            ShoppingData(
                R.drawable.shopping_item,
                "Nike Everyday Plus Cushioned",
                "Training Ankle Socks (6 Pairs)",
                "5 Colours",
                "US\$10"
            ),
            ShoppingData(
                R.drawable.shopping_item,
                "Nike Elite Crew",
                "Basketball Socks",
                "7 Colours",
                "US\$16"
            ),
            ShoppingData(
                R.drawable.home_item1,
                "Nike Air Force 1 '07",
                "Women's Shoes",
                "5 Colours",
                "US\$115"
            ),
            ShoppingData(
                R.drawable.home_item2,
                "Jordan ENike Air Force 1 '07 essentials",
                "Men's Shoes",
                "2 Colours",
                "US\$115"
            )
        )

        viewModel.saveItems(itemList)

        val adapter = ShoppingAdapter(itemList, viewModel)

        binding.shoppingRecyclerView.adapter = adapter
        binding.shoppingRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentShoppingBinding.inflate(inflater, container, false)


        binding.tvShoppingTitle.text = "구매하기"

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}