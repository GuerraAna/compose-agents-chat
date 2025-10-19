package com.example.agentchat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.agentchat.agents.AgentsScreen
import com.example.agentchat.agents.AgentsViewModel
import com.example.agentchat.commons.theme.ui.AgentChatTheme

/**
 * Represents the main activity of the Agent Chat application.
 */
class MainActivity : ComponentActivity() {

    private val agentsViewModel: AgentsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { SetupAgentsScreen() }
    }

    @Composable
    private fun SetupAgentsScreen() {
        val agentsUiState = agentsViewModel.agentsUiState.collectAsState()
        val uiState = agentsUiState.value

        AgentChatTheme {
            AgentsScreen(uiState = uiState)
        }
    }
}
