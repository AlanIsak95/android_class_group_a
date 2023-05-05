package royal.master.academy.grupo_a.data

object Data {

    /* */
    private var userList = mutableListOf<User>()

    /* */
    fun addUser(user : User){
        userList.add(user)
    }

    /* */
    fun getUserList() = userList

}