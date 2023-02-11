package com.priyansh.gdsclogin.domain

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {
    var successfullLogin by mutableStateOf(false)
    private set

    var logout by mutableStateOf(false)
    private set

    fun handleInput(event: Events) {
        viewModelScope.launch {
            when (event) {
                is Events.Login -> {
                    successfullLogin = repository.validateStudent(event.student)
                }

                is Events.Register -> {
                    repository.register(event.student)
                    successfullLogin = true
                }
                is Events.Logout -> {
                    logout = true
                }
            }
        }
    }
}