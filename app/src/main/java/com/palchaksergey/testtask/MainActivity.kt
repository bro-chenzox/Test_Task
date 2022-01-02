package com.palchaksergey.testtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.palchaksergey.testtask.components.AboutAlertDialog
import com.palchaksergey.testtask.components.MenuAndAlertDialogScaffold
import com.palchaksergey.testtask.data.MainViewModel
import com.palchaksergey.testtask.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepVisibleCondition {
            viewModel.isLoading.value
        }
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ShowMenuAndAlertDialogScaffold(
                        appName = "Test_Task v1.0",
                        developerName = "Sergey Palchak"
                    )
                }
            }
        }
    }
}

@Composable
fun ShowMenuAndAlertDialogScaffold(appName: String, developerName: String) {
    val isMenuExpanded = remember { mutableStateOf(false) }
    val isDialogOpened = remember { mutableStateOf(false) }

    MenuAndAlertDialogScaffold(
        isMenuExpanded = isMenuExpanded,
        isDialogOpened = isDialogOpened
    )

    if (isDialogOpened.value) {
        AboutAlertDialog(
            isDialogOpened = isDialogOpened,
            appName = appName,
            developerName = developerName
        )
    }
}



