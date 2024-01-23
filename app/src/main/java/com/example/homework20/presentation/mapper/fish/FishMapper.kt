package com.example.homework20.presentation.mapper.fish

import com.example.homework20.domain.model.fish.GetFish
import com.example.homework20.presentation.model.fish.Fish

fun GetFish.toPresenter() = Fish(
    id, name, type, location
)