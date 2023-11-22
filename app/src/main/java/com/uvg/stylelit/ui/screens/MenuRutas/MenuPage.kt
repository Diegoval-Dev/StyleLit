package com.uvg.stylelit.ui.screens.MenuRutas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uvg.stylelit.R


@Composable
fun MenuPage(navController: NavController) {
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        CarouselView()

        Text(
            text = "Categorías",
            color = Color.White,
            modifier = Modifier.padding( 10.dp)
        )
        Row (modifier = Modifier.horizontalScroll(scrollState)){
            btnCategories()
        }
        Column(modifier = Modifier
            .background(Color(R.color.SubPrincipal))
            .fillMaxSize()
        ) {
            CardWidget(R.color.BlueMan,R.drawable.manblack)
            CardWidget(R.color.pinkWoman,R.drawable.womanwhite)
            Box (Modifier.padding(top = 10.dp)){

            }
        }
    }

}


@Composable
fun CarouselView(){
    val scrollState = rememberScrollState()

    BoxWithConstraints {
        val screenWidth = maxWidth
        val screenHeight = maxHeight

        Row(modifier = Modifier.horizontalScroll(scrollState)) {
            ImageCard(painter = painterResource(R.drawable.img4), screenWidth)
            ImageCard(painter = painterResource(R.drawable.img3), screenWidth)
            ImageCard(painter = painterResource(R.drawable.img5), screenWidth)
        }
    }
}

@Composable
fun ImageCard(painter: Painter, width: Dp, ) {
    Image(
        painter = painter,
        contentDescription = null,
        modifier = Modifier
            .width(width)
            .height(200.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun btnCategories(){
    Card (
        modifier = Modifier.padding(8.dp), // Ajusta este valor como necesites
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.SubPrincipal)
        )
    ){
        Text(
            text = "Camisas",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
    Card (
        modifier = Modifier.padding(8.dp), // Ajusta este valor como necesites
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.SubPrincipal)
        )
    ){
        Text(
            text = "Pantalones",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
    Card (
        modifier = Modifier.padding(8.dp), // Ajusta este valor como necesites
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.SubPrincipal)
        )
    ){
        Text(
            text = "Chaquetas",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }
    Card (
        modifier = Modifier.padding(8.dp), // Ajusta este valor como necesites
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.SubPrincipal)
        )
    ){
        Text(
            text = "Vestidos",
            color = Color.White,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        )
    }

}


@Composable
fun CardWidget( backgroundColorRes: Int, // Recurso de color para el fondo
                imageRes: Int // Recurso de imagen para la imagen
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(backgroundColorRes)
        )
    ) {
        Row(
            modifier = Modifier
                .background(colorResource(backgroundColorRes)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Conjuntos Populares de hombre",
                color = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 25.dp),
                fontSize = 18.sp,
                fontWeight = FontWeight.W500,
                textAlign = TextAlign.Left
            )
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "",
                modifier = Modifier
                    .size(130.dp)
            )
        }
    }
}

