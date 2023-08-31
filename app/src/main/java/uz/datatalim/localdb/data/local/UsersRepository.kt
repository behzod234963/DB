package uz.datatalim.localdb.data.local

import android.app.Application
import uz.datatalim.localdb.model.UsersModel

class UsersRepository(private val app:Application) {

    private val usersDao=AppDB.appDataBase(app).getUserDao()

    fun getAllUser():List<UsersModel>{

        return usersDao.get()

    }

    fun saveUsers(user:UsersModel){

        usersDao.save(user)

    }

    fun delUser(user:UsersModel){

        usersDao.clear(user)

    }

    fun getUserById(id: Int):UsersModel{

        return usersDao.getUserByID(id)

    }

}