package com.uvg.stylelit.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemInfo
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uvg.stylelit.R
import com.uvg.stylelit.components.CardClothe
import com.uvg.stylelit.components.TituloCategoriaSeparador
import com.uvg.stylelit.components.TituloPrincipal
import com.uvg.stylelit.data.Card
import com.uvg.stylelit.ui.theme.Cyan
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.theme.StyleLitTheme

@Composable
fun MensCategoryScreen(navController: NavController){
    MensCategoryBody()
}

val camisas = mutableListOf<Card>(
    Card(id = R.drawable.c__1_, text = "Camisa 1"),
    Card(id = R.drawable.c__2_, text = "Camisa 2"),
    Card(id = R.drawable.c__3_, text = "Camisa 3"),
    Card(id = R.drawable.c__4_, text = "Camisa 4"),
    Card(id = R.drawable.c__5_, text = "Camisa 5"),
    Card(id = R.drawable.c__6_, text = "Camisa 6")
)
val pantalones = mutableListOf<Card>(
    Card(id = R.drawable.p__1_, text = "Pantalon 1"),
    Card(id = R.drawable.p__2_, text = "Pantalon 2"),
    Card(id = R.drawable.p__3_, text = "Pantalon 3"),
    Card(id = R.drawable.p__4_, text = "Pantalon 4"),
    Card(id = R.drawable.p__5_, text = "Pantalon 5"),
    Card(id = R.drawable.p__6_, text = "Pantalon 6"),
)

@Composable
fun MensCategoryBody(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(PrimaryColorBlue)
            .padding(top = 5.dp, bottom = 10.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Box(){
            TituloPrincipal(text = "MEN'S", color = Cyan)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            //.verticalScroll(state = rememberScrollState())
    ){

        TituloCategoriaSeparador(text = "Camisas")

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(all = 10.dp)
        ){
            items(camisas) { card ->
                CardClothe(id = card.id, text = card.text)
            }
        }

        TituloCategoriaSeparador(text = "Pantalones")

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 160.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(all = 10.dp)
        ){
            items(pantalones) { card ->
                CardClothe(id = card.id, text = card.text)
            }
        }
    }

}





@Preview(showBackground = true)
@Composable
fun BodyPreview() {
    StyleLitTheme {
        MensCategoryBody()
    }
}