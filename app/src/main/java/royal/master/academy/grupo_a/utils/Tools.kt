package royal.master.academy.grupo_a.utils

import android.content.Context
import android.widget.Toast

object Tools {

    fun showToast(context : Context, message : String) =
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show()

}

