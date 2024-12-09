package com.example.testjob.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testjob.R
import com.example.testjob.databinding.FragmentHomeBinding
import com.example.testjob.fragments.home.adapter.AdapterOffers
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentHome : Fragment() {

    private val viewModel: VMHome by viewModels()
    private lateinit var binding: FragmentHomeBinding

    private val adapter by lazy {
        AdapterOffers(viewModel.homeData.value?.offers ?: emptyList())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        observeViewModel()
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.crSearchbar.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentHome_to_searchBottomSheet)
        }
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.homeData.collect {
                Log.e("OFFERS", "observeViewModel: " + it?.offers?.size)
                if (it != null && it.offers.isNotEmpty()) {
                    setAdapter()
                }

            }
        }
    }

    private fun setAdapter() {
        binding.rvOffers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvOffers.adapter = adapter
    }

}