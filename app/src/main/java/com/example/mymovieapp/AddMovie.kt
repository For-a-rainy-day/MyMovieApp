package com.example.mymovieapp

import Kesh.MySharedPreference
import Models.RvModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_movie.*

class AddMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_movie)
        supportActionBar?.hide()

        MySharedPreference.init(this)

        btn_save.setOnClickListener {
            val title = edt_title.text.toString().trim()
            val actor = edt_actor.text.toString().trim()
            val about = edt_aboutMovie.text.toString().trim()
            val date = edt_date.text.toString().trim()

            if (title != "" && actor != "" && about != "" && date != "") {
                val list = MySharedPreference.objectString
                list.add(RvModel(title, actor, about, date))
                MySharedPreference.objectString = list
                Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Ma'lumot yetarli emas", Toast.LENGTH_SHORT).show()
            }

        }
    }
}