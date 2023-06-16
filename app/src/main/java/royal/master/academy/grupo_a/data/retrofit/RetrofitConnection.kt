package royal.master.academy.grupo_a.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import royal.master.academy.grupo_a.data.retrofit.domain.GetCharacterList

class RetrofitConnection {

    val retrofit  = Retrofit.Builder().apply {
        baseUrl("https://rickandmortyapi.com/api/")
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    val apiService = retrofit.create(GetCharacterList::class.java)

}