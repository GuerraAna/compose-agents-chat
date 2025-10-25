package com.example.agentchat.agents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.agentchat.commons.theme.ui.AgentChatTheme
import com.google.accompanist.placeholder.placeholder

@Composable
internal fun AgentsScreen(uiState: AgentsUiState) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .testTag("agent_name_screen"),
            contentAlignment = Alignment.Center
        ) {
            SetupAgentMessage(uiState)
        }
    }
}

@Composable
private fun SetupAgentMessage(uiState: AgentsUiState) {
    if (uiState.isLoading) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(32.dp)
                .placeholder(
                    visible = true,
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = MaterialTheme.shapes.medium,
                )
        )
    } else {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .testTag("agent_message"),
            contentAlignment = Alignment.Center
        ) {
            when {
                uiState.isError -> Text(
                    text = "Error loading agent name",
                    modifier = Modifier
                        .testTag("agent_error_message")
                        .background(color = Color.Red)
                )

                else -> {
                    val message = uiState.message ?: "No agent name available"

                    Text(
                        text = message,
                        modifier = Modifier
                            .testTag("agent_message")
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
internal fun AgentsScreenLoadingPreview() {
    AgentChatTheme {
        AgentsScreen(
            uiState = AgentsUiState(isLoading = true)
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun AgentsScreenMessagePreview() {
    AgentChatTheme {
        AgentsScreen(
            uiState = AgentsUiState(
                isLoading = false,
                message = "Agent Smith"
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun AgentsScreenErrorPreview() {
    AgentChatTheme {
        AgentsScreen(
            uiState = AgentsUiState(
                isLoading = false,
                isError = false,
                message = "Error fetching agent"
            )
        )
    }
}
