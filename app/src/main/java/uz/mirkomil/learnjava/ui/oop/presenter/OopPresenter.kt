package uz.mirkomil.learnjava.ui.oop.presenter

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import uz.mirkomil.learnjava.model.LessonData
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.oop.view.OopView

class OopPresenter(val view:OopView, val repository: Repository) {


    fun saveLessons(data:List<LessonData>){
        val cm = CompositeDisposable()
        cm.add(repository.saveLessonData(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                cm.clear()
                Log.d("TTT", "saved oop "+data.size)
            },{
                view.showError(""+it.message)

            }))
    }
}