package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemList = listOf(
            ItemData(R.drawable.home_item1,"Air Jordan XXXVI", "US\$185"),
            ItemData(R.drawable.home_item2,"Nike Air Force 1 '07", "US\$115")
        )

        val adapter = ItemAdapter(itemList)

        binding.homeRecyclerView.adapter = adapter
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.tvTitle.text = "Discover"
        binding.tvSubtitle.text = "3월 27일 금요일"
        // binding.myImage.setImageResource(R.drawable.home_logo)
        binding.tvNewTitle.text = "What's new"
        binding.tvNewSubtitle.text = "나이키 최신 상품"

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}