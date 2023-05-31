package royal.master.academy.grupo_a.recycler.data

data class UserItem(
    val name : String = "Sin nombre",
    val age : Int = 0,
    val imageURLValue : String = "Empty",
    val address : Address = Address()
)

data class Address(
    val number : Int = 0,
    val streetName : String = "Sin Nombre",
    val zipCode : String = "Sin Codigo Postal"
)