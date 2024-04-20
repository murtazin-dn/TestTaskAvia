package com.example.testtaskavia.presentation.ui

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtaskavia.R
import com.example.testtaskavia.app.App
import com.example.testtaskavia.databinding.FragmentCountrySelectedBinding
import com.example.testtaskavia.presentation.adapter.TicketsOffersAdapter
import com.example.testtaskavia.presentation.utils.FROM_TEXT
import com.example.testtaskavia.presentation.utils.WHERE_TEXT
import com.example.testtaskavia.presentation.utils.ext.toEditable
import com.example.testtaskavia.presentation.utils.formatDate
import com.example.testtaskavia.presentation.utils.getCurrentDateFormatted
import com.example.testtaskavia.presentation.viewmodels.CountrySelectedViewModel
import com.example.testtaskavia.presentation.viewmodels.CountrySelectedViewModelFactory
import com.google.android.material.chip.Chip
import java.util.Calendar
import javax.inject.Inject

class CountrySelectedFragment : Fragment() {

    private var _binding: FragmentCountrySelectedBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: CountrySelectedViewModelFactory
    private lateinit var viewModel: CountrySelectedViewModel

    private lateinit var ticketsOffersAdapter: TicketsOffersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity?.applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CountrySelectedViewModel::class.java)
        viewModel.getOffers()
        _binding = FragmentCountrySelectedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initListeners()
    }

    private fun initListeners() {
        viewModel.ticketsOffers.observe(viewLifecycleOwner) { ticketsOffers ->
            ticketsOffersAdapter.data = ticketsOffers
        }
        binding.chipBack.setOnClickListener{it as Chip
            showDatePickerDialog { date ->
                it.text = date
            }
        }
        binding.chipDate.setOnClickListener{it as Chip
            showDatePickerDialog { date ->
                it.text = date
                it.isChipIconVisible = false
            }
        }
        binding.btnChange.setOnClickListener{reversePlaceText()}
        binding.btnClear.setOnClickListener{binding.etWhere.text = "".toEditable()}
        binding.btnBack.setOnClickListener{findNavController().popBackStack()}
    }

    private fun initViews() {
        val layoutManager = LinearLayoutManager(requireContext())
        ticketsOffersAdapter = TicketsOffersAdapter()
        binding.recycler.layoutManager = layoutManager
        binding.recycler.adapter = ticketsOffersAdapter

        val fromText = arguments?.getString(FROM_TEXT, null)
            ?: resources.getString(R.string.moskva)
        val whereText = arguments?.getString(WHERE_TEXT, null)
            ?: resources.getString(R.string.turcia)
        binding.etFrom.text = fromText.toEditable()
        binding.etWhere.text = whereText.toEditable()

        binding.chipDate.text = getCurrentDateFormatted()
    }

    private fun reversePlaceText(){
        val fromText = binding.etFrom.text
        val whereText = binding.etWhere.text
        binding.etFrom.text = whereText
        binding.etWhere.text = fromText
    }

    private fun showDatePickerDialog(action: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(), { _, year, month, day ->
            val selectedDate = formatDate(year, month, day)
            action.invoke(selectedDate)
        }, year, month, day)

        datePickerDialog.show()
    }

}