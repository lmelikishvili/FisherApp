package com.example.homework20.presentation.screen.register

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.homework20.R
import com.example.homework20.databinding.FragmentRegisterBinding
import com.example.homework20.presentation.base.BaseFragment
import com.example.homework20.presentation.event.users.UsersEvent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.random.Random

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    private val viewModel: RegisterViewModel by viewModels()
    override fun setup() {

    }

    override fun setupListeners() {
        binding.btnAdd.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser(){
        viewModel.onEvent(
            UsersEvent.CreateUser(
                id = Random.nextInt(),
                firstName = binding.etFirstname.text.toString(),
                lastName = binding.etLastname.text.toString(),
                age = binding.etAge.text.toString().toInt(),
                email = binding.etEmail.text.toString(),
                password = binding.etPassword.text.toString()
            )
        )
    }

    override fun bindData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.users.collect {
                    Log.d("usersListFromDB", "${it}")
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiEvent.collect {
                    handleNavigationEvents(event = it)
                }
            }
        }
    }

    private fun handleNavigationEvents(event: RegisterViewModel.RegisterUiEvent) {
        when (event) {
            is RegisterViewModel.RegisterUiEvent.NavigateToLogin -> findNavController().navigate(
                R.id.action_registerFragment_to_loginFragment
            )
        }
    }
}