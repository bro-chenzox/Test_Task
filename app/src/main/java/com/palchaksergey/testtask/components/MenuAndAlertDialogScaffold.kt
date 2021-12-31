package com.palchaksergey.testtask.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.PopupProperties

@Composable
fun MenuAndAlertDialogScaffold(
    isMenuExpanded: MutableState<Boolean>,
    isDialogOpened: MutableState<Boolean>,
    content: @Composable () -> Unit = {}
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Test_Task")
                },
                actions = {
                    Column {
                        IconButton(onClick = { isMenuExpanded.value = true }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "Menu Icon"
                            )
                        }

                        DropdownMenu(
                            properties = PopupProperties(),
                            expanded = isMenuExpanded.value,
                            onDismissRequest = { isMenuExpanded.value = false }
                        ) {
                            DropdownMenuItem(onClick = { isDialogOpened.value = true }) {
                                Text("About")
                            }
                        }
                    }
                }
            )
        }
    ) {
        content.invoke()
    }
}

@Preview
@Composable
fun MenuAndAlertDialogScaffoldPreview() {

    val isMenuExpanded = remember { mutableStateOf(false) }
    val isDialogOpened = remember { mutableStateOf(false) }

    MenuAndAlertDialogScaffold(isMenuExpanded = isMenuExpanded, isDialogOpened = isDialogOpened)
}
