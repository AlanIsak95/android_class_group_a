package royal.master.academy.grupo_a.utils.extension_fun

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import royal.master.academy.grupo_a.data.room.AppDataBase
import royal.master.academy.grupo_a.data.room.entities.UserEntity

/** */
suspend fun Activity.insertUser(userEntity: UserEntity) =
    getDB().userDao.insertUser(userEntity)

/** */
suspend fun Activity.getAllUsers() =
    getDB().userDao.getUsers()

/** */
suspend fun Fragment.insertUser(userEntity: UserEntity) =
    getDB().userDao.insertUser(userEntity)

/** */
suspend fun Fragment.getAllUsers() =
    getDB().userDao.getUsers()

/** */
private fun Fragment.getDB() = AppDataBase.getDatabase(requireContext())

/** */
private fun Activity.getDB() = AppDataBase.getDatabase(this)

fun getDBInstance(context : Context) = AppDataBase.getDatabase(context)


