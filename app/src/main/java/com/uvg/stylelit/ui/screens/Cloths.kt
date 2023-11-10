package com.uvg.stylelit.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uvg.stylelit.R
import com.uvg.stylelit.components.TituloPrincipal
import com.uvg.stylelit.ui.theme.Gold
import com.uvg.stylelit.ui.theme.PinkW
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.theme.White
import com.uvg.stylelit.ui.theme.pinkcom
import com.uvg.stylelit.ui.theme.pinkcom2


/**
 @Composable
 fun Cloth(navController: NavController){
    Cloth(navController = navController)
 }
 */

//viewModel: ClothesViewModel = viewModel(),
@Composable
fun Cloths(navController: NavController) {
    //viewModel.getCategories()
    val imagecard = R.drawable.b11
    val imagecard2 = R.drawable.b12
    val imagecard3 = R.drawable.b13
    val imagecard4 = R.drawable.b14

    val scrollState = rememberScrollState()

    // Contenido principal antes del encabezado
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(PrimaryColorBlue)
    ) {
        // Encabezado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PrimaryColorBlue)
                .padding(top = 5.dp, bottom = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            TituloPrincipal(text = "WOMAN'S", color = PinkW)
        }

        // Contenido principal después del encabezado
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(11.dp)
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Blusas Larga",
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Divider(
                        color = Gold,
                        thickness = 5.dp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 52.dp)
                    )
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                        //.height(400.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    //Imagen 1
                    Image(
                        painter = painterResource(imagecard),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp) // Ajusta el tamaño de la imagen según tus necesidades
                            .background(MaterialTheme.colorScheme.background)
                            .border(10.dp, color = pinkcom2)
                            .border(13.dp, color = Color.White)
                    )

                    //Imagen 2
                    Image(
                        painter = painterResource(imagecard2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp) // Ajusta el tamaño de la imagen según tus necesidades
                            .background(MaterialTheme.colorScheme.background)
                            .border(10.dp, color = pinkcom2)
                            .border(13.dp, color = Color.White)
                    )

                    //Imagen 3
                    Image(
                        painter = painterResource(imagecard3),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp) // Ajusta el tamaño de la imagen según tus necesidades
                            .background(MaterialTheme.colorScheme.background)
                            .border(10.dp, color = pinkcom2)
                            .border(13.dp, color = Color.White)
                    )

                    //Imagen 4
                    Image(
                        painter = painterResource(imagecard4),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp) // Ajusta el tamaño de la imagen según tus necesidades
                            .background(MaterialTheme.colorScheme.background)
                            .border(10.dp, color = pinkcom2)
                            .border(13.dp, color = Color.White)
                    )
                }
            }
        }
    }
}