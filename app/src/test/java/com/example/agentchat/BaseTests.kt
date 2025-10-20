package com.example.agentchat

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.unmockkAll
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain

@ExperimentalCoroutinesApi
abstract class BaseTests {

    /**
     * A test dispatcher for controlling coroutine execution in tests.
     */
    val testDispatcher = StandardTestDispatcher()

    /**
     * Sets up the test environment before each test.
     * This includes initializing MockK annotations
     * and setting the main dispatcher to the test dispatcher.
     */
    @BeforeTest
    fun baseSetup() {
        // Setup code before each test
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
    }

    /**
     * Cleans up the test environment after each test.
     * This includes resetting the main dispatcher
     * and clearing all MockK mocks.
     */
    @AfterTest
    fun baseTeardown() {
        // Cleanup code after each test
        Dispatchers.resetMain()
        unmockkAll()
        clearAllMocks()
    }
}
