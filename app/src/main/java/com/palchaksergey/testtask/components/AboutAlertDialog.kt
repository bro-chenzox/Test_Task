package com.palchaksergey.testtask.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun AboutAlertDialog(
    isDialogOpened: MutableState<Boolean>,
    appName: String,
    developerName: String
) {
    AlertDialog(
        onDismissRequest = { isDialogOpened.value = false },
        text = {
            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    appName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text("  Created by $developerName")
            }
        },
        buttons = {}
    )
}

// Deploy this preview in isolation to the emulator or running device
@Preview
@Composable
fun AboutAlertDialogPreview() {
    val isDialogOpened = remember { mutableStateOf(true)}
    AboutAlertDialog(
        isDialogOpened = isDialogOpened,
        appName = "Twitter",
        developerName = "Jack Dorsey, Noah Glass, Biz Stone, and Evan Williams.")
}
