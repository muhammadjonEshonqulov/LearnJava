package uz.mirkomil.learnjava.base

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import uz.mirkomil.learnjava.R
import uz.mirkomil.learnjava.databinding.DialogLogutBinding

class LogoutDialog:AlertDialog  {
    private var text: TextView? = null

    
    var submit_listener_onclick : (() -> Unit)?=null
    var cancel_listener_onclick : (() -> Unit)?=null
    lateinit var binding:DialogLogutBinding
    
    fun setOnSubmitClick(l:(() -> Unit)?){
        submit_listener_onclick = l
    }
    
    
    fun setOnCancelClick(l:(() -> Unit)?){
        cancel_listener_onclick = l
    }
    
    constructor(context:Context,title:String,message:String,ok_text:String ) : super(context){
        this.setCancelable(true)
        val view = LayoutInflater.from(context).inflate(
            R.layout.dialog_logut, null, false)
        binding = DialogLogutBinding.bind(view)
        view?.apply {
            binding.logoutTittle.text = title
            
            binding.logoutMessage.text = message
//            binding.cancelLogout.text = cancel_text
            binding.logoutSubmit.text = ok_text
            
            binding.logoutSubmit.setOnClickListener {
                submit_listener_onclick?.invoke()
            }
            binding.cancelLogout.setOnClickListener {
                cancel_listener_onclick?.invoke()
            }

        }
        setView(view)
        
    }
}