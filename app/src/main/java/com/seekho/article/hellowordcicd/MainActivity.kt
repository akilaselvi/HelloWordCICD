package com.seekho.article.hellowordcicd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.seekho.article.hellowordcicd.ui.theme.HelloWordCICDTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWordCICDTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, viewModel: CountViewModel = viewModel()) {
    val count by viewModel.count
    Column {
        Text(
            text = "Count: $count",
            modifier = modifier
        )

        Button(onClick = {
            viewModel.increment()
        }) {
            Text(text = "Submit")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloWordCICDTheme {
        Greeting("Android")
    }
}

class CountViewModel : ViewModel(){
    private val _count = mutableStateOf<Int>(0)
    val count = _count

    fun increment(){
        _count.value++
    }
}