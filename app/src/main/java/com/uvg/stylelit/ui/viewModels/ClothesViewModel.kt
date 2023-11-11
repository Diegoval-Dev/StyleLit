import androidx.lifecycle.ViewModel
import com.uvg.stylelit.R


class ClothesViewModel : ViewModel() {
    val imageCards = listOf(R.drawable.b11, R.drawable.b12, R.drawable.b13, R.drawable.b14, R.drawable.b15)
    val carritoIcon = R.drawable.icon_carritos

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

//class ClothesViewModel(private val repository: Repository = Repository()): ViewModel() { }
