package na.severinchik.composelesson7

import android.content.Context
import android.graphics.Canvas
import android.os.Bundle
import android.view.View
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import na.severinchik.composelesson7.ui.theme.Lesson_pp2Theme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lesson_pp2Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!") //= TextView()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Lesson_pp2Theme {
        TopBar()
    }
}

@Composable
fun TopBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .size(width = 196.dp, height = 142.dp)
                .background(MaterialTheme.colors.secondary)
        ) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(0.5f)) {
                Text(text = "Click me")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .align(Alignment.BottomCenter)
            ) {
                Text(text = "Click me 2")
            }

        }
        Spacer(modifier = Modifier.height(24.dp))
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "This is a Search button",
            modifier = Modifier.clickable { })

        Row(modifier = Modifier.background(Color.Black)) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .padding(12.dp)
                    .background(Color.Green)
            ) {

            }
        }
    }

}

fun onClick() {

}