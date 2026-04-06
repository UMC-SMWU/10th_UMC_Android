package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidapp.databinding.FragmentWishlistBinding

class WishlistFragment : Fragment() {
    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoppingViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        binding.tvWishlistTitle.text = "위시리스트"

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1️⃣ LayoutManager 설정
        binding.wishlistRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)

        // 2️⃣ ViewModel 데이터 관찰 (핵심 ⭐)
        viewModel.likedItems.observe(viewLifecycleOwner) { likedList ->
            val adapter = ShoppingAdapter(likedList, viewModel)
            binding.wishlistRecyclerView.adapter = adapter
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}