package com.example.mov.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mov.databinding.ItemBooksBinding
import com.example.mov.domain.models.LanguageModel

class MovAdapter(
    val onItemClick: (LanguageModel) -> Unit
) : RecyclerView.Adapter<MovAdapter.BooksViewHolder>() {
    private var list: List<LanguageModel> = arrayListOf()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovAdapter.BooksViewHolder {
        return BooksViewHolder(
            ItemBooksBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovAdapter.BooksViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun setList(list: List<LanguageModel>) {
        this.list = list
    }


    override fun getItemCount(): Int {
        return list.size
    }

    inner class BooksViewHolder(private val binding: ItemBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(bookModel: LanguageModel) {
            binding.myText1.text = bookModel.title
            binding.myImageView.setImageResource(bookModel.image)
            binding.root.setOnClickListener {
                onItemClick(bookModel)
            }
        }
    }
}