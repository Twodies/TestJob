package com.example.testjob.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testjob.databinding.BottomSheetSearchBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SearchBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnRecOne.setOnClickListener {
                performAction(ActionType.ACTION_ONE)
            }
            btnRecTwo.setOnClickListener {
                performAction(ActionType.ACTION_TWO)
            }
            btnRecThree.setOnClickListener {
                performAction(ActionType.ACTION_THREE)
            }
        }
    }

    private fun performAction(action: ActionType) {
        when (action) {
            ActionType.ACTION_ONE -> {
                // Handle Action 1
            }
            ActionType.ACTION_TWO -> {
                // Handle Action 2
            }
            ActionType.ACTION_THREE -> {
                // Handle Cancel
            }

            ActionType.CANCEL -> {

            }
        }
        dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

enum class ActionType {
    ACTION_ONE,
    ACTION_TWO,
    ACTION_THREE,
    CANCEL
}
