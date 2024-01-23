package com.example.homework20.presentation.screen.fish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework20.domain.model.fish.GetFish
import com.example.homework20.domain.usecase.fish.GetFishUseCase
import com.example.homework20.domain.usecase.fish.InsertFishUseCase
import com.example.homework20.presentation.event.fishs.FishsEvent
import com.example.homework20.presentation.mapper.fish.toPresenter
import com.example.homework20.presentation.model.fish.Fish
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class FishViewModel @Inject constructor(
    private val getFishUseCase: GetFishUseCase,
    private val insertFishUseCase: InsertFishUseCase
): ViewModel() {

    val fishs: Flow<List<Fish>> = getFishUseCase().map { fish ->
        fish.map {
            it.toPresenter()
        }
    }

    fun onEvent(event: FishsEvent) {
        when (event) {
            is FishsEvent.AddFish -> addFish()
        }
    }


    private fun addFish() {
        viewModelScope.launch {
            insertFishUseCase(
                fish = GetFish(
                    id = Random.nextInt(),
                    name = "nafota",
                    type = "Predator",
                    location = "Rivers"
                )
            )
        }
    }
}