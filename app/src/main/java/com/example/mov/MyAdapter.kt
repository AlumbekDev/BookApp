package com.example.mov

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val list: MutableList<LanguageModel>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var onItemClickListener: OnItemClickListener? = null
    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    fun addBook(model: LanguageModel) {
        list.add(model)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, ViewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var myText1: TextView = itemView.findViewById(R.id.myText1)
        var myImage: ImageView = itemView.findViewById(R.id.myImageView)
        fun bind(languageModel: LanguageModel) {
            myText1.text = languageModel.title
            myImage.setImageResource(languageModel.image)
            itemView.setOnClickListener { onItemClickListener?.onClickItem(adapterPosition) }
        }

    }
}