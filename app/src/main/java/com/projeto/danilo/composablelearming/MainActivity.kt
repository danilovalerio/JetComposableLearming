package com.projeto.danilo.composablelearming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projeto.danilo.composablelearming.ui.theme.ComposableLearmingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableLearmingTheme {
                Surface(modifier =
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                    color = MaterialTheme.colors.primary) {
                    Greeting("Android")
                    ShowAge()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun ShowAge(age: Int = 33) {
    Text(text = age.toString())
}

@Preview
@Composable
fun CreateCirlcle(){
    Card(modifier = Modifier
        .padding(12.dp)
        .size(48.dp),
        shape = CircleShape
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Toque")
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableLearmingTheme {
        Column(modifier = Modifier.fillMaxHeight()) {
            Greeting("Android")
            ShowAge()
        }
    }
}