package com.example.testtaskavia.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskavia.R
import com.example.testtaskavia.app.App
import com.example.testtaskavia.databinding.FragmentTicketsBinding
import com.example.testtaskavia.presentation.adapter.TicketsAdapter
import com.example.testtaskavia.presentation.utils.DATE
import com.example.testtaskavia.presentation.utils.FROM_TEXT
import com.example.testtaskavia.presentation.utils.PASSENGERS_COUNT
import com.example.testtaskavia.presentation.utils.WHERE_TEXT
import com.example.testtaskavia.presentation.utils.formatDate2
import com.example.testtaskavia.presentation.viewmodels.AirTicketsViewModel
import com.example.testtaskavia.presentation.viewmodels.TicketsViewModel
import com.example.testtaskavia.presentation.viewmodels.TicketsViewModelFactory
import javax.inject.Inject

class TicketsFragment : Fragment() {

    private var _binding: FragmentTicketsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: TicketsViewModelFactory
    private lateinit var viewModel: TicketsViewModel

    private lateinit var adapter: TicketsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity?.applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(TicketsViewModel::class.java)
        viewModel.getTickets()
        _binding = FragmentTicketsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = TicketsAdapter()
        binding.rcTickets.adapter = adapter
        binding.rcTickets.layoutManager = LinearLayoutManager(requireContext())
        viewModel.tickets.observe(viewLifecycleOwner){ tickets ->
            adapter.data = tickets
        }

        val fromText = arguments?.getString(FROM_TEXT, null)
            ?: resources.getString(R.string.moskva)
        val whereText = arguments?.getString(WHERE_TEXT, null)
            ?: resources.getString(R.string.turcia)
        val passengersCount = arguments?.getInt(PASSENGERS_COUNT) ?: 1
        val date = formatDate2(arguments?.getString(DATE) ?: "2024-02-23T12:00:00")

        val title = "$fromText - $whereText"
        val subTitle = "$date, $passengersCount пассажир"

        binding.toolbar.title = title
        binding.toolbar.subtitle = subTitle
    }



}