package com.example.mov.presentation.ui.fragments

import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mov.R
import com.example.mov.databinding.FragmentBooksDetailsBinding
import com.example.mov.presentation.base.BaseFragment
import kotlinx.coroutines.launch

class BooksDetailsFragment : BaseFragment<FragmentBooksDetailsBinding>(
    R.layout.fragment_books_details
) {


    override val binding: FragmentBooksDetailsBinding by viewBinding(FragmentBooksDetailsBinding::bind)
    private val sharedViewModel: MovViewModel by activityViewModels()

    override fun setupViews() {
        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.description.observe(viewLifecycleOwner) { description ->
                binding.title.text = description.toString()

            }
        }
    }
}