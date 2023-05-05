package royal.master.academy.grupo_a.utils

import android.content.Context
import android.widget.Toast
import royal.master.academy.grupo_a.data.Data
import royal.master.academy.grupo_a.data.User
import royal.master.academy.grupo_a.login.status.LoginEnum

object Tools {

    fun createToast(context : Context, message : String) =
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()


    fun createUser(
        name : String,
        email : String,
        phoneNumber : String,
        password : String,
    ):User{

        val userNameSuf = name.substring(0,2).lowercase()
        val phoneSuf = phoneNumber.substring(0,2)

        val userName = "us$userNameSuf$phoneSuf"

        return User(
            user_id = 0,
            name = name,
            email = email,
            phoneNumber = phoneNumber,
            password = password,
            userName = userName
        )

    }


    fun loginWithCredentials(
        userName : String,
        password : String,
        callBack : (LoginEnum,User) -> Unit
    ){

        var loginEnum   = LoginEnum.FAILURE
        var userLogged  = User()

        val userList = Data.getUserList()

        userList.forEach {userItem ->

            if (userItem.userName == userName && userItem.password == password){
                loginEnum = LoginEnum.SUCCESS
                userLogged = userItem
                return@forEach
            }

        }

        callBack(loginEnum,userLogged)

    }

}

