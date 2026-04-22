package cst.unitbvfmi2026.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import cst.unitbvfmi2026.data.AppDataBase
import cst.unitbvfmi2026.data.entities.UserEntity
import kotlinx.coroutines.launch

class UsersViewModel(
    application: Application
) : AndroidViewModel(application) //ofera context la instantierea bazei de date
{
    private val userDao = AppDataBase.getDatabase(application).userDao()
    fun insert(email: String, name: String)
    {
        viewModelScope.launch{
            userDao.insert(UserEntity(name = name, email = email))
        }
    }
}