package uz.mirkomil.learnjava.ui.maruza.presenter

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import uz.mirkomil.learnjava.model.LessonData
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.beginner.view.MaruzaView

class MaruzaPresenter(val view: MaruzaView, val repository: Repository) {

    fun getLessonData(id:Int){
        val cm = CompositeDisposable()
        cm.add(repository.getLessonData(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.savedLesson(it)
                       cm.clear()
            },{
                view.showError(""+it.message)

            }))
    }


}