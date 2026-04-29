package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapp.databinding.FragmentHomeBinding
import com.example.androidapp.shopping.ShoppingViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val viewModel: ShoppingViewModel by activityViewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemAdapter // 전역변수로 쓰기 위해 정의하고 아직 view가 생성되지 않았으므로 나중에 초기화한다는 lateinit 사용

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ItemAdapter(emptyList())
        binding.homeRecyclerView.adapter = adapter
        binding.homeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.itemList.collectLatest { list ->
                    val homeList = list.take(2)
                    val mappedList = homeList.map {
                        ItemData(it.icon, it.name, it.price ?: "")
                    }
                    adapter.updateList(mappedList)
                }
            }
        }
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