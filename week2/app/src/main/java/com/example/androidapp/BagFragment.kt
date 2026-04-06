package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidapp.databinding.FragmentBagBinding


class BagFragment : Fragment() {
    private var _binding: FragmentBagBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentBagBinding.inflate(inflater, container, false)


        binding.myImage.setImageResource(R.drawable.ic_bagcircle)
        binding.tvEmptyBag.text = "장바구니가 비어 있습니다.\n제품을 추가하면 여기에 표시됩니다."
        binding.btnAddItem.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.main_fragmentContainer, ShoppingFragment())
                .commit()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}