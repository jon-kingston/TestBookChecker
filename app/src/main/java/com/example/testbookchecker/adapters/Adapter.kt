package com.example.testbookchecker.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testbookchecker.OpenActivity
import com.example.testbookchecker.databinding.ElementBoockBinding
import com.example.testbookchecker.models.coversItem
import com.google.gson.Gson

class CoverAdapter (val ctx: Context,
                    var cover: ArrayList<coversItem>
    ): RecyclerView.Adapter<CoverAdapter.Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val layoutInflater = LayoutInflater.from(parent.context)
            return Holder(ElementBoockBinding.inflate(layoutInflater, parent, false))
        }

        override fun onBindViewHolder(holder: Holder, position: Int) =
                holder.bind(position)

        override fun getItemCount() = cover.size

        inner class Holder(private val view: ElementBoockBinding): RecyclerView.ViewHolder(view.root) {

            fun bind(position: Int) {
                cover[position].apply {
                    view.text.text = title
                    Glide.with(ctx)
                            .load(image)
                            .into(view.imageView)
                    view.root.setOnClickListener {
                        ctx.startActivity(Intent(ctx, OpenActivity::class.java).apply {
                            putExtra("name", Gson().toJson(cover[position]))
                        })
                    }
                }
            }

        }

    }