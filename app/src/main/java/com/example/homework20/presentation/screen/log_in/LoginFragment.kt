package com.example.homework20.presentation.screen.log_in

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.homework20.R
import com.example.homework20.databinding.FragmentLoginBinding
import com.example.homework20.presentation.base.BaseFragment
import com.example.homework20.presentation.event.navigation.NavigationEvent
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel: LoginViewModel by viewModels()
    override fun setup() {

    }

    override fun setupListeners() {
        binding.btnLogin.setOnClickListener(){
            viewModel.onEvent(NavigationEvent.NavigateToFishFragment)
        }

    }

    override fun bindData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEvent.collect {
                    handleNavigationEvents(event = it)
                }
            }
        }
    }

    private fun handleNavigationEvents(event: LoginViewModel.LogInUiEvent) {
        when (event) {
            is LoginViewModel.LogInUiEvent.NavigateToFishFragment -> findNavController().navigate(
                R.id.action_loginFragment_to_fishFragment
            )
        }
    }

}