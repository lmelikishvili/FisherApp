package com.example.homework20.presentation.screen.welcome

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.homework20.R
import com.example.homework20.databinding.FragmentWelcomeBinding
import com.example.homework20.presentation.base.BaseFragment
import com.example.homework20.presentation.event.navigation.NavigationEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {
    private val viewModel: WelcomeViewModel by viewModels()
    override fun setup() {

    }

    override fun setupListeners() {
        with(binding) {
            btnLogin.setOnClickListener { viewModel.onEvent(NavigationEvent.NavigateToLogin) }
            btnRegister.setOnClickListener { viewModel.onEvent(NavigationEvent.NavigateToRegister) }
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


    private fun handleNavigationEvents(event: WelcomeViewModel.LogInUiEvent) {
        when (event) {
            is WelcomeViewModel.LogInUiEvent.NavigateToLogin -> findNavController().navigate(
                R.id.action_welcomeFragment_to_loginFragment
            )

            is WelcomeViewModel.LogInUiEvent.NavigateToRegister -> findNavController().navigate(
                R.id.action_welcomeFragment_to_registerFragment
            )
        }
    }

}