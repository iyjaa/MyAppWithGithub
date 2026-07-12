package com.jaaDev.mycompose.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jaaDev.mycompose.myfirstapp.ui.theme.ComposeEmptyActivityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeEmptyActivityTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var sandi by remember { mutableStateOf("") }
    var hasil by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("nama") },
            placeholder = { Text("masukkan nama") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = sandi,
            onValueChange = { sandi = it },
            label = { Text("sandi") },
            placeholder = { Text("masukkan password") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                hasil = "halo, $nama"
            },
            modifier = Modifier.padding(8.dp),
            enabled = true,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            contentPadding = PaddingValues(16.dp)
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = hasil,
            color = Color.Red
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeEmptyActivityTheme {
        Greeting()
    }
}