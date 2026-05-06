package com.example.androidapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import com.example.androidapp.data.remote.RemoteUserRepository
import com.example.androidapp.databinding.FragmentUserBinding
import com.example.androidapp.repository.UserRepository
import com.example.androidapp.viewmodel.UserViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserViewModel by viewModels()

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


        // viewModel에 요청(id 1번의 사용자 한 명 데이터)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.user.collectLatest { user ->
                user?.let {
                    binding.tvNickname.text = "${it.first_name} ${it.last_name}"
                    binding.ivProfile.load(it.avatar) {
                        crossfade(true)
                        placeholder(R.drawable.circle_gray_bg)
                        transformations(CircleCropTransformation())
                    }
                }
            }
        }

        // ViewModel에게 요청(팔로우하고 있는 user 여러 명의 데이터)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userList.collectLatest { userList ->
                binding.rvFollowing.adapter = FollowingAdapter(userList)
                binding.tvFollowingTitle.text = "팔로잉 (${userList.size})"
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