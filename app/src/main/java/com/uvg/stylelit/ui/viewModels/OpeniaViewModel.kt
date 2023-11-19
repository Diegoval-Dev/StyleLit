package com.uvg.stylelit.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.stylelit.data.networking.Clothes
import kotlinx.coroutines.launch
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

val apiKey = "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"

class openAIApiViewModel  (private val openAIApiService: OpenAIApiService): ViewModel() {

    private val _clothes = MutableLiveData<List<Clothes>>()
    val clothes: LiveData<List<Clothes>> = _clothes

    fun searchWithChatGPT(query: String) {
        viewModelScope.launch {
            try {
                // Aquí construyes el cuerpo de la solicitud (RequestBody)
                val requestBody = RequestBody.create(
                    "application/json".toMediaTypeOrNull(),
                    "{\"prompt\": \"${query}\", \"max_tokens\": 50}"
                )
                // Realiza la solicitud a OpenAI y obtiene la respuesta
                val response = openAIApiService.getResponse(requestBody)

                // Procesa la respuesta para convertirla en una lista de Clothes
                _clothes.postValue(processResponse(response.string()))
            } catch (e: Exception) {
                // Manejo de errores
            }
        }
    }


    private fun processResponse(response: String): List<Clothes> {
        val clothesList = mutableListOf<Clothes>()
        // Lógica para parsear la respuesta y llenar clothesList
        return clothesList
    }
}

// Ejemplo con Retrofit
interface OpenAIApiService {
    @POST("https://api.openai.com/v1/engines/davinci/completions")
    suspend fun getResponse(@Body requestBody: RequestBody): ResponseBody
}


// Interceptor para añadir el encabezado de autorización
class AuthInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer $apiKey")
            .build()
        return chain.proceed(newRequest)
    }
}

// Configuración de Retrofit con el Interceptor
fun provideRetrofit(apiKey: String): Retrofit {
    val authInterceptor = AuthInterceptor(apiKey)

    val client = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .build()

    return Retrofit.Builder()
        .baseUrl("https://api.openai.com/v1/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}
