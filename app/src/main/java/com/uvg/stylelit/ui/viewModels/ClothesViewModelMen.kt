import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.uvg.stylelit.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.data.respository.Repository
import com.uvg.stylelit.ui.theme.DarkBlue
import com.uvg.stylelit.ui.theme.pinkcom2
import com.uvg.stylelit.ui.uiStates.ClothesUiState
import kotlinx.coroutines.launch

class ClothesViewModelMen(private val repository: Repository = Repository()): ViewModel() {
    var ClothesUiState by mutableStateOf(ClothesUiState(emptyList()))
        private set

    fun getDataM(category: String, cloth: String){
        ClothesUiState = ClothesUiState(emptyList(),loading = true)
        viewModelScope.launch {
            ClothesUiState = ClothesUiState(
                cloth = repository.getClothes("Man",category,cloth).clothes
            )
        }
    }
}