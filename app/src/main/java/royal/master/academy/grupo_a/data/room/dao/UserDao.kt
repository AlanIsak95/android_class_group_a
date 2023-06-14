package royal.master.academy.grupo_a.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import royal.master.academy.grupo_a.data.room.entities.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(user: UserEntity)

    @Query("Select * from user")
    suspend fun getUsers() : List<UserEntity>

}