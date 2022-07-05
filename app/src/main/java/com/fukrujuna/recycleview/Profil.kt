package com.fukrujuna.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fukrujuna.recycleview.databinding.ActivityProfilBinding

class Profil : AppCompatActivity() {
    private lateinit var binding : ActivityProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn6.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            (finish())
        }
    }
}