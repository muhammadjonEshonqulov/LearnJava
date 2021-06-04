package uz.mirkomil.learnjava.ui.test.view

import uz.mirkomil.learnjava.model.Test

interface TestView {
    fun showError(s: String)
    fun getTest(it: List<Test>?)
}