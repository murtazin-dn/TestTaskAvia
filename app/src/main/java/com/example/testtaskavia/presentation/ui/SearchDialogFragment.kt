package com.example.testtaskavia.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import android.widget.TextView.OnEditorActionListener
import androidx.navigation.fragment.findNavController
import com.example.testtaskavia.R
import com.example.testtaskavia.databinding.FragmentSearchDialogBinding
import com.example.testtaskavia.presentation.utils.CyrillicInputFilter
import com.example.testtaskavia.presentation.utils.ext.toEditable
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


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
        initViews()
        initListeners()
    }

    private fun initListeners() {
        binding.btnClear.setOnClickListener {
            binding.etWhere.text = "".toEditable()
        }

        binding.btnPhuket.setOnClickListener{
            binding.etWhere.text = resources.getString(R.string.title_phuket).toEditable()
            navigateToSearchCountrySelected()
        }
        binding.btnSochi.setOnClickListener{
            binding.etWhere.text = resources.getString(R.string.title_sochi).toEditable()
            navigateToSearchCountrySelected()
        }
        binding.btnStambul.setOnClickListener{
            binding.etWhere.text = resources.getString(R.string.title_stambul).toEditable()
            navigateToSearchCountrySelected()
        }

        binding.etWhere.setOnEditorActionListener{ v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                navigateToSearchCountrySelected()
                true
            } else false
        }

        binding.btnSearch1.setOnClickListener{
            findNavController().navigate(R.id.action_searchDialogFragment_to_searchFragment1)
        }
        binding.btnSearch2.setOnClickListener{
            findNavController().navigate(R.id.action_searchDialogFragment_to_searchFragment2)
        }
        binding.btnSearch3.setOnClickListener{
            findNavController().navigate(R.id.action_searchDialogFragment_to_searchFragment3)
        }
        binding.btnSearch4.setOnClickListener{
            findNavController().navigate(R.id.action_searchDialogFragment_to_searchFragment4)
        }
    }

    private fun initViews() {
        val bottomSheet: FrameLayout =
            dialog?.findViewById(com.google.android.material.R.id.design_bottom_sheet)!!
        bottomSheet.layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
        val behavior = BottomSheetBehavior.from(bottomSheet)
        behavior.apply {
            peekHeight = resources.displayMetrics.heightPixels
            state = BottomSheetBehavior.STATE_EXPANDED
        }

        arguments?.getString(AirTicketsFragment.FROM_TEXT)?.let { fromText ->
            binding.etFrom.text = fromText
            binding.etFrom.setTextColor(resources.getColor(R.color.white))
        } ?: {
            binding.etFrom.text = resources.getString(R.string.hint_from)
            binding.etFrom.setTextColor(resources.getColor(R.color.grey6))
        }
        binding.etWhere.setImeActionLabel("done", EditorInfo.IME_ACTION_DONE)

        binding.etWhere.filters = arrayOf(CyrillicInputFilter())
    }

    private fun navigateToSearchCountrySelected() {
        println("dsfsd")
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}