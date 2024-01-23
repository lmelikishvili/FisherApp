package com.example.homework20.presentation.screen.user

import android.util.Log.d
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.homework20.databinding.FragmentUsersBinding
import com.example.homework20.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UsersFragment : BaseFragment<FragmentUsersBinding>(FragmentUsersBinding::inflate) {
    private val viewModel: UsersViewModel by viewModels()

    override fun setup() {

    }

    override fun setupListeners() {

    }

    override fun bindData() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.users.collect{
                    d("usersListFromDB", "${it}")
                }
            }
        }
    }
}