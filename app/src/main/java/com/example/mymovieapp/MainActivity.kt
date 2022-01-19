package com.example.mymovieapp

import Adapter.RvAdapter
import Kesh.MySharedPreference
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        img_add.setOnClickListener {
            startActivity(Intent(this, AddMovie::class.java))
        }
    }

    override fun onStart() {
        super.onStart()


        MySharedPreference.init(this)
        val list = MySharedPreference.objectString
        rvAdapter = RvAdapter(this, list)

        rvAdapter.notifyDataSetChanged()
        recyclerMovies.adapter = rvAdapter

    }
}