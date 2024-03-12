package com.example.ch2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ch2.databinding.ActivityMainBinding
import com.example.ch2.model.Catalog
import com.example.ch2.model.CatalogAdapter
import com.example.ch2.model.Category

/* LayoutInflater system / findViewById Approach

class MainActivity : AppCompatActivity() {

    private val ivProfile: ImageView by lazy {
        findViewById(R.id.iv_profile)
    }
    private val tvName : TextView by lazy {
        findViewById(R.id.tv_name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAction()
        changeProfileIcon()
    }

    private fun changeProfileIcon() {
        ivProfile.setImageResource(R.drawable.img_cat)
    }

    private fun setAction() {
        ivProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hi There", Toast.LENGTH_SHORT).show()
        }
        tvName.text = "Hi There"
    }
}*/

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var categoryAdapter = CategoryAdapter()
    private var catalogAdapter = CatalogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()
        setListCategory()
        setListCatalog()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_category_rice, name = "Rice"),
            Category(image = R.drawable.img_category_noodle, name = "Noodle"),
            Category(image = R.drawable.img_category_fast_food, name = "Fast Food"),
            Category(image = R.drawable.img_category_snack, name = "Snack"),
            Category(image = R.drawable.img_category_beverage, name = "Beverage"),
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }
        categoryAdapter.submitData(data)
    }

    private fun setListCatalog() {
        val data = listOf(
            Catalog(
                image = R.drawable.img_catalog_spaghetti,
                name = "Spaghetti",
                price = 25_000.00
            ),
            Catalog(image = R.drawable.img_catalog_meatball, name = "Bakso", price = 40_000.00),
            Catalog(image = R.drawable.img_catalog_tea, name = "Es Teh", price = 5_000.00),
            Catalog(image = R.drawable.img_catalog_burger, name = "Burger", price = 32_000.00),
            Catalog(
                image = R.drawable.img_catalog_fried_rice,
                name = "Nasi Goreng",
                price = 20_000.00
            ),
            Catalog(image = R.drawable.img_catalog_salad, name = "Salad", price = 22_000.00),
            Catalog(image = R.drawable.img_catalog_ramen, name = "Ramen", price = 50_000.00),
            Catalog(image = R.drawable.img_catalog_sushi, name = "Sushi Roll", price = 38_000.00),
        )

        binding.rvCatalog.apply {
            adapter = this@MainActivity.catalogAdapter
        }
        catalogAdapter.submitData(data)
    }

    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Selected Profile Icon", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.tvName.text = ("Hi There")
    }
}
