package com.example.ch2.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ch2.R
import com.example.ch2.databinding.ItemCatalogListBinding
import com.example.ch2.model.Catalog

class CatalogAdapterList(private val fragmentManager: FragmentManager) :
    RecyclerView.Adapter<CatalogAdapterList.ViewHolder>() {

    private var data: List<Catalog> = listOf()

    fun submitData(data: List<Catalog>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCatalogListBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.setOnClickListener {
            // Membuat instance dari FragmentDetail
            val fragment = DetailAdapter().apply {
                // Menyiapkan data yang akan dikirim ke FragmentDetail
                arguments = Bundle().apply {
                    putParcelable("catalog", data[position])
                }
            }
            // Menambahkan FragmentDetail ke layout MainActivity
            fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun getItemCount(): Int = data.size

    inner class ViewHolder(private val binding: ItemCatalogListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Catalog) {
            // Bind data ke layout item_catalog_list
            binding.ivCatalogImages.setImageResource(item.image)
            binding.tvCatalogName.text = item.name
            binding.tvCatalogPrice.text = "Rp. ${item.price.toString()}"
        }
    }
}