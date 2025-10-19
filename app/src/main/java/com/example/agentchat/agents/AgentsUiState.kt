package com.example.agentchat.agents

internal data class AgentsUiState(
    val message: String? = null,
    val isLoading: Boolean = true,
    val isSuccess: Boolean = false,
    val isError: Boolean = false
)
