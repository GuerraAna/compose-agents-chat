package com.example.agentchat.agents

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class AgentsUseCase(
    private val repository: AgentsRepository = AgentsRepository()
) {

    /**
     * Get the agent name from the repository.
     */
    suspend fun getAgentName(): String = withContext(Dispatchers.IO) {
        repository.getAgentName()
    }
}
