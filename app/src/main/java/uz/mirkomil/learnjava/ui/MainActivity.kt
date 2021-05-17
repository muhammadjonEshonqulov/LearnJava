package uz.mirkomil.learnjava.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.ui.start.view.StartFragment
import uz.mirkomil.learnjava.utils.startFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startFragment(StartFragment())
    }
}