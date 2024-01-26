package com.example.practicacorrutina.corrutinas.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScreenVM: ViewModel(){

    private var color by mutableStateOf(false)
    private var cont by mutableStateOf(0)
    var resultState by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun cambio_color(){
        color = !color
    }

    fun obtener_color(): Color{
        return if (color){
              Color.Blue
        }else{
            Color.Red
        }
    }
    fun bloqueo_app(){
        Thread.sleep(5000)
        cont++
        resultState= "Respuesta de la API $cont"
    }

   /*
   fun fetchData() {
        cont++
        //Nos permite crear una corrutina desde un ViewModel
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                delay(5000)
                "Respuesta de la API $cont"
            }
            resultState = result
        }
    }
    */
   fun fetchData() {
       cont++
       //Nos permite crear una corrutina desde un ViewModel
       viewModelScope.launch {
           try {
               isLoading = true
               llamarApi()
           } catch (e: Exception) {
               println("Error ${e.message}")
           } finally {
               isLoading = false
           }
       }
   }
    //Solo funcionan dentro de una corrutina u otra función suspendida
    private suspend fun llamarApi() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            "Respuesta de la API $cont"
        }
        resultState = result
    }
}