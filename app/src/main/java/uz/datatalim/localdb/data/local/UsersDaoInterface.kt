package uz.datatalim.localdb.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import uz.datatalim.localdb.model.UsersModel


@Dao
interface UsersDaoInterface {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user:UsersModel)


    @Query("SELECT *FROM users" )
    fun get():List<UsersModel>

    @Query("SELECT *FROM users WHERE :id=id")
    fun getUserByID(id:Int):UsersModel


    @Delete
    fun clear(user: UsersModel)

}