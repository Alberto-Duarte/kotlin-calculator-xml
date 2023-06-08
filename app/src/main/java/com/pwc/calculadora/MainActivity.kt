package com.pwc.calculadora

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import com.pwc.calculadora.databinding.ActivityBinding

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}