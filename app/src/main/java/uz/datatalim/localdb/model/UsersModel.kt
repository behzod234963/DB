package uz.datatalim.localdb.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class UsersModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int?=null,
    val userName:String,
    val password:String,
    val phonNumber:String)
