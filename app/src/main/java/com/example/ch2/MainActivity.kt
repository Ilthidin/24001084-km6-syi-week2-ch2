package com.example.ch2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ch2.adapter.CatalogAdapterGrid
import com.example.ch2.adapter.CatalogAdapterList
import com.example.ch2.adapter.CategoryAdapter
import com.example.ch2.adapter.RecycleViewAdapter
import com.example.ch2.databinding.ActivityMainBinding
import com.example.ch2.model.Catalog
import com.example.ch2.model.Category

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecycleViewAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var isGrid = true

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var categoryAdapter = CategoryAdapter()
    private var catalogAdapterList = CatalogAdapterList(supportFragmentManager)
    private var catalogAdapterGrid = CatalogAdapterGrid(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()

        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.rv_catalog)

        // Inisialisasi layoutManager
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Inisialisasi adapter
        adapter = RecycleViewAdapter(ArrayList(), isGrid)
        recyclerView.adapter = adapter

        setListCategory()
        setListCatalog()

        binding.layoutCatalog.ivList.setOnClickListener {
            // Toggle antara tampilan grid dan list
            isGrid = !isGrid
            if (isGrid) {
                layoutManager = LinearLayoutManager(this)
                binding.layoutCatalog.ivList.setImageResource(R.drawable.ic_catalog_list) // Mengatur gambar ikon ke mode list
            } else {
                layoutManager = GridLayoutManager(this, 2)
                binding.layoutCatalog.ivList.setImageResource(R.drawable.ic_catalog_grid) // Mengatur gambar ikon ke mode grid
            }
            recyclerView.layoutManager = layoutManager
            // Set adapter sesuai dengan jenis tampilan yang baru
            setListCatalog()
        }
    }

    private fun setListCategory() {
        val data = listOf(
            Category(
                image = R.drawable.img_category_rice,
                name = "Rice"
            ),
            Category(
                image = R.drawable.img_category_noodle,
                name = "Noodle"
            ),
            Category(
                image = R.drawable.img_category_fast_food,
                name = "Fast Food"
            ),
            Category(
                image = R.drawable.img_category_snack,
                name = "Snack"
            ),
            Category(
                image = R.drawable.img_category_beverage,
                name = "Beverage"
            ),
        )
        binding.rvCategory.adapter = categoryAdapter
        categoryAdapter.submitData(data)
    }

    private fun setListCatalog() {
        val data = listOf(
            Catalog(
                image = R.drawable.img_catalog_spaghetti,
                name = "Spaghetti",
                price = 25_000.00,
                description = "Mie berbentuk pasta asal italia yang memiliki berbagai macam topping dan saus khas italia",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, banten 15345"
            ),
            Catalog(
                image = R.drawable.img_catalog_meatball,
                name = "Bakso",
                price = 40_000.00,
                description = "Daging giling yang berbentuk bola dipadu dengan mie dan daging lain seta ditambahkan dengan kuah kaldu asli",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, banten 15345"
            ),
            Catalog(
                image = R.drawable.img_catalog_tea,
                name = "Es Teh",
                price = 5_000.00,
                description = "Minumal seduhan teh ditambah dengan es memberi rasa segar",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, banten 15345"
            ),
            Catalog(
                image = R.drawable.img_catalog_burger,
                name = "Burger",
                price = 32_000.00,
                description = "Makanan cepat saji yang terdiri dari roti, daging, sayur, dan berbagai macam isian lainnya",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, banten 15345"
            ),
            Catalog(
                image = R.drawable.img_catalog_fried_rice,
                name = "Nasi Goreng",
                price = 20_000.00,
                description = "Nasi yang diberi bumbu dan digoreng bersamaan dengan daging asli",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, banten 15345"
            ),
            Catalog(
                image = R.drawable.img_catalog_salad,
                name = "Salad",
                price = 22_000.00,
                description = "Berbagai macam sayuran hijau segar yang dicampur memiliki banyak manfaat bagi kesehatan tubuh",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, banten 15345"
            ),
            Catalog(
                image = R.drawable.img_catalog_ramen,
                name = "Ramen",
                price = 50_000.00,
                description = "Mie asal jepang yang diberikan berbagai macam topping serta kaldu alami sehingga menciptakan rasa yang unik",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, banten 15345"
            ),
            Catalog(
                image = R.drawable.img_catalog_sushi,
                name = "Sushi Roll",
                price = 38_000.00,
                description = "Kombinasi nasi, ikan segar, dan rumput laut membuat sushi roll memiliki rasa yang segar dan kaya di mulut",
                address = "Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, banten 15345"
            ),
        )
        if (isGrid) {
            binding.rvCatalog.adapter = catalogAdapterList
            catalogAdapterList.submitData(data)
        } else {
            binding.rvCatalog.adapter = catalogAdapterGrid
            catalogAdapterGrid.submitData(data)
        }
    }

    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Selected Profile Icon", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.tvName.text = "Hi There"
    }
}