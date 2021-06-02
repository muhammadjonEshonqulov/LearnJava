package uz.mirkomil.learnjava.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import uz.mirkomil.learnjava.model.LessonData
import uz.mirkomil.learnjava.model.Test


@Dao
interface MyDao {

    // test
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTest(questions: Test): Completable

    @Query("select * from Test")
    fun getTest(): Observable<Test>

    @Query("delete from Test")
    fun clearTest(): Completable

    // lesson
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveLessonData(questions: List<LessonData>): Completable

    @Query("select * from LessonData where lessonId = :lessonId and subject = :subjectId")
    fun getLessonData(subjectId: Int, lessonId: Int): Observable<List<LessonData>>

    @Query("delete from LessonData")
    fun clearLessonData(): Completable


}
