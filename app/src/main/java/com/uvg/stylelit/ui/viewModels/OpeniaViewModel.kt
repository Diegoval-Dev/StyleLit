
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

interface OpenAIApiService {
    @POST("/v1/engines/text-davinci-002/completions")
    suspend fun postMessage(
        @Body requestBody: OpenAIRequest
    ): Response<OpenAIResponse>
}

data class OpenAIRequest(

    val prompt: String,
    val max_tokens: Int = 150,  // Puedes establecer un valor por defecto
    val temperature: Double = 0.7
    // Añade aquí otros campos opcionales si los necesitas
)

class OpenIaViewModel : ViewModel() {
    private val _response = MutableStateFlow<String>("")
    val response = _response.asStateFlow()
    private val apiKey = "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"

    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $apiKey")
                .build()
            chain.proceed(request)
        }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openai.com")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(OpenAIApiService::class.java)

    suspend fun sendMessageToChatGPT(prompt: String) {
        viewModelScope.launch {
            try {
                val result = apiService.postMessage(OpenAIRequest(prompt))
                if (result.isSuccessful && result.body() != null) {
                    _response.value = result.body()!!.choices.first().text
                } else {
                    // Imprime o registra el error
                    Log.e("API Error", "Código: ${result.code()}, Mensaje: ${result.message()}")
                    _response.value = "Error: No se pudo obtener respuesta"                }
            } catch (e: Exception) {
                _response.value = "Error: ${e.message}"
            }
        }
    }
}

data class OpenAIResponse(
    val choices: List<Choice>
)

data class Choice(
    val text: String
)
