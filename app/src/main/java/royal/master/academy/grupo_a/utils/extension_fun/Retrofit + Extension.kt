package royal.master.academy.grupo_a.utils.extension_fun

import royal.master.academy.grupo_a.data.retrofit.entity.get_character.Result
import royal.master.academy.grupo_a.recycler.data.UserItem

fun List<Result>.toUserItemList():List<UserItem>{

    val userItemList = mutableListOf<UserItem>()

    this.forEach {
       userItemList.add(it.toUserItem())
    }

    return userItemList

}