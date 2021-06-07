package uz.mirkomil.learnjava.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Test(
    @PrimaryKey
    val id: Int,
    val subject: Int,
    val lesson: Int,
    val question: String,
    val answearA: String,
    val answearB: String,
    val answearC: String,
    val correct: String,
    var isCheckd: Int = 0
)
