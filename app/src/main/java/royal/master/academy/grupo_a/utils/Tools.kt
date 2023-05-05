package royal.master.academy.grupo_a.utils

import android.content.Context
import android.widget.Toast
import royal.master.academy.grupo_a.data.User

object Tools {

    fun createToast(context : Context, message : String) =
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()


    fun createUser(
        name : String,
        email : String,
        phoneNumber : String,
        password : String,
    ):User{

        val userName = "01$phoneNumber"

        return User(
            user_id = 0,
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            password = password,
            userName = userName
        )

    }

}

