package com.example.agentchat.agents

import android.app.Application
import com.example.agentchat.BaseTests
import io.mockk.impl.annotations.MockK
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlinx.coroutines.test.runTest

class AgentsViewModelTests : BaseTests() {

    @MockK
    private lateinit var application: Application

    @MockK
    private lateinit var useCase: AgentsUseCase

    private lateinit var viewModel: AgentsViewModel

    @BeforeTest
    fun setUp() {
        super.baseSetup()
        viewModel = AgentsViewModel(application, useCase)
    }

    @Test
    fun `init - Should show loading, when get agent name is in progress`() = runTest {
        // TODO: Implement test to verify loading state
    }
}
