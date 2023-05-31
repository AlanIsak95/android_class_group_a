package royal.master.academy.grupo_a.utils.extension_fun

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Activity.showToast( message : String) =
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()

fun Fragment.showToast(message : String) =
    Toast.makeText(requireActivity(),message, Toast.LENGTH_SHORT).show()

fun Context.showToast(message : String) =
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()