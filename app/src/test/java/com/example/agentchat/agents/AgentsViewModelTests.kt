package com.example.agentchat.agents

import android.app.Application
import com.example.agentchat.BaseTests
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlin.test.BeforeTest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class AgentsViewModelTest : BaseTests() {

    @MockK
    private lateinit var useCase: AgentsUseCase

    @MockK
    private lateinit var application: Application

    private lateinit var viewModel: AgentsViewModel

    @BeforeTest
    fun setUp() {
        viewModel = AgentsViewModel(application, useCase)
    }

    @Test
    fun `initializeAgentsUi should update state to success`() = runTest {
        val expectedMessage = "O nome do agente é Bob"
        coEvery { useCase.getAgentName() } returns expectedMessage

        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.agentsUiState.first()
        assertFalse(uiState.isLoading)
        assertTrue(uiState.isSuccess)
        assertEquals(expectedMessage, uiState.message)
    }

    @Test
    fun `initializeAgentsUi should update state to error`() = runTest {
        val errorMessage = "Falha ao obter o nome do agente"
        coEvery { useCase.getAgentName() } throws Exception(errorMessage)

        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = viewModel.agentsUiState.first()
        assertFalse(uiState.isLoading)
        assertTrue(uiState.isError)
        assertEquals(errorMessage, uiState.message)
    }

    @Test
    fun `initializeAgentsUi should return loading, when has default constructor`() = runTest {
        val defaultViewModel = AgentsViewModel(application)

        testDispatcher.scheduler.advanceUntilIdle()

        val uiState = defaultViewModel.agentsUiState.first()
        assertTrue(uiState.isLoading)
    }
}
