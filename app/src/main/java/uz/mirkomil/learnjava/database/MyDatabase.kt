package uz.mirkomil.learnjava.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.mirkomil.learnjava.model.LessonData
import uz.mirkomil.learnjava.model.Test


@Database(entities = [Test::class, LessonData::class], version = 2)

abstract class MyDatabase : RoomDatabase() {
    abstract fun dao(): MyDao

    companion object {

        private var instance: MyDatabase? = null

        fun initDatabase(context: Context) {
            synchronized(this) {
                if (instance == null) {
                    instance = Room
                        .databaseBuilder(
                            context.applicationContext,
                            MyDatabase::class.java, "learnJava"
                        )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
        }

        fun getDatabase() = instance
    }
}