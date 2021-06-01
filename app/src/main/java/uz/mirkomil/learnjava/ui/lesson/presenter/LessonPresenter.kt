package uz.mirkomil.learnjava.ui.lesson.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.lesson.view.LessonView

class LessonPresenter(val view:LessonView, val repository: Repository) {

//    fun getLesson(id:Int){
//        val cm = CompositeDisposable()
//        cm.add(repository.getLessonData(id)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                       view.getLessons(it)
//                       cm.clear()
//            },{
//                view.showError(""+it.message)
//            }))
//    }
}