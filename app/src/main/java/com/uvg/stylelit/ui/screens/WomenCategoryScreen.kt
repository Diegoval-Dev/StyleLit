package com.uvg.stylelit.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.uvg.stylelit.components.TituloPrincipal
import com.uvg.stylelit.ui.theme.PrimaryColorBlue
import com.uvg.stylelit.ui.theme.StyleLitTheme
import com.uvg.stylelit.ui.viewModels.WomenCategoryViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.stylelit.ui.components.ButtonCategory
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import com.uvg.stylelit.navigation.NavigationState
import com.uvg.stylelit.ui.theme.PinkW
import com.uvg.stylelit.ui.theme.pinkcom

@Composable
fun WomenCategoryScreen(navController: NavController){
    WomenCategoryScreenBody(navController = navController)
}

@Composable
fun WomenCategoryScreenBody(viewModel: WomenCategoryViewModel = viewModel(),navController: NavController) {
    if(viewModel.WomansCategoryUiState.categories.isEmpty()){
        viewModel.getCategories()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = PrimaryColorBlue)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(PrimaryColorBlue)
                .padding(top = 5.dp, bottom = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            TituloPrincipal(text = "WOMAN'S", color = PinkW)
        }
        if (viewModel.WomansCategoryUiState.loading){
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }else{
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.WomansCategoryUiState.categories) { category ->
                    ButtonCategory(
                        text = category.name,
                        color = pinkcom,
                        navController = navController,
                        onClick = {
                            navController.navigate("${NavigationState.Cloth.route}/${category.name}")
                        },
                        cloth = category.id
                    )
                    Divider(color = PrimaryColorBlue, thickness = 10.dp)
                }
            }
        }
    }
}
