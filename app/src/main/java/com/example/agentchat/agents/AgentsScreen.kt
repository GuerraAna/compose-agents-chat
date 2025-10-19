package com.example.agentchat.agents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.agentchat.commons.theme.ui.AgentChatTheme
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.placeholder
import com.google.accompanist.placeholder.material.shimmer

@Composable
internal fun AgentsScreen(uiState: AgentsUiState) {
    when {
        uiState.isLoading -> OnLoading()
        uiState.isSuccess -> OnSuccess(uiState.message)
        uiState.isError -> OnError(uiState.message)
    }
}

@Composable
private fun OnLoading() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .width(200.dp)
                    .height(32.dp)
                    .placeholder(
                        visible = true,
                        highlight = PlaceholderHighlight.shimmer()
                    )
            )
        }
    }
}

@Composable
private fun OnSuccess(message: String?) {
    message?.let {
        SetupAgentText(name = message)
    } ?: OnError(message = null)
}

@Composable
private fun OnError(message: String?) {
    val errorMessage = message ?: "Unknown Error"
    SetupAgentText(name = errorMessage)
}

@Composable
private fun SetupAgentText(name: String) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(
            text = "Hello, $name!",
            modifier = Modifier.padding(paddingValues = innerPadding)
        )
    }
}

@Preview(showBackground = true)
@Composable
internal fun AgentsScreenLoadingPreview() {
    AgentChatTheme {
        val uiState = AgentsUiState(
            isLoading = true,
            isError = false,
            isSuccess = false
        )

        AgentsScreen(uiState)
    }
}

@Preview(showBackground = true)
@Composable
internal fun AgentsScreenSuccessPreview() {
    AgentChatTheme {
        val uiState = AgentsUiState(
            isSuccess = true,
            isLoading = false,
            isError = false,
            message = "Agent Smith"
        )

        AgentsScreen(uiState)
    }
}

@Preview(showBackground = true)
@Composable
internal fun AgentsScreenErrorPreview() {
    AgentChatTheme {
        val uiState = AgentsUiState(
            isSuccess = true,
            isLoading = false,
            isError = false,
            message = "Error fetching agent"
        )

        AgentsScreen(uiState)
    }
}
