package com.example.testtaskavia.presentation.ui

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.testtaskavia.R
import com.example.testtaskavia.databinding.FragmentSearchDialogItemBinding
import com.example.testtaskavia.databinding.FragmentSearchDialogBinding

class SearchDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentSearchDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}