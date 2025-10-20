package com.example.agentchat.agents

import com.example.agentchat.BaseTests
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class AgentsRepositoryTests : BaseTests() {

    private lateinit var repository: AgentsRepository

    @BeforeTest
    fun setup() {
        super.baseSetup()
        repository = AgentsRepository()
    }

    @Test
    fun `getAgentName - Should return agent name as expected`() {
        val expectedAgentName = "Agent Smith"
        val result = repository.getAgentName()
        assertEquals(expectedAgentName, result)
    }
}