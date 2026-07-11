package com.jaaDev.mycompose.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import com.jaaDev.mycompose.myfirstapp.ui.theme.ComposeEmptyActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeEmptyActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        sandi = "jaaDev"
                        name = "Android"
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    sandi: String,
    modifier: Modifier = Modifier) {
    
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = nama,
            onValueChange = {
                nama = it
            }
            label = {    
                Text("nama")
            }
            placeholder = {
                Text("masukan nama: ")
            }
        )
        
        spacer(modifier = Modifier.width(16.dp))
        
        outlinedTextField(
            value = sandi,
            onValueChange = {
                sandi = it
            }
            label(
                Text("sandi: ")
            )
            placeholder(
                Text("masukkan password")
            )
            Button(
                onClick = { /* aksi saat diklik */ },
                modifier = Modifier.padding(8.dp),
                enabled = true,
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.White
                ),
                elevation = ButtonDefaults.buttonElevation(4.dp),
                border = null,
                contentPadding = PaddingValues(16.dp)
                ) {
                Text("Klik Saya")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeEmptyActivityTheme {
        Greeting("Android", "jaaDev")
    }
}