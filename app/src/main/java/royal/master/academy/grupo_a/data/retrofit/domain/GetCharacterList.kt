package royal.master.academy.grupo_a.data.retrofit.domain

import retrofit2.Call
import retrofit2.http.GET
import royal.master.academy.grupo_a.data.retrofit.entity.get_character.GetCharacterResponse

interface GetCharacterList {
    //https://rickandmortyapi.com/api/

    @GET("character")
    fun getCharacters() : Call<GetCharacterResponse>

    //agregar funcion para
    // get Character
    // https://rickandmortyapi.com/api/character/2

}