package com.example.ch2.adapter

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.ButtonBarLayout
import androidx.fragment.app.Fragment
import com.example.ch2.MainActivity
import com.example.ch2.R
import com.example.ch2.databinding.ActivityDetailBinding
import com.example.ch2.model.Catalog

class DetailAdapter : Fragment() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityDetailBinding.inflate(inflater, container, false)

        // Button ActivityMain
        binding.icBack.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvAddress.setOnClickListener {
            val uri = "https://maps.app.goo.gl/UDYq168bTXMJKNpk8"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))

            if (intent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(
                    requireContext(),
                    "No application available to open the link",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendapatkan data katalog dari arguments
        val catalog: Catalog? = arguments?.getParcelable("catalog")

        // Menampilkan data katalog di UI
        catalog?.let {
            // Mengambil gambar katalog
            val imageViewCatalog = view.findViewById<ImageView>(R.id.iv_catalog_image)
            imageViewCatalog.setImageResource(it.image)
            view.findViewById<TextView>(R.id.tv_catalog_name).text = it.name
            view.findViewById<TextView>(R.id.tv_catalog_price).text = "Rp. ${it.price}"
            view.findViewById<TextView>(R.id.tv_description).text = it.description
            view.findViewById<TextView>(R.id.tv_address).text = it.address
            view.findViewById<AppCompatButton>(R.id.appCompatButton).text = "Tambah ke keranjang - Rp. ${it.price}"
        }
    }
}