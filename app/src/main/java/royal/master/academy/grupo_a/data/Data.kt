package royal.master.academy.grupo_a.data

//Delete
object Data {

    /* */
    private var userList = mutableListOf<User>()

    /* */
    fun addUser(user : User){
        userList.add(user)
    }

    /* */
    fun getUserList() = userList

    /* */
    fun clearLoginUserList() {
        userList = mutableListOf()
    }

}