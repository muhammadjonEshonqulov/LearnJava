package uz.mirkomil.learnjava.repository

import android.content.Context
import uz.mirkomil.learnjava.database.MyDao
import uz.mirkomil.learnjava.database.MyDatabase
import uz.mirkomil.learnjava.model.LessonData
import uz.mirkomil.learnjava.model.Test
import uz.mirkomil.learnjava.network.ApiClient
import uz.mirkomil.learnjava.network.ApiInterface

class Repository private constructor(private val apiInterface: ApiInterface, context: Context) {
    var myDao: MyDao

    init {
        MyDatabase.initDatabase(context)
        myDao = MyDatabase.getDatabase()!!.dao()
    }

    companion object {
        fun getRepositoryWithApiClient(
            context: Context,
            invalidateApiClient: Boolean = false
        ): Repository {
            MyDatabase.initDatabase(context)
            if (invalidateApiClient) ApiClient.inalidate()
            return Repository(
                ApiClient.instanse(context).create(
                    ApiInterface::class.java
                ), context
            )
        }
    }

    // test
    fun saveTest(data: List<Test>) = myDao.saveTest(data)
    fun getTest(subjectId: Int, lessonId: Int) = myDao.getTest(subjectId, lessonId)
    fun clearTest() = myDao.clearTest()


    // lesson
    fun saveLessonData(data: List<LessonData>) = myDao.saveLessonData(data)
    fun getLessonData(subjectId: Int, lessonId: Int) = myDao.getLessonData(subjectId, lessonId)
    fun clearLessonData() = myDao.clearLessonData()




}
