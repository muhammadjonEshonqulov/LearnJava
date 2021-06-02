package uz.mirkomil.learnjava.ui.beginner.presenter

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import uz.mirkomil.learnjava.model.LessonData
import uz.mirkomil.learnjava.repository.Repository
import uz.mirkomil.learnjava.ui.beginner.view.BeginnerView
import uz.mirkomil.learnjava.ui.beginner.view.MaruzaView

class BeginnerPresenter(val view: BeginnerView, val repository: Repository) {

    fun saveLessons(data:List<LessonData>){
        val cm = CompositeDisposable()
        cm.add(repository.saveLessonData(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.d("TTT", "saved beginner "+data.size)

                cm.clear()
            },{
                view.showError(""+it.message)

            }))
    }
}