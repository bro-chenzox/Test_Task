package com.palchaksergey.testtask

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.palchaksergey.testtask.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ShowAlertDialog()
                }
            }
        }
    }
}

@Composable
fun ShowAlertDialog() {
    val openDialog = remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }

    AlertDialogButton(openDialog)

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Column {
                    TextField(
                        value = text,
                        onValueChange = { text = it }
                    )
                    Text("Custom Text")
                    Checkbox(checked = false, onCheckedChange = {})
                }
            },
            buttons = {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    onClick = {
                        openDialog.value = false
                        Log.d("Log", "openDialog is changed for ${openDialog.value} inside the onClick of Alert Dialog")
                    }
                ) {
                    Text("Dismiss")
                }
            }
        )
    }
}

@Composable
fun AlertDialogButton(openDialog: MutableState<Boolean>) {
    Log.d("Log", "openDialog is ${openDialog.value}")
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = {
            openDialog.value = true
            Log.d("Log", "openDialog is changed for ${openDialog.value} inside the onClick of MainScreen")
        }) {
            Text("Open Alert Dialog")
        }
    }
}

