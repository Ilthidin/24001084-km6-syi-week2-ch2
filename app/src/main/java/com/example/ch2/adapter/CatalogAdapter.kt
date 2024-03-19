package com.example.ch2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ch2.databinding.ItemCatalogListBinding
import com.example.ch2.model.Catalog
import com.example.ch2.utils.toIndonesianFormat

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.CatalogViewHolder>() {

    private val data = mutableListOf<Catalog>()

    fun submitData(items: List<Catalog>) {
        data.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        return CatalogViewHolder(
            ItemCatalogListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    //counting the data size
    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class CatalogViewHolder(private val binding: ItemCatalogListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Catalog) {
            binding.tvCatalogName.text = item.name
            binding.tvCatalogPrice.text = item.price.toIndonesianFormat()
            binding.ivCatalogImages.setImageResource(item.image)
        }
    }
}