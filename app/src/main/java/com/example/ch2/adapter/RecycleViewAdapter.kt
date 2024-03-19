package com.example.ch2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ch2.model.Catalog
import com.example.ch2.databinding.ItemCatalogGridBinding
import com.example.ch2.databinding.ItemCatalogListBinding

class RecycleViewAdapter(private var dataset: List<Catalog>, private var isGrid: Boolean) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (isGrid) {
            GridViewHolder(ItemCatalogGridBinding.inflate(inflater, parent, false))
        } else {
            ListViewHolder(ItemCatalogListBinding.inflate(inflater, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataset[position]
        when (holder) {
            is GridViewHolder -> holder.bind(item)
            is ListViewHolder -> holder.bind(item)
        }
    }

    override fun getItemCount() = dataset.size

    override fun getItemViewType(position: Int): Int {
        return VIEW_TYPE_LIST // Untuk sementara, selalu kembali ke tampilan grid
    }

    inner class GridViewHolder(private val binding: ItemCatalogGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catalog: Catalog) {
            binding.ivCatalogImage.setImageResource(catalog.image)
            binding.tvCatalogName.text = catalog.name
            binding.tvCatalogPrice.text = catalog.price.toString()
        }
    }

    inner class ListViewHolder(private val binding: ItemCatalogListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(catalog: Catalog) {
            binding.ivCatalogImages.setImageResource(catalog.image)
            binding.tvCatalogName.text = catalog.name
            binding.tvCatalogPrice.text = catalog.price.toString()
        }
    }

    companion object {
        private const val VIEW_TYPE_GRID = 0
        private const val VIEW_TYPE_LIST = 1
    }
}
