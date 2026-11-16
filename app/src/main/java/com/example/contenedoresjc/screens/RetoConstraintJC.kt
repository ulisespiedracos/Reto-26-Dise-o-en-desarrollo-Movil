package com.example.contenedoresjc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.contenedoresjc.R
import com.example.contenedoresjc.ui.theme.ContenedoresJCTheme

/**
 * Video 26 - Reto Constraint JC.
 * Réplica de la pantalla de ejemplo con ConstraintLayout:
 *  cabecera (imagen + texto + caja), 3 botones escalonados, letrero "Constraint",
 *  imagen grande y 2 botones de play encima de ella.
 * Todos los elementos son clicables (los Button y clickable muestran la animación ripple).
 */
@Composable
fun RetoConstraintView(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        val (logo, tvMargen, caja, boton1, boton2, boton3, letrero, imagen, play1, play2) = createRefs()

        // ---- Cabecera ----
        Image(
            painter = painterResource(R.drawable.foto_robot),
            contentDescription = "Imagen de la cabecera",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(logo) {
                    start.linkTo(parent.start, margin = 16.dp)
                    top.linkTo(parent.top, margin = 16.dp)
                }
                .size(width = 115.dp, height = 72.dp)
                .background(Color.White)
                .clickable { }
        )
        Text(
            "margen margen margen margen margen",
            fontSize = 16.sp,
            maxLines = 1,
            modifier = Modifier
                .constrainAs(tvMargen) {
                    start.linkTo(logo.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    top.linkTo(logo.top)
                    width = Dimension.fillToConstraints
                }
                .background(Color.Magenta)
                .clickable { }
        )
        Box(
            modifier = Modifier
                .constrainAs(caja) {
                    start.linkTo(tvMargen.start)
                    end.linkTo(tvMargen.end)
                    top.linkTo(tvMargen.bottom, margin = 8.dp)
                    bottom.linkTo(logo.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .background(Color.Cyan)
                .clickable { }
        )

        // ---- Tres botones (pista del video) ----
        // Botón1 y Botón3: start y end con la caja cian => centrados respecto a ella.
        // Botón2: start y end con el letrero "Constraint" => centrado respecto a él.
        Button(
            onClick = { },
            modifier = Modifier.constrainAs(boton1) {
                top.linkTo(logo.bottom, margin = 20.dp)
                start.linkTo(caja.start)
                end.linkTo(caja.end)
            }
        ) { Text("Botón1") }

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(boton2) {
                top.linkTo(boton1.bottom, margin = 24.dp)
                start.linkTo(letrero.start)
                end.linkTo(letrero.end)
            }
        ) { Text("Botón2") }

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(boton3) {
                top.linkTo(boton2.bottom, margin = 22.dp)
                start.linkTo(caja.start)
                end.linkTo(caja.end)
            }
        ) { Text("Botón3") }

        // ---- Letrero centrado ----
        Text(
            "Constraint",
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .constrainAs(letrero) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(boton3.bottom, margin = 130.dp)
                }
                .width(200.dp)
                .background(Color.Blue)
                .clickable { }
        )

        // ---- Imagen grande con sus dos botones de play ----
        Image(
            painter = painterResource(R.drawable.foto_robot),
            contentDescription = "Imagen principal",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .constrainAs(imagen) {
                    start.linkTo(parent.start, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    top.linkTo(letrero.bottom, margin = 16.dp)
                    width = Dimension.fillToConstraints
                }
                .height(200.dp)
                .background(Color.LightGray)
                .clickable { }
        )
        Image(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Play 1",
            modifier = Modifier
                .constrainAs(play1) {
                    end.linkTo(imagen.end, margin = 8.dp)
                    bottom.linkTo(imagen.bottom, margin = 8.dp)
                }
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                .background(Color.Gray)
                .clickable { }
                .padding(8.dp)
        )
        Image(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Play 2",
            modifier = Modifier
                .constrainAs(play2) {
                    end.linkTo(play1.start, margin = 8.dp)
                    bottom.linkTo(imagen.bottom, margin = 8.dp)
                }
                .clip(androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                .background(Color.Gray)
                .clickable { }
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RetoConstraintViewPreview() {
    ContenedoresJCTheme {
        RetoConstraintView(Modifier.padding(top = 24.dp))
    }
}
