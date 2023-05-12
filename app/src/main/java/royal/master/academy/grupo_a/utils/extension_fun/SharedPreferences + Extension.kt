package royal.master.academy.grupo_a.utils.extension_fun

import android.app.Activity
import android.content.Context


fun Activity.setBooleanSharedPreferences(
    sharedPreferenceId : String,
    loginSession : Boolean
){

    val sharedPreferences = getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean(sharedPreferenceId,loginSession)
    editor.apply()

}


fun Activity.getBooleanSharedPreferences(
    sharedPreferenceId : String
):Boolean{

    val sharedPreferences = getSharedPreferences("UserSharedPreferences", Context.MODE_PRIVATE)
    return sharedPreferences.getBoolean(sharedPreferenceId,false)

}