package com.example.practicacorrutina.corrutinas.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color


@Composable
fun Screen(screenVM : ScreenVM){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Boton_cambio_Color(screenVM = screenVM)
        Text(text = screenVM.resultState)
        Boton_llamda_api(screenVM = screenVM)
    }
}


@Composable
fun Boton_cambio_Color(screenVM: ScreenVM){
    Button(
        onClick = { screenVM.cambio_color() },
        colors = ButtonDefaults.buttonColors(containerColor = screenVM.obtener_color())
    ) {
        Text(text = "Cambiar color")
    }
}


@Composable
fun Boton_llamda_api(screenVM: ScreenVM){
    Button(onClick = { screenVM.fetchData() }) {
        Text(text = "Llamar API")
    }
}

