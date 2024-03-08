package com.example.ch2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var ivProfile: ImageView? = null
    private var ivCart: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionProfile()
        setActionCart()
    }

    private fun setActionProfile() {
        ivProfile?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Selected Profile Page", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setActionCart() {
        ivCart?.setOnClickListener {
            Toast.makeText(this@MainActivity, "Selected Purchase List", Toast.LENGTH_SHORT).show()
        }
    }
}