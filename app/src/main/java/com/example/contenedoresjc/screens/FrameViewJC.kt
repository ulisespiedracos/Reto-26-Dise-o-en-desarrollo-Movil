package com.example.contenedoresjc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contenedoresjc.R
import com.example.contenedoresjc.ui.theme.ContenedoresJCTheme

/**
 * Video 24: equivalente del FrameLayout (XML) = Box.
 * Los hijos se apilan: caja roja > imagen > letrero, y encima los botones de play.
 * Se pone clickable DESPUÉS del padding externo y ANTES del padding interno para
 * que el área de clic sea todo el cuadro gris.
 */
@Composable
fun FrameView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Red)
    ) {
        Image(
            painter = painterResource(R.drawable.foto_robot),
            contentDescription = "logo del tecnm",
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .padding(horizontal = 16.dp)
        )
        Text(
            "Bienvenidos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 128.dp, top = 48.dp, end = 128.dp)
                .background(Color.White.copy(alpha = 0.6f))
        )

        // Caja que ocupa toda la pantalla solo para centrar el TextField
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            var nombre by remember { mutableStateOf("") }
            TextField(
                value = nombre,
                onValueChange = { nombre = it },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Green,
                    focusedContainerColor = Color.Cyan
                ),
                label = { Text("Escribe tu nombre") }
            )
        }

        // Caja del mismo tamaño que la imagen, transparente, con los dos botones abajo a la derecha
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Image(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 16.dp, bottom = 16.dp)
                    .background(Color.Gray)
                    .clickable { }
                    .padding(16.dp)
            )
            Image(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 96.dp, bottom = 16.dp)
                    .background(Color.Gray)
                    .clickable { }
                    .padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FrameViewPreview() {
    ContenedoresJCTheme {
        FrameView(Modifier.padding(top = 24.dp))
    }
}
