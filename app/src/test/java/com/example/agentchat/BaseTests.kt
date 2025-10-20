package com.example.agentchat

import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.unmockkAll
import kotlin.test.AfterTest
import kotlin.test.BeforeTest

abstract class BaseTests {

    @BeforeTest
    fun baseSetup() {
        // Setup code before each test
        MockKAnnotations.init(this)
    }

    @AfterTest
    fun baseTeardown() {
        // Cleanup code after each test
        unmockkAll()
        clearAllMocks()
    }
}
