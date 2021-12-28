package com.palchaksergey.testtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.palchaksergey.testtask.data.User
import com.palchaksergey.testtask.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ShowUsersUnder18(users)
                }
            }
        }
    }
}

val users = arrayListOf(
    User("Arnold", 20),
    User("Barbara", 25),
    User("Charles", 30),
    User("Jack", 11),
    User("Juliette", 10)
)

@Composable
fun ShowUsersUnder18(users: ArrayList<User>) {
    val usersUnder18 = users.filter { it.age < 18 }
    val text = "Number of users that under 18 y.o. is ${usersUnder18.size}"
    var currentUser by remember { mutableStateOf(text) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = currentUser,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.primary
        )
    }
    LaunchedEffect(true) {
        delay(2000)
        if (usersUnder18.isNotEmpty()) {
            usersUnder18.forEach {
                currentUser = it.name
                delay(2000)
            }
            currentUser = text
        } else currentUser = "All users are adults"
    }
}
