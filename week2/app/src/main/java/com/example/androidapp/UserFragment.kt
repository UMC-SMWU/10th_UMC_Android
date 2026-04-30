package com.example.androidapp

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import com.example.androidapp.databinding.FragmentUserBinding
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

        binding.tvBenefitTitle.text = "나이키 멤버 혜택"
        binding.tvBenefitSub.text = "0개 사용 가능"
        binding.tvFollowingEdit.text = "편집"


        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val response = RetrofitClient.api.getUser(1)
                val user = response.data

                binding.tvNickname.text = "${user.first_name} ${user.last_name}"

                binding.ivProfile.load(user.avatar) {
                    crossfade(true)
                    placeholder(R.drawable.circle_gray_bg)
                    transformations(CircleCropTransformation())
                }

            } catch (e: Exception) {
                binding.tvNickname.text = "닉네임 불러오기 실패"
            }

            try {
                val listResponse = RetrofitClient.api.getUserList(1)
                val userList = listResponse.data

                binding.rvFollowing.adapter = FollowingAdapter(userList)

                binding.tvFollowingTitle.text = "팔로잉 (${userList.size})"

            } catch (e: Exception) {
                binding.tvNickname.text = "불러오기 실패"
            }
        }

        binding.btnEditProfile.setOnClickListener { }
        binding.ivBenefitArrow.setOnClickListener { }
        binding.tvFollowingEdit.setOnClickListener { }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}