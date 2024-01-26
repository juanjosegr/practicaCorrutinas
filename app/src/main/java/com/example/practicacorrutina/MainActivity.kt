package com.example.practicacorrutina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.practicacorrutina.corrutinas.ui.Screen
import com.example.practicacorrutina.corrutinas.ui.ScreenVM
import com.example.practicacorrutina.ui.theme.PracticaCorrutinaTheme

class MainActivity : ComponentActivity() {

    private val screenVM: ScreenVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaCorrutinaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen(screenVM)
                }
            }
        }
    }
}

