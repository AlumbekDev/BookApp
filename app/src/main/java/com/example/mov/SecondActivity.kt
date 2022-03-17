package com.example.mov

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    var mainImageView: ImageView? = null
    var title: TextView? = null
    var description: TextView? = null
    private val model: LanguageModel? = null
    var data1: String? = null
    var data2: String? = null
    var myImage = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mainImageView = findViewById(R.id.mainImageView)
        title = findViewById(R.id.title)
        description = findViewById(R.id.description)
        if (intent.hasExtra("title")) {
            title?.text = Server.getModelByTitle(intent.getStringExtra("title"))?.description
        }
    }

    val data: Unit
        get() {
            if (intent.hasExtra("myImage") && intent.hasExtra("data1") &&
                intent.hasExtra("data2")
            ) {
                data1 = intent.getStringExtra("data1")
                data2 = intent.getStringExtra("data2")
                myImage = intent.getIntExtra("myImage", 1)
            } else {
                Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show()
            }
        }

    private fun setData() {
        title!!.text = data1
        description!!.text = data2
        mainImageView!!.setImageResource(myImage)
    }

    companion object {
        const val NAME = "Name"
    }
}