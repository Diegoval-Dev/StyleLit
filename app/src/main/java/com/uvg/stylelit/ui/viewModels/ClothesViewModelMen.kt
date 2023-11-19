import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.stylelit.data.respository.Repository
import com.uvg.stylelit.ui.uiStates.ClothesUiState
import kotlinx.coroutines.launch

class ClothesViewModelMen(private val repository: Repository = Repository()): ViewModel() {
    var ClothesUiState by mutableStateOf(ClothesUiState(emptyList()))
        private set

    fun getDataM(category: String, cloth: String){
        ClothesUiState = ClothesUiState(emptyList(), loading = true)
        viewModelScope.launch {
            ClothesUiState = ClothesUiState(
                cloth = repository.getClothes("Man",category,cloth).clothes
            )
        }
    }
}