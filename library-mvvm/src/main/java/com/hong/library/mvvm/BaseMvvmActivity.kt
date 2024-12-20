package com.hong.library.mvvm

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import me.leefeng.promptlibrary.PromptDialog
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType

abstract class BaseMvvmActivity<VM:BaseViewModel<*,*>,VB: ViewBinding>:AppCompatActivity() {
    lateinit var viewModel: VM
    lateinit var binding: VB
    lateinit var fylToast: FylToast
    private val promptDialog by lazy { PromptDialog(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = initBinding()
        setContentView(binding.root)
        viewModel = createViewModel()
        lifecycle.addObserver(viewModel)
        logic()
        observable()
    }

    private fun initBinding(): VB {
        val bindingClass = getBindingClass()
        val method: Method = bindingClass.getMethod("inflate", LayoutInflater::class.java)
        return method.invoke(null, layoutInflater) as VB
    }

    private fun getBindingClass(): Class<VB> {
        val type = javaClass.genericSuperclass as ParameterizedType
        return type.actualTypeArguments[1] as Class<VB>
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN && null != this.currentFocus) {
            val mInputMethodManager = (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
            return mInputMethodManager.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        }
        return super.onTouchEvent(event)
    }

    fun hideShowKeyboard() {
        val manager = (getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager)
        manager.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
    }

    fun t(message: String?) {
        if (::fylToast.isInitialized) {
            fylToast.setMessage(message)
            fylToast.show()
            return
        }
        fylToast = FylToast.makeText(this, message, Toast.LENGTH_SHORT)
        fylToast.setGravity(Gravity.CENTER, 0, 0)
        fylToast.setMessage(message)
        fylToast.show()
    }

    fun showDialog() {
        promptDialog.showLoading("")
    }

    fun showDialog(msg:String) {
        promptDialog.showLoading(msg)
    }

    fun dismissDialog() {
        promptDialog.dismiss()
    }

    abstract fun logic()

    abstract fun observable()

    abstract fun createViewModel(): VM
}