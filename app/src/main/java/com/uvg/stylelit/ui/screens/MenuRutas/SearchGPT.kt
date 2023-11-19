package com.uvg.stylelit.ui.screens.MenuRutas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uvg.stylelit.R
import com.uvg.stylelit.ui.viewModels.openAIApiViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchGPTPage(navController: NavController){
    val scrollState = rememberScrollState()
    val textState = remember { mutableStateOf("") }
    val viewModel: openAIApiViewModel = viewModel()
    val clothesList by viewModel.clothes.observeAsState(initial = listOf())

    Column( modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally

    )
    {
        Text(text = "Ingresa el prompt:", modifier = Modifier.padding(vertical = 20.dp, horizontal = 30.dp), color = Color.White)
        OutlinedTextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            placeholder = { Text("Buscar", color = Color.Gray) },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Color.White,
                cursorColor = Color.White,
                containerColor = colorResource(id = R.color.SubPrincipal)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        )
        Button(onClick = { viewModel.searchWithChatGPT(textState.value) }) {
            Text("Buscar")
        }
        LazyColumn {
            items(clothesList) { Clothes ->
                Text(Clothes.name)
            }
        }


    }
}