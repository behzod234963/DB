package uz.datatalim.localdb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.datatalim.localdb.model.UsersModel


@Database(entities = [UsersModel::class], version = 1)
abstract class AppDB :RoomDatabase(){

    abstract fun getUserDao():UsersDao

}