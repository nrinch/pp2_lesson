package na.severinchik.composelesson7

import android.view.View
import android.widget.TimePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import na.severinchik.composelesson7.ui.theme.Lesson_pp2Theme


@ExperimentalMaterialApi
@Composable
fun MainScreen(viewModel: MainScreenViewModel = MainScreenViewModel()) {

    val state by viewModel.state.collectAsState(initial = MainScreenState.DEFAULT)

    LaunchedEffect(key1 = true) {
        viewModel.fetchItems()

        snapshotFlow { state }.collect {
            it.items.forEach {
                print("-->> it")
            }
        }
    }

    val (selected, onClickByItem) = remember {
        mutableStateOf(-1)
    }


    MainScreenView(
        state = state,
        selected = selected,
        onClickByItem = { item ->
            if (item == selected) {
                onClickByItem(-1)
            } else {
                onClickByItem(item)
            }
        })

    DisposableEffect(key1 = true, effect = {
        onDispose {

        }
    })
}


@ExperimentalMaterialApi
@Composable
fun MainScreenView(state: MainScreenState, selected: Int, onClickByItem: (Int) -> Unit) {

    val (text, onTextChange) = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            shape = RoundedCornerShape(topStart = 32.dp, bottomStart = 32.dp),
            trailingIcon = {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Save me")
                }
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null
                )
            },
            value = text,
            onValueChange = { onTextChange(it) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = stringResource(id = R.string.app_name)) },
            placeholder = { Text(text = "Placeholder") },
            colors = TextFieldDefaults.outlinedTextFieldColors()
        )
        Button(onClick = { onTextChange("") }) {
            Text(text = "Save me")
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            state.items.forEachIndexed { index, item ->
                item {
                    ItemOfList(
                        value = item,
                        isExpanded = (index == selected),
                        onClick = {
                            onClickByItem(index)
                        }
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ItemOfList(value: Int, isExpanded: Boolean, onClick: () -> Unit) {

//    var isExpanded by remember { mutableStateOf(false) }

    Card(
        shape = MaterialTheme.shapes.medium,
        onClick = {
            onClick()
        }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(modifier = Modifier.padding(4.dp)) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = "")
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Item $value")
                }
                Icon(
                    imageVector = Icons.Default.Call,
                    tint = Color.Green,
                    contentDescription = ""
                )
            }
            if (isExpanded) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "")
                    Icon(imageVector = Icons.Default.Send, contentDescription = "")
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "")
                }
            }
        }
    }
}

class MainScreenViewModel : ViewModel() {

    private var mState: MainScreenState = MainScreenState.DEFAULT

    private val _state: MutableSharedFlow<MainScreenState> = MutableSharedFlow()
    val state: SharedFlow<MainScreenState> = _state

    fun fetchItems() {
        viewModelScope.launch {
            mState = mState.copy(items = generateList())
            _state.emit(mState)
        }
    }

    private fun generateList(): List<Int> {
        val list: MutableList<Int> = mutableListOf()
        for (i in 0..42) {
            list.add(i)
        }
        return list.toList()
    }

}

data class MainScreenState(
    val items: List<Int>
) {
    companion object {
        val DEFAULT = MainScreenState(items = listOf())
    }
}


@ExperimentalMaterialApi
@Preview
@Composable
fun MainScreen_Preview() {
    Lesson_pp2Theme() {
        MainScreen()
    }
}


@Composable
fun AndroidViewSample() {

    AndroidView(factory = { context ->
        TimePicker(context)
    }, update = { timePicker ->
        timePicker.hour
    })

}

private val mCorkyListener: View.OnClickListener = object : View.OnClickListener {
    override fun onClick(v: View) {
        TODO("Not yet implemented")
    }
}


val listener = View.OnClickListener { TODO("Not yet implemented") }