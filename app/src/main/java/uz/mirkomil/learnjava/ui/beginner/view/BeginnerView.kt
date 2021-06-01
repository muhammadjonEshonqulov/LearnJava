package uz.mirkomil.learnjava.ui.beginner.view

import uz.mirkomil.learnjava.model.LessonData

interface BeginnerView {
    fun showError(message: String)
    fun savedLesson(data: List<LessonData>)

}