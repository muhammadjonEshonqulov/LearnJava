package uz.mirkomil.learnjava.ui.lesson.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import uz.mirkomil.learnjava.model.Test
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.lesson.view.LessonView

class LessonPresenter(val view:LessonView, val repository: Repository) {

    fun saveTest(tests: ArrayList<Test>){
        val cm = CompositeDisposable()
        cm.add(repository.saveTest(tests.toList())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                       cm.clear()
            },{
                view.showError(""+it.message)
            }))
    }
}