package cst.unitbvfmi2026.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cst.unitbvfmi2026.data.dao.UserDao
import cst.unitbvfmi2026.data.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase()
{
    abstract fun userDao(): UserDao
    //in Kotlin NU exista static, dar exista companion object
    companion object{
        @Volatile
        private var instance: AppDataBase? = null
        fun getDatabase(context: Context): AppDataBase{
            return instance ?: synchronized(this){ //synchronized = exitare dubla instantiere
                val newInstance = Room.databaseBuilder(
                    context.applicationContext,//contextul
                    AppDataBase::class.java,//clasa
                    "app_database"//numele fisierului din memoria device-ului
                ).build()
                instance = newInstance
                newInstance//returneaza newInstance
            }
        }
    }
}