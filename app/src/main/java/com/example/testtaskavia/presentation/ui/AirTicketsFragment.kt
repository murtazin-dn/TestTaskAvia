package com.example.testtaskavia.presentation.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskavia.R
import com.example.testtaskavia.app.App
import com.example.testtaskavia.databinding.FragmentAirTicketsBinding
import com.example.testtaskavia.presentation.adapter.OffersAdapter
import com.example.testtaskavia.presentation.utils.CyrillicInputFilter
import com.example.testtaskavia.presentation.utils.FROM_TEXT
import com.example.testtaskavia.presentation.utils.WHERE_TEXT
import com.example.testtaskavia.presentation.utils.ext.getNavigationResult
import com.example.testtaskavia.presentation.utils.ext.registerResultObserver
import com.example.testtaskavia.presentation.utils.ext.toEditable
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
        registerResultObserver<String>(SearchDialogFragment.REQUEST_KEY){ whereText ->
            binding.etWhere.text = whereText.toEditable()
            val fromText = binding.etFrom.text.toString()
            val bundle = bundleOf(
                FROM_TEXT to fromText,
                WHERE_TEXT to whereText
            )
            findNavController().navigate(
                R.id.action_navigation_air_tickets_to_countrySelectedFragment2,
                bundle
            )
        }
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

        binding.etFrom.filters = arrayOf(CyrillicInputFilter())
        binding.etFrom.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                println(p0.toString())
            }

        })
        binding.etWhere.setOnFocusChangeListener { _, hasFocus ->
            val fromText = binding.etFrom.text.toString()
            val bundle =
                if (!fromText.isEmpty()) bundleOf(FROM_TEXT to fromText)
            else null
            if (hasFocus) {
                binding.etWhere.clearFocus()
                findNavController()
                    .navigate(R.id.action_navigation_air_tickets_to_searchDialogFragment, bundle)
            }
        }
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