package uz.intalim.ui.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.utils.startFragment
import java.util.*

abstract class BaseFragment(@LayoutRes private  val layout: Int,val canswipe : Boolean = false) : Fragment(layout), View.OnKeyListener {
    private var isUseBackPress = true
    lateinit var oldview: View
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//      //  notifyLanguageChanged()
////        dataBinding = DataBindingUtil.inflate(inflater, layout, container, false)
////        return dataBinding.root
//         return inflater.inflate(layout, container, false)
//    }
    
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        oldview = inflater.inflate(layout, container, false)
//        oldview.setOnTouchListener { _, _ -> false }
//        return FrameLayout(requireContext()).apply {
//            setBackgroundColor(Color.TRANSPARENT)
//            addView(oldview)
////        return inflater.inflate(layout,container,false)
//        }
//    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        view.isFocusableInTouchMode = true
        view.requestFocus()
        view.setOnKeyListener(this)
        onCreate(view)
//        notifyLanguageChanged()
      //  notifyThemeChanged()
    }

    abstract fun onCreate(view: View)

    open fun onBackPressed() {
        isUseBackPress = false
    }

    fun finish() {
//        findNavController().popBackStack()
        activity?.supportFragmentManager?.popBackStack()
    }

    fun hideKeyBoard() {
        val view = activity?.currentFocus ?: View(activity)
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    @SuppressLint("ResourceType")
    fun addFragment(fragment: BaseFragment, bundle : Bundle? = null, isAnimate: Boolean = false) {
       // fragment.senderData = senderData
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        fragment.arguments = bundle
        if (isAnimate)
            transaction?.setCustomAnimations(
                R.anim.slide_left,
                R.anim.wait_anim,
                R.anim.wait_anim,
                R.anim.slide_right
            )

        transaction?.add(R.id.nav_host_fragment, fragment)
            ?.addToBackStack(fragment.hashCode().toString())
            ?.commit()
    }
//    @SuppressLint("ResourceType")
//    fun addFragment(fragment: BottomSheetDialogPhoto, bundle : Bundle? = null, isAnimate: Boolean = false) {
//        // fragment.senderData = senderData
//        val transaction = activity?.supportFragmentManager?.beginTransaction()
//        fragment.arguments = bundle
//        if (isAnimate)
//            transaction?.setCustomAnimations(
//                R.anim.slide_left,
//                R.anim.wait_anim,
//                R.anim.wait_anim,
//                R.anim.slide_right
//            )
//
//        transaction?.add(R.id.nav_host_fragment, fragment)
//            ?.addToBackStack(fragment.hashCode().toString())
//            ?.commit()
//    }
    @SuppressLint("ResourceType")
    fun startFragment(fragment: BaseFragment, bundle : Bundle? = null, isAnimate: Boolean = false) {
        // fragment.senderData = senderData
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        fragment.arguments = bundle
        if (isAnimate)
            transaction?.setCustomAnimations(
                R.anim.slide_left,
                R.anim.wait_anim,
                R.anim.wait_anim,
                R.anim.slide_right
            )
        
        transaction?.replace(R.id.nav_host_fragment, fragment)
            ?.addToBackStack(fragment.hashCode().toString())
            ?.commit()
    }
    fun closeAllFragmentsAndOpenThis(fragment: BaseFragment, isAnimate: Boolean = true) {
        activity?.supportFragmentManager?.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        (activity as AppCompatActivity).startFragment(fragment,  null, isAnimate = isAnimate)
    }
    fun showKeyboard(editText: EditText) {
        editText.requestFocus()
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.showSoftInput(editText, 0)
    }

    override fun onKey(p0: View?, keyCode: Int, e: KeyEvent?): Boolean {
        // back press
        if (keyCode == KeyEvent.KEYCODE_BACK && e?.action == KeyEvent.ACTION_DOWN) {
            isUseBackPress = true
            onBackPressed()
            return isUseBackPress
        }
        return false
    }

    fun toast(@StringRes resID: Int) {
        activity?.applicationContext?.let {
            Toast.makeText(it, resID, Toast.LENGTH_SHORT).show()
        }

    }

    fun toast(message: String) {
        activity?.applicationContext?.let {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        }
    }

//    protected fun notifyThemeChanged() = onCreateTheme(themeManager.currentTheme)
//    protected fun notifyLanguageChanged() = onCreateLanguage(languageManager.currentLanguage)
    
//    open fun onCreateTheme(theme: Theme) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            view?.context?.let {
//                if (theme.id == Theme.CLASSIC_THEME) {
//                    val statusBarColor = ContextCompat.getColor(it, theme.colorPrimaryDark)
//                    val navigationBarColor = ContextCompat.getColor(it, theme.navigationBarColor)
//                    activity?.window?.statusBarColor = statusBarColor
//                    activity?.window?.navigationBarColor = navigationBarColor
//                    activity?.window?.decorView?.let { view ->
//                        view.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//                    }
//                } else {
//                    val statusBarColor = ContextCompat.getColor(it, theme.colorPrimaryDark)
//                    activity?.window?.statusBarColor = statusBarColor
//                    activity?.window?.navigationBarColor = statusBarColor
//                    activity?.window?.decorView?.let { view ->
//                        view.systemUiVisibility = 0
//                    }
//                }
//            }
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            context?.let {
//                if (theme.id == Theme.CLASSIC_THEME) {
//                    val navigationBarColor = ContextCompat.getColor(it, theme.navigationBarColor)
//                    activity?.window?.navigationBarColor = navigationBarColor
//                    activity?.window?.decorView?.let { view ->
//                        view.systemUiVisibility =
//                            View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//                    }
//                } else {
//                    val statusBarColor = ContextCompat.getColor(it, theme.colorPrimaryDark)
//                    activity?.window?.navigationBarColor = statusBarColor
//                    activity?.window?.decorView?.let { view ->
//                        view.systemUiVisibility = 0
//                    }
//                }
//            }
//        }
//    }

//    open fun onCreateLanguage(language: Language) {
//        context?.let {
//            val configuration = Configuration()
//            configuration.setLocale(
//                Locale(languageManager.currentLanguage.userName)
//            )
//            it.resources.updateConfiguration(configuration, it.resources.displayMetrics)
//        }
//    }

    override fun setUserVisibleHint(isVisibleToUser : Boolean){
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser) {
            activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
        }
    }
    
    override fun onResume() {
        super.onResume()
//        if (canswipe&& slidrInterface == null) {
//            slidrInterface = Slidr.replace(oldview, SlidrConfig.Builder().position(SlidrPosition.LEFT).build())
//        }
    }
    fun lockSwipable() {
//        slidrInterface?.lock()
    }
    
    fun unlockSwipable() {
//        slidrInterface?.unlock()
    }
}