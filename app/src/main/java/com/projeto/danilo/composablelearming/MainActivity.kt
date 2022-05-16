package com.projeto.danilo.composablelearming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projeto.danilo.composablelearming.ui.theme.ComposableLearmingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableLearmingTheme {
                MyApp()
            }
        }
    }
}

@Preview
@Composable
fun MyApp(){
    var moneyAccount = remember {
        mutableStateOf(0)
    }

    Surface(modifier =
    Modifier
        .fillMaxHeight()
        .fillMaxWidth(),
        color = MaterialTheme.colors.primary) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "${moneyAccount.value}", style = TextStyle(
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.ExtraBold
            ))
            Spacer(modifier = Modifier.height(120.dp))
            CreateCirlcle(moneyAccount.value) {
                /**
                 * Aqui no calback passaremos a função lambda para somar 1 no contador
                 */
                moneyAccount.value += 1
            }
            if (moneyAccount.value > 15) {
                Text(text = "Meta atingida!")
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

@Composable
fun CreateCirlcle(moneyAccount: Int = 0, updateMoneyCounter: (Int) -> Unit) {
    //TODO Ao clicar no botao deve atualizar o campo de valor fora desse componente também

//    var moneyAccount by remember {
//        mutableStateOf(0)
//    }
    Card(modifier = Modifier
        .padding(12.dp)
        .size(105.dp)
        .clickable {
//            moneyAccount.value++
            Utils.logMessage("Cique no Creative Circle: ${moneyAccount}")
            updateMoneyCounter(moneyAccount)
        },
        shape = CircleShape,
        elevation = 10.dp
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "+1",)
        }

    }

}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposableLearmingTheme {
        Column(modifier = Modifier.fillMaxHeight()) {
            Greeting("Android")
            ShowAge()
        }
    }
}