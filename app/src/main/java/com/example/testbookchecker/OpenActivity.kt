package com.example.testbookchecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.testbookchecker.databinding.ActivityOpenBinding
import com.example.testbookchecker.models.coversItem
import com.google.gson.Gson

class OpenActivity : AppCompatActivity() {
    lateinit var binding: ActivityOpenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOpenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cover =Gson().fromJson(intent.getStringExtra("cover"), coversItem::class.java)

        binding.apply {
            Glide.with(this@OpenActivity)
                .load(cover.image)
                .into(imageView2)

            title.text = cover.title
            textAvtor.text = cover.author
            textDescription.text = cover.description
        }
    }
}