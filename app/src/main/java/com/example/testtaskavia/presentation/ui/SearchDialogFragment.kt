package com.example.testtaskavia.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import android.widget.TextView.OnEditorActionListener
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.testtaskavia.R
import com.example.testtaskavia.databinding.FragmentSearchDialogBinding
import com.example.testtaskavia.presentation.utils.CyrillicInputFilter
import com.example.testtaskavia.presentation.utils.FROM_TEXT
import com.example.testtaskavia.presentation.utils.WHERE_TEXT
import com.example.testtaskavia.presentation.utils.ext.setNavigationResult
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
            navigateToSearchCountrySelected(resources.getString(R.string.title_phuket))
        }
        binding.btnSochi.setOnClickListener{
            navigateToSearchCountrySelected(resources.getString(R.string.title_sochi))
        }
        binding.btnStambul.setOnClickListener{
            navigateToSearchCountrySelected(resources.getString(R.string.title_stambul))
        }

        binding.etWhere.setOnEditorActionListener{ v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                navigateToSearchCountrySelected(binding.etWhere.text.toString())
                true
            } else false
        }

        binding.btnSearch1.setOnClickListener{
            findNavController().navigate(R.id.action_searchDialogFragment_to_searchFragment1)
        }
        binding.btnSearch2.setOnClickListener{
            navigateToSearchCountrySelected(resources.getString(R.string.title_search2))
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

        arguments?.getString(FROM_TEXT)?.let { fromText ->
            binding.etFrom.text = fromText
            binding.etFrom.setTextColor(resources.getColor(R.color.white))
        } ?: {
            binding.etFrom.text = resources.getString(R.string.hint_from)
            binding.etFrom.setTextColor(resources.getColor(R.color.grey6))
        }
        binding.etWhere.setImeActionLabel("done", EditorInfo.IME_ACTION_DONE)

        binding.etWhere.filters = arrayOf(CyrillicInputFilter())
    }

    private fun navigateToSearchCountrySelected(whereText: String) {
        setNavigationResult(whereText, REQUEST_KEY)
        findNavController().popBackStack()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val REQUEST_KEY = "SEARCH_DIALOG_FRAGMENT_REQUEST_KEY"
    }

}