package com.palchaksergey.testtask.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun MenuAndAlertDialogScaffold(
    isMenuExpanded: MutableState<Boolean>,
    isDialogOpened: MutableState<Boolean>,
    content: @Composable () -> Unit = {}
) {
    val animatedMenuHeight by animateDpAsState(
        targetValue = if (isMenuExpanded.value) 64.dp else 0.dp,
        animationSpec = tween(
            durationMillis = 500
        )
    )

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
                            offset = DpOffset(0.dp, 4.dp),
                            expanded = isMenuExpanded.value,
                            onDismissRequest = { isMenuExpanded.value = false },
                            modifier = Modifier
                                .height(animatedMenuHeight)
                            ) {
                            DropdownMenuItem(
                                onClick = { isDialogOpened.value = true }
                            ) {
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
