package com.example.testbookchecker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testbookchecker.adapters.CoverAdapter
import com.example.testbookchecker.databinding.ActivityMainBinding
import com.example.testbookchecker.models.coversItem
import com.example.testbookchecker.servis.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        GlobalScope.launch(Dispatchers.IO) {
            try {
                onDrinksLoaded(ApiService.loadCovers().body())
            } catch (e: Exception) {
                onDrinksLoaded(null)
            }
        }
    }

    private fun onDrinksLoaded(covers: ArrayList<coversItem>?) {
        GlobalScope.launch(Dispatchers.Main) {
            when {
                covers == null -> toast("internet_error")
                covers.isNotEmpty() -> {

                    binding.apply {
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerView.adapter = CoverAdapter(this@MainActivity, covers)
                    }


                }
                else -> toast("empty_list")
            }

        }
    }

    private fun toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }
}