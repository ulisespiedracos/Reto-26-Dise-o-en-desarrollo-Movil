package com.example.contenedoresjc.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contenedoresjc.ui.theme.ContenedoresJCTheme

/**
 * Videos 22 y 23: equivalente del LinearLayout (XML) en Jetpack Compose.
 *
 * - Column = LinearLayout vertical, Row = LinearLayout horizontal.
 * - El ORDEN de las propiedades del Modifier importa: padding antes de background
 *   deja un marco blanco; background antes de padding pinta también el relleno.
 * - En Compose no existe margin: se imita con padding de un contenedor externo.
 */
@Composable
fun ScrollLinearView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()) // video 23: scroll vertical
            .fillMaxWidth()
            .padding(8.dp) // marco blanco alrededor
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // "wrap content": mide lo que mide su contenido
        Text(
            "wrap content",
            modifier = Modifier
                .background(Color.Cyan)
                .padding(horizontal = 8.dp)
        )

        // "match parent": la Column externa da el "margen" fuera de la caja azul
        Column(modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp)) {
            Text(
                "match parent",
                Modifier
                    .fillMaxWidth()
                    .background(Color.Blue),
                color = Color.White
            )
        }

        // Siete botones: sin el scroll, en horizontal los últimos no se verían
        Button(onClick = { }) { Text("Botón 1") }
        Button(onClick = { }) { Text("Botón 2") }
        Button(onClick = { }) { Text("Botón 3") }
        Button(onClick = { }) { Text("Botón 4") }

        // LinearLayout horizontal con cuadro gris, botones a la derecha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // El "view" verde: mide 40 de ancho, 16 se van en padding => 24 x 24 visibles
            Column(
                modifier = Modifier
                    .size(width = 40.dp, height = 24.dp)
                    .padding(end = 16.dp)
                    .background(Color.Green)
            ) {}
            Button(onClick = { }) { Text("Botón 5") }
            Button(
                onClick = { },
                modifier = Modifier.padding(start = 8.dp, end = 8.dp)
            ) { Text("Botón 6") }
            Button(onClick = { }) { Text("Botón 7") }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScrollLinearViewPreview() {
    ContenedoresJCTheme {
        ScrollLinearView(Modifier.padding(top = 24.dp))
    }
}
