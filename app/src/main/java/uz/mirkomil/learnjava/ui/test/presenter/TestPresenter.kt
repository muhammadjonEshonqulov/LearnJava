package uz.mirkomil.learnjava.ui.test.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import uz.mirkomil.learnjava.model.Test
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.test.view.TestView

class TestPresenter(val view:TestView, val repository: Repository) {
    fun getTest(subjectId: Int, lessonId: Int){
        val cm = CompositeDisposable()
        cm.add(repository.getTest(subjectId, lessonId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.getTest(it)
                cm.clear()
            },{
                view.showError(""+it.message)
            }))
    }
}