package uz.mirkomil.learnjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.security.auth.Subject

@Entity
data class LessonData(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val subject: Int?,
    val lessonId: Int?,
    val tittle: String,
    val text: String?,
    val imgUrl: Int?
)
