package com.example.homework20.presentation.screen.fish

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework20.databinding.FragmentFishBinding
import com.example.homework20.presentation.base.BaseFragment
import com.example.homework20.presentation.event.fishs.FishsEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FishFragment : BaseFragment<FragmentFishBinding>(FragmentFishBinding::inflate) {
    private val viewModel: FishViewModel by viewModels()
    private lateinit var adapter: FishRvAdapter

    override fun setup() {
        adapter = FishRvAdapter()
        binding.apply {
            fishRecyclerView.layoutManager = LinearLayoutManager(requireContext())
            fishRecyclerView.setHasFixedSize(true)
            fishRecyclerView.adapter = adapter
        }

    }

    override fun setupListeners() {
        binding.btdAdd.setOnClickListener(){
            viewModel.onEvent(FishsEvent.AddFish)
        }

    }

    override fun bindData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.fishs.collect {
                    adapter.submitList(it)
                    Log.d("fishsListFromDB", "${it}")
                }
            }
        }
    }
}