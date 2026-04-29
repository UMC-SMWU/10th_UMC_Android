package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapp.databinding.FragmentWishlistBinding
import com.example.androidapp.shopping.ShoppingAdapter
import com.example.androidapp.shopping.ShoppingViewModel

class WishlistFragment : Fragment() {
    private var _binding: FragmentWishlistBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ShoppingViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ShoppingAdapter(emptyList(), viewModel)

        binding.wishlistRecyclerView.adapter = adapter
        binding.wishlistRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())


        viewModel.itemList.observe(viewLifecycleOwner) { list ->
            val likedList = list.filter { it.isLiked }
            adapter.updateList(likedList)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWishlistBinding.inflate(inflater, container, false)
        binding.tvWishlistTitle.text = "위시리스트"
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}