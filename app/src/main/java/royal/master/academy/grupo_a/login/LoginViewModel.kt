package royal.master.academy.grupo_a.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel(){

    var name : String = ""

    /* */
    val appVersion : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


}