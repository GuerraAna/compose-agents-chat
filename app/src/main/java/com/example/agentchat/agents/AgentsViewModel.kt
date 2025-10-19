package com.example.agentchat.agents

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class AgentsViewModel @JvmOverloads constructor(
    application: Application,
    useCase: AgentsUseCase = AgentsUseCase()
) : AndroidViewModel(application) {

    private val _agentsUiState = MutableStateFlow(value = AgentsUiState(isLoading = true))

    /**
     * Represents the UI state for the Agents screen.
     */
    val agentsUiState: StateFlow<AgentsUiState> = _agentsUiState

    init {
        viewModelScope.launch {
            initializeAgentsUi(useCase)
        }
    }

    private suspend fun initializeAgentsUi(useCase: AgentsUseCase) {
        delay(timeMillis = 2000)

        try {
            val result = useCase.getAgentName()

            _agentsUiState.value = AgentsUiState(
                message = result,
                isLoading = false,
                isSuccess = true
            )
        } catch (error: Exception) {
            val errorMessage: String = requireNotNull(error.message)

            _agentsUiState.value = AgentsUiState(
                message = errorMessage,
                isError = true,
                isLoading = false
            )
        }
    }
}
