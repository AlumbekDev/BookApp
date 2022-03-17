package com.example.mov

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    var myAdapter: MyAdapter? = null
    private var list: List<LanguageModel>? = null
    var languageModel: LanguageModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        list = Server.book
        myAdapter = MyAdapter(list as MutableList<LanguageModel>)
        val with = with(recyclerView) { this?.setAdapter(myAdapter) }
        recyclerView?.layoutManager = LinearLayoutManager(this)
        myAdapter!!.setOnItemClickListener(object : OnItemClickListener {

            override fun onClickItem(position: Int) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("title", list!![position].title)
                startActivity(intent)
            }
        })
    }
}