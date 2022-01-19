package com.example.mymovieapp

import Kesh.MySharedPreference
import Models.RvModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_edit_movie.*

class EditMovie : AppCompatActivity() {

    lateinit var list: ArrayList<RvModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)


        supportActionBar?.hide()

        MySharedPreference.init(this)

        list = ArrayList()
        list = MySharedPreference.objectString

        val model = intent.getSerializableExtra("model")
        val position = intent.getIntExtra("position", -1)

        if (model != null && position != -1){

            var title = list[position].title
            var authors = list[position].actor
            var about = list[position].about
            var date = list[position].date

            edit_title.setText(title)
            edit_actor.setText(authors)
            edit_aboutMovie.setText(about)
            edit_date.setText(date)
        }

        btn_Editsave.setOnClickListener {
            val title = edit_title.text.toString().trim()
            val actors = edit_actor.text.toString().trim()
            val about = edit_aboutMovie.text.toString().trim()
            val date = edit_date.text.toString().trim()

            if (title != "" && actors != "" && about != "" && date != "") {
                list = MySharedPreference.objectString

                list = MySharedPreference.objectString

                list.remove(list[position])

                list.add(RvModel(title, date, actors, about))

                MySharedPreference.objectString = list

                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Malumot tog`ri emas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}