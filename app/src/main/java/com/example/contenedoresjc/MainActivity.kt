package com.example.contenedoresjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.contenedoresjc.screens.ConstraintView
import com.example.contenedoresjc.screens.FrameView
import com.example.contenedoresjc.screens.RetoConstraintView
import com.example.contenedoresjc.screens.ScrollLinearView
import com.example.contenedoresjc.ui.theme.ContenedoresJCTheme

/** Una entrada por layout. El reto del video 26 se agregará aquí como otra más. */
private enum class Vista(val titulo: String) {
    Linear("Videos 22-23: Linear (Column / Row)"),
    Frame("Video 24: Frame (Box)"),
    Constraint("Video 25: ConstraintLayout"),
    Reto("Video 26: Reto Constraint JC"),
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContenedoresJCTheme {
                var actual by remember { mutableStateOf<Vista?>(null) }
                BackHandler(enabled = actual != null) { actual = null }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val m = Modifier.padding(innerPadding)
                    when (actual) {
                        null -> Menu(m) { actual = it }
                        Vista.Linear -> ScrollLinearView(m)
                        Vista.Frame -> FrameView(m)
                        Vista.Constraint -> ConstraintView(m)
                        Vista.Reto -> RetoConstraintView(m)
                    }
                }
            }
        }
    }
}

@Composable
private fun Menu(modifier: Modifier, onSelect: (Vista) -> Unit) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Contenedores en Jetpack Compose")
        Vista.entries.forEach {
            Button(onClick = { onSelect(it) }, modifier = Modifier.fillMaxWidth()) {
                Text(it.titulo)
            }
        }
    }
}
