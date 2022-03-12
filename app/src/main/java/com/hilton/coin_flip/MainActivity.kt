package com.hilton.coin_flip

import android.animation.Animator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.hilton.coin_flip.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startBinding()
        toolClose()
        buttonClick()
    }

    private fun startBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.root
    }

    private fun buttonClick() {
        binding.btFlip.setOnClickListener { animationStart() }
    }

    private fun toolClose() {
        binding.incToolbar.ivClose.setOnClickListener { finish() }
    }

    private fun randomize(){
        val result = Random.nextInt(2)
        if (result == 0){
            binding.ivCoin.setImageResource(R.drawable.coins_heads)
        }else{
            binding.ivCoin.setImageResource(R.drawable.coins_tails)
        }
    }

    private fun animationStart() {
        binding.lavCoinAnimation.playAnimation()
        binding.lavCoinAnimation.visible()
        binding.lavCoinAnimation.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator?) {
                binding.ivCoin.invisible()
            }

            override fun onAnimationEnd(p0: Animator?) {
                randomize()
                binding.lavCoinAnimation.gone()
                binding.ivCoin.visible()
            }

            override fun onAnimationCancel(p0: Animator?) {}

            override fun onAnimationRepeat(p0: Animator?) {}

        })
    }
}