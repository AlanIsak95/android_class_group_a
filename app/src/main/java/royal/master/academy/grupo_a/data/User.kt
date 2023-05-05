package royal.master.academy.grupo_a.data

data class User(
    val user_id : Int = 0,
    val name : String,
    val email : String = "invitado@royal.com",
    val phoneNumber : String = "11111111",
    val password : String,
    val userName : String
){

    /* */
    fun validateCredentials() : UserLoginStatus =
        if (userName == "aalta1" && password == "123456789A")
            UserLoginStatus.SUCCESS
        else
            UserLoginStatus.FAILURE

}

enum class UserLoginStatus{
    SUCCESS,
    FAILURE
}
