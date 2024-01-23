package com.example.homework20.data.local.mapper.fish

import com.example.homework20.data.local.entity.FishEntity
import com.example.homework20.domain.model.fish.GetFish

fun FishEntity.toDomain(): GetFish = GetFish(
    id, name, type, location
)

fun GetFish.toDataLayerModel(): FishEntity = FishEntity(
    id, name, type, location
)
