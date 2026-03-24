package com.example.umc_10th

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.umc_10th.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvQuestion.text = "오늘 하루는 어땠나요?"
        binding.tvSubtitle.text = "감정우표를 선택해주세요"
        binding.tvDescription.text = "선택한 감정우표를 기반으로 맞춤형 질문이 배달됩니다"

        binding.btnHappy.setOnClickListener {
            binding.tvHappy.setTextColor(getColor(R.color.yellow))
        }
        binding.tvHappy.text = "더없이 행복한 하루였어요"
        binding.btnExcited.setOnClickListener{
            binding.tvExcited.setTextColor(getColor(R.color.blue))
        }
        binding.tvExcited.text = "들뜨고 흥분돼요"
        binding.btnNormal.setOnClickListener{
            binding.tvNormal.setTextColor(getColor(R.color.purple))
        }
        binding.tvNormal.text = "평범한 하루였어요"
        binding.btnNervous.setOnClickListener{
            binding.tvNervous.setTextColor(getColor(R.color.green))
        }
        binding.tvNervous.text = "생각이 많아지고 불안해요"
        binding.btnAngry.setOnClickListener{
            binding.tvAngry.setTextColor(getColor(R.color.red))
        }
        binding.tvAngry.text = "부글부글 화가 나요"

    }
}