package uz.datatalim.localdb.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.datatalim.localdb.model.UsersModel


@Database(entities = [UsersModel::class], version = 1)
abstract class AppDB :RoomDatabase(){

    abstract fun getUserDao():UsersDaoInterface

    companion object{

        private var DB_INSTANCE:AppDB? = null

        fun appDataBase(ctx:Context):AppDB{

            if (DB_INSTANCE==null){

                DB_INSTANCE=Room.databaseBuilder(ctx.applicationContext,AppDB::class.java,"mydb").build()

            }
            return DB_INSTANCE!!
        }

    }
    
}