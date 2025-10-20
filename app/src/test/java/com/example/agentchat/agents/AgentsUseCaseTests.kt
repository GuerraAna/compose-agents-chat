package com.example.agentchat.agents

import com.example.agentchat.BaseTests
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkConstructor
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlinx.coroutines.test.runTest

class AgentsUseCaseTests : BaseTests() {

    @MockK
    private lateinit var repository: AgentsRepository

    private lateinit var useCase: AgentsUseCase

    @BeforeTest
    fun setup() {
        super.baseSetup()
        useCase = AgentsUseCase(repository)
    }

    @Test
    fun `getAgentName - Should return agent name as expected, when call repository to get agent name`() =
        runTest {
            val expectedAgentName = "Agent Smith"
            every { repository.getAgentName() } returns expectedAgentName

            val result = useCase.getAgentName()
            assertEquals(expectedAgentName, result)
        }

    @Test
    fun `getAgentName - Should return another agent name as expected, when call repository to get agent name`() =
        runTest {
            val expectedAgentName = "Agent Johnson"
            every { repository.getAgentName() } returns expectedAgentName

            val result = useCase.getAgentName()
            assertEquals(expectedAgentName, result)
        }

    @Test
    fun `getAgentName - Should return empty string, when repository returns empty string`() =
        runTest {
            val expectedAgentName = ""
            every { repository.getAgentName() } returns expectedAgentName

            val result = useCase.getAgentName()
            assertEquals(expectedAgentName, result)
        }

    @Test
    fun `getAgentName - Should throw exception, when repository throws exception`() = runTest {
        val expectedException = RuntimeException("Repository error")
        every { repository.getAgentName() } throws expectedException

        val result = assertFails { useCase.getAgentName() }
        assertEquals(expectedException.message, result.message)
    }

    @Test
    fun `getAgentName - Should return expected agent name, when repository is called as default in constructor`() =
        runTest {
            val defaultUseCase = AgentsUseCase()
            val expectedAgentName = "Agent Smith"

            mockkConstructor(AgentsRepository::class)
            every { anyConstructed<AgentsRepository>().getAgentName() } returns expectedAgentName

            val result = defaultUseCase.getAgentName()
            assertEquals(expectedAgentName, result)
        }
}
