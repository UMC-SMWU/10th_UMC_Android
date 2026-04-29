package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidapp.databinding.FragmentUserBinding

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUserBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNickname.text = "닉네임"

        binding.btnEditProfile.setOnClickListener {
        }

        binding.tvBenefitTitle.text = "나이키 멤버 혜택"

        binding.tvBenefitSub.text = "0개 사용 가능"

        binding.tvFollowingTitle.text = "팔로잉 (3)"

        binding.tvFollowingEdit.text = "편집"


        binding.ivBenefitArrow.setOnClickListener {

        }

        binding.tvFollowingEdit.setOnClickListener {

        }

        // 팔로잉 RecyclerView 설정
        // binding.rvFollowing.adapter = FollowingAdapter(followingList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}