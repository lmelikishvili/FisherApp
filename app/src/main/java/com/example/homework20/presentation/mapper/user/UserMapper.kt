package com.example.homework20.presentation.mapper.user

import com.example.homework20.domain.model.user.GetUser
import com.example.homework20.presentation.model.user.User

fun GetUser.toPresenter() = User(
    id = id,
    firstName = firstName,
    lastName = lastName,
    age = age,
    email = email,
    password = password
)