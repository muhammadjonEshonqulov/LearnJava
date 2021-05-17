@file:Suppress(
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)

package uz.mirkomil.learnjava.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import uz.intalim.ui.base.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import uz.mirkomil.learnjava.R
import java.io.File
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*


//fun BaseFragment.replaceAllFragments(fragment: BaseFragment) {
//    activity!!.supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
//    (activity!! as AppCompatActivity).startFragment(fragment)
//}

fun ProgressBar.setIndeterminateTintCompat(@ColorInt color: Int) {
//    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//        val wrapDrawable = DrawableCompat.wrap(indeterminateDrawable)
//        DrawableCompat.setTint(wrapDrawable, color)
//        indeterminateDrawable = DrawableCompat.unwrap(wrapDrawable)
//    } else {
        progressTintList = ColorStateList.valueOf(color)
//    }
}

fun String.toDate(): Date{
    return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(this)
}

fun URL.getFileSize(): Int? {
    return try {
        openConnection().contentLength
    } catch (x: Exception) {
        null
    }
}

@SuppressLint("NewApi", "ObsoleteSdkInt")
fun String.decode(): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
        android.util.Base64.decode(this, android.util.Base64.DEFAULT).toString(charset("UTF-8"))
    } else {
        TODO("VERSION.SDK_INT < FROYO")
    }
}
fun getRootDirPath_(context: Context): String? {
    return if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) {
        val file = ContextCompat.getExternalFilesDirs(context.applicationContext, null)[0]
        file.absolutePath
    } else {
        context.applicationContext.filesDir.absolutePath
    }
}
fun TextView.ellipsizeText() {
    isSingleLine = true
    maxLines = 1
    ellipsize = TextUtils.TruncateAt.END
}

fun String.getTime() = this.split(" ")[1].substring(0, 5)

fun Int.getDuration(): String {
    val a = this / 3600
    val b = this / 60
    val h = if (a <= 9) "0$a" else (a).toString()
    val m = if (b <= 9) "0${b}" else (b).toString()
    return "$h:$m"
}

@SuppressLint("SimpleDateFormat")
fun Int.getDate(): String {
    val c: Calendar = GregorianCalendar()
    c.time = Date()
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    c.add(Calendar.MONTH, -this)
    return sdf.format(c.time)
}


fun EditText.showKeyboard() {
    post {
        requestFocus()
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
    }
}

fun BottomNavigationView.disableTooltip() {

    if (this == null) {
        return
    }

    val count: Int = this.childCount;
    if (count <= 0) {
        return
    }

    val menuView: ViewGroup = this.getChildAt(0) as ViewGroup
    if (menuView == null) {
        return;
    }

    val menuItemViewSize: Int = menuView.childCount
    if (menuItemViewSize <= 0) {
        return
    }

    for (i in 0 until menuItemViewSize) {
        menuView.getChildAt(
            i
        ).setOnLongClickListener { true }
    }
}

fun hasNetworkAvailable(context: Context): Boolean {
    val service = Context.CONNECTIVITY_SERVICE
    val manager = context.getSystemService(service) as ConnectivityManager?
    val network = manager?.activeNetworkInfo
    Log.d("HHHH", "hasNetworkAvailable: ${(network != null)}")
    return (network != null)
}

fun getRootDirPath(context: Context): String? {
    return if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
        val file: File = ContextCompat.getExternalFilesDirs(context.applicationContext, null)[0]
        file.getAbsolutePath()
    } else {
        context.applicationContext.filesDir.absolutePath
    }
}
fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}
fun AppCompatActivity.startFragment(
    fragment: BaseFragment,
    bundle: Bundle? = null,
    isAnimate: Boolean = false
) {
  //  val resId = ViewModelProviders.of(this)[BaseFragmentViewModel::class.java].resId
   // fragment.senderData = senderData
    val transition = supportFragmentManager.beginTransaction()
    if (isAnimate)
        transition.setCustomAnimations(
            R.anim.slide_top,
            R.anim.wait_anim,
            R.anim.wait_anim,
            R.anim.slide_bottom
        )
    fragment.arguments = bundle
    transition.replace(R.id.nav_host_fragment, fragment ).commit()
}
fun Activity.hideKeyboard() {
    if (currentFocus == null) View(this) else currentFocus?.let { hideKeyboard(it) }
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

//fun Fragment.showKeyboard(edt : EditText)
//{
//    KeyboardUtils.showSoftKeyboard(requireActivity(), edt)
//}
//
//fun Activity.showKeyboard(edt : EditText)
//{
//    KeyboardUtils.showSoftKeyboard(this, edt)
//}


fun View?.blockClickable(
    blockTimeMilles: Long = 500
) {
    this?.isClickable = false
    Handler().postDelayed({ this?.isClickable = true }, blockTimeMilles)
}
