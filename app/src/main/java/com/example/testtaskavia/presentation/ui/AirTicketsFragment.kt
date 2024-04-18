package com.example.testtaskavia.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskavia.app.App
import com.example.testtaskavia.databinding.FragmentAirTicketsBinding
import com.example.testtaskavia.presentation.adapter.OffersAdapter
import com.example.testtaskavia.presentation.viewmodels.AirTicketsViewModel
import com.example.testtaskavia.presentation.viewmodels.AirTicketsViewModelFactory
import javax.inject.Inject

class AirTicketsFragment : Fragment() {

    private var _binding: FragmentAirTicketsBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: AirTicketsViewModelFactory
    private lateinit var viewModel: AirTicketsViewModel
    private lateinit var offersAdapter: OffersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity?.applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)
                .get(AirTicketsViewModel::class.java)
        viewModel.getOffers()
        _binding = FragmentAirTicketsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObservers()
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(requireContext())
            .apply { orientation = LinearLayoutManager.HORIZONTAL }
        offersAdapter = OffersAdapter()
        binding.rcOffers.layoutManager = layoutManager
        binding.rcOffers.adapter = offersAdapter
    }

    private fun initObservers() {
        viewModel.offers.observe(viewLifecycleOwner){ offers ->
            offersAdapter.data = offers
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}