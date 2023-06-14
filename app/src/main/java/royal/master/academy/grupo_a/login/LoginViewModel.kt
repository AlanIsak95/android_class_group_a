package royal.master.academy.grupo_a.login

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import royal.master.academy.grupo_a.data.room.entities.UserEntity
import royal.master.academy.grupo_a.login.status.InsertUserDBStatus
import royal.master.academy.grupo_a.utils.extension_fun.getDBInstance
import java.lang.Exception

class LoginViewModel : ViewModel(){

    var name : String = ""

    /* */
    val appVersion : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun insertUserVM(
        context : Context,
        userEntity: UserEntity,
        response : (InsertUserDBStatus) -> Unit
    ){

        response(InsertUserDBStatus.Load)

        viewModelScope.launch {

            try {

                getDBInstance(context).userDao.insertUser(userEntity)
                delay(1500)
                response(InsertUserDBStatus.HideLoader)
                response(InsertUserDBStatus.Success(successMessage = "El usuario se agrego : ${userEntity.userID}"))

            }catch (e : Exception){

                delay(1000)
                response(InsertUserDBStatus.HideLoader)
                response(InsertUserDBStatus.Failure(errorMessage = "Error al insertar el usuario"))


            }


        }

    }

}