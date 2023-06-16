package royal.master.academy.grupo_a.data.retrofit.entity.get_character

import royal.master.academy.grupo_a.recycler.data.Address
import royal.master.academy.grupo_a.recycler.data.UserItem

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
){

    fun toUserItem():UserItem{

        val address = Address(
            number = 100,
            streetName = this.location.name,
            zipCode = this.origin.name
        )

        return UserItem(
            name = this.name,
            age = 20,
            imageURLValue = this.image,
            address = address
        )

    }

}