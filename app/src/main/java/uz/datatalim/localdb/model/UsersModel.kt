package uz.datatalim.localdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UsersModel(
    @PrimaryKey
    val id:Int,
    val userName:String,
    val password:String,
    val phonNumber:String)
