package com.example.practicacorrutina.corrutinas.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp



@Composable
fun Screen(screenVM : ScreenVM){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Boton_cambio_Color(screenVM = screenVM)
        Row {
            Text(text = screenVM.resultState)
            Barra_Loading(isLoading = screenVM.isLoading)
        }
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

@Composable
fun Barra_Loading(isLoading: Boolean) {
    if (isLoading) {
        CircularProgressIndicator(
            modifier = Modifier.size(25.dp)
        )
    }
}