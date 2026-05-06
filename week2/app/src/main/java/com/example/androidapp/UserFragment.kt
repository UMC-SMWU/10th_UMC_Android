package com.example.androidapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import com.example.androidapp.data.remote.RemoteUserRepository
import com.example.androidapp.data.remote.RetrofitClient
import com.example.androidapp.databinding.FragmentUserBinding
import com.example.androidapp.repository.UserRepository
import kotlinx.coroutines.launch

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private val userRepository: UserRepository = RemoteUserRepository()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvBenefitTitle.text = "나이키 멤버 혜택"
        binding.tvBenefitSub.text = "0개 사용 가능"
        binding.tvFollowingEdit.text = "편집"


        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val user = userRepository.getUser(1)

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
                val userList = userRepository.getUserList(1)

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