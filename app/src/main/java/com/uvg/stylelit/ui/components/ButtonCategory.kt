package com.uvg.stylelit.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.stylelit.ui.theme.DarkBlue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.ui.theme.StyleLitTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonCategory( text: String, color: Color, navController: NavController, cloth: String){
    Card(
        shape = RoundedCornerShape(1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(51.dp),
        onClick = {  navController.navigate("${NavigationState.Cloth.route}/${cloth}")}
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color)
        ){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp),
                contentAlignment = Alignment.CenterStart
            ){
                Text(
                    text = text,
                    color = Color.White,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(600)
                )
                Box(
                    modifier =  Modifier
                        .fillMaxSize()
                        .padding(end = 16.dp),
                    contentAlignment = Alignment.CenterEnd
                ){
                    Text(
                        text = ">",
                        color = Color.White,
                        textAlign = TextAlign.End,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600)
                    )
                }
            }
        }
    }
}

