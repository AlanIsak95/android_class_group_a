package royal.master.academy.grupo_a.data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id") val userID : Int = 0,
    @ColumnInfo(name = "user_name") val name : String,
    @ColumnInfo(name = "user_email") val email : String,
    @ColumnInfo(name = "user_phone_number") val phoneNumber : String,
    @ColumnInfo(name = "user_password") val password : String,
    @ColumnInfo(name = "user_user_login") val userLogin : String
)