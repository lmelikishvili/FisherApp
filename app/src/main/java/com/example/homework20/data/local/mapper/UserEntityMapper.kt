package com.example.homework20.data.local.mapper

import com.example.homework20.data.local.entity.UserEntity
import com.example.homework20.domain.model.user.GetUser

fun UserEntity.toDomain(): GetUser = GetUser(
    id = id,
    firstName = firstName,
    lastName = lastName,
    age = age,
    email = email,
    password = password
)

fun GetUser.toDataLayerModel(): UserEntity = UserEntity(
    id = id,
    firstName = firstName,
    lastName = lastName,
    age = age,
    email = email,
    password = password
)