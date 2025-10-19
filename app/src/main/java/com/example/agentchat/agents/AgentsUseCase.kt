package com.example.agentchat.agents

internal class AgentsUseCase(
    private val repository: AgentsRepository = AgentsRepository()
) {

    /**
     * Get the agent name from the repository.
     */
    fun getAgentName(): String = repository.getAgentName()
}
