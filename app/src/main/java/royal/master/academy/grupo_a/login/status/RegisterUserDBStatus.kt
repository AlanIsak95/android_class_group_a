package royal.master.academy.grupo_a.login.status

sealed class InsertUserDBStatus{
    object Load : InsertUserDBStatus()
    object HideLoader : InsertUserDBStatus()
    data class Success(val successMessage : String) : InsertUserDBStatus()
    data class Failure(val errorMessage : String) : InsertUserDBStatus()
}