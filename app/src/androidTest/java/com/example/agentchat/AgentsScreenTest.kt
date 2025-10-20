package com.example.agentchat

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.agentchat.agents.AgentsScreen
import com.example.agentchat.agents.AgentsUiState
import com.example.agentchat.commons.theme.ui.AgentChatTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AgentsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun agentsScreen_showsLoadingState() {
        val loadingUiState = AgentsUiState(
            message = "",
            isLoading = true,
            isError = false,
            isSuccess = false
        )

        composeTestRule.setContent {
            AgentChatTheme {
                AgentsScreen(uiState = loadingUiState)
            }
        }

        composeTestRule
            .onNodeWithTag("agent_name_placeholder")
            .assertIsDisplayed()
    }

    @Test
    fun agentsScreen_showsSuccessState() {
        val successUiState = AgentsUiState(
            message = "Rick and Morty",
            isLoading = false,
            isError = false,
            isSuccess = true
        )

        composeTestRule.setContent {
            AgentChatTheme {
                AgentsScreen(uiState = successUiState)
            }
        }

        composeTestRule
            .onNodeWithTag("agent_message")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Hello, Rick and Morty!")
            .assertIsDisplayed()
    }

    @Test
    fun agentsScreen_showsErrorState() {
        val errorUiState = AgentsUiState(
            message = "Erro ao carregar agentes",
            isLoading = false,
            isError = true,
            isSuccess = false
        )

        composeTestRule.setContent {
            AgentChatTheme {
                AgentsScreen(uiState = errorUiState)
            }
        }

        composeTestRule
            .onNodeWithTag("agent_message")
            .assertIsDisplayed()

        composeTestRule
            .onNodeWithText("Erro ao carregar agentes")
            .assertIsDisplayed()
    }
}