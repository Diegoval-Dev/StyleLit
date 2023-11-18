import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.uvg.stylelit.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.stylelit.ui.theme.DarkBlue
import com.uvg.stylelit.ui.theme.pinkcom2
import com.uvg.stylelit.ui.uiStates.ClothesUiState

class ClothesViewModelMen : ViewModel() {

    var ClothesUiState by mutableStateOf(ClothesUiState(emptyList()))
        private set
    val imageCardsM = listOf(R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5)
    val carritoIcon = R.drawable.icon_carritos

    data class HeaderInfo(
        val title: String,
        val backgroundColor: Color,
        val textColor: Color,
        val fontSize: TextUnit,
        val fontWeight: FontWeight
    )
    fun getHeaderInfo(): HeaderInfo {
        return HeaderInfo(
            title = "Playera Larga",
            backgroundColor = DarkBlue,
            textColor = Color.White,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    }

    fun getProductDescriptions(): List<List<String>> {
        return listOf(
            listOf(
                "- Marca: Shein",
                "- Talla: XS, S, L, M, XL",
                "- Precio: Q100",
                "- Colores: Rojo, azul, negro, morado, rosado"
            ),
            listOf(
                "- Marca: Pull&Bea",
                "- Talla: S, L, M, XL, XM ",
                "- Precio: Q220",
                "- Colores: Negro, morado, verde, dorado "
            ),
            listOf(
                "- Marca: Zara",
                "- Talla: XL, XS, S, L ",
                "- Precio: Q230",
                "- Colores: Lila, amarillo, blanco, azul, negro "
            ),
            listOf(
                "- Marca: Bershka ",
                "- Talla: S, L, M",
                "- Precio: Q210 ",
                "- Colores: Rojo, azul, negro "
            ),
            listOf(
                "- Marca: Shein ",
                "- Talla: XM, S, L, M, X ",
                "- Precio: Q150 ",
                "- Colores: Rojo, azul, negro "
            )
        )
    }
}