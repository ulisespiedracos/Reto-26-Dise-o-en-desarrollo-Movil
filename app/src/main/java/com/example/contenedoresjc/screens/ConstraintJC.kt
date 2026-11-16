package com.example.contenedoresjc.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
 * Video 25: ConstraintLayout en Compose.
 * - createRefs() crea las "ids" de cada objeto.
 * - constrainAs(ref) { ... } define las constraints (start/end/top/bottom.linkTo).
 * - Aquí SÍ existe margin: linkTo(..., margin = 16.dp).
 * - Dimension.fillToConstraints = "0dp" de XML: rellena solo hasta donde llegan las constraints.
 */
@Composable
fun ConstraintView(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        val (imageViewLogo, tvMargen, caja, textoCentrado) = createRefs()

        // Texto centrado en la pantalla: las 4 constraints al parent
        Text(
            "Constraint",
            color = Color.White,
            fontSize = 35.sp,
            modifier = Modifier
                .constrainAs(textoCentrado) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
                .width(200.dp) // el tamaño va antes del background
                .background(Color.Blue),
            textAlign = TextAlign.Center
        )

        // Logo arriba a la izquierda con margen de 16
        Image(
            painter = painterResource(R.drawable.foto_robot),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(imageViewLogo) {
                    start.linkTo(parent.start, margin = 16.dp)
                    top.linkTo(parent.top, margin = 16.dp)
                }
                .background(Color.LightGray)
        )

        // Texto a la derecha del logo, de una sola línea
        Text(
            "margen margen margen margen margen margen",
            fontSize = 20.sp,
            maxLines = 1,
            modifier = Modifier
                .constrainAs(tvMargen) {
                    start.linkTo(imageViewLogo.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                    top.linkTo(imageViewLogo.top)
                    width = Dimension.fillToConstraints
                }
                .background(Color.Magenta)
        )

        // "View" de XML => Box en Compose, anclado debajo del texto y al fondo del logo
        Box(
            modifier = Modifier
                .constrainAs(caja) {
                    start.linkTo(tvMargen.start)
                    end.linkTo(tvMargen.end)
                    top.linkTo(tvMargen.bottom)
                    bottom.linkTo(imageViewLogo.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                }
                .padding(top = 8.dp)
                .background(Color.Cyan)
        )

        // Botón del final del video: sin constraints, por eso queda en la esquina superior izquierda
        Button(onClick = { }) { Text("Botón1") }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConstraintViewPreview() {
    ContenedoresJCTheme {
        ConstraintView(Modifier.padding(top = 24.dp))
    }
}
