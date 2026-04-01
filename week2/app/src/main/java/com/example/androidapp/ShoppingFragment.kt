package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.fragment.app.activityViewModels
import com.example.androidapp.databinding.FragmentShoppingBinding

class ShoppingFragment : Fragment() {
    private var _binding: FragmentShoppingBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ShoppingViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = listOf(
            ShoppingData(R.drawable.shopping_item,"Nike Everyday Plus Cushioned","Training Ankle Socks (6 Pairs)","5 Colours", "US\$10"),
            ShoppingData(R.drawable.shopping_item,"Nike Elite Crew","Basketball Socks","7 Colours", "US\$16"),
            ShoppingData(R.drawable.home_item1,"Air Jordan XXXVI","Basketball Socks","7 Colours", "US\$185"),
            ShoppingData(R.drawable.home_item2,"Nike Air Force 1 '07", "Basketball Socks","7 Colours","US\$115")
        )


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