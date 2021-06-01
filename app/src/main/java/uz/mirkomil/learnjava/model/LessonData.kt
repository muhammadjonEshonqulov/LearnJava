package uz.mirkomil.learnjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LessonData(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val lessonId: Int?,
    val tittle: String,
    val text: String?,
    val imgUrl: Int?
)
