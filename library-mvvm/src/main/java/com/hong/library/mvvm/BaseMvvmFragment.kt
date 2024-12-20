package com.hong.library.mvvm

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import me.leefeng.promptlibrary.PromptDialog

abstract class BaseMvvmFragment<VM : BaseViewModel<*, *>, VB : ViewBinding> : Fragment() {
    protected lateinit var viewModel: VM
    protected lateinit var binding: VB
    private lateinit var fylToast: FylToast
    private val promptDialog by lazy { PromptDialog(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = initBinding(inflater, container)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = createViewModel()
        lifecycle.addObserver(viewModel)
        logic()
    }

    open fun t(message: String?) {
        if (::fylToast.isInitialized) {
            fylToast.setMessage(message)
            fylToast.show()
            return
        }
        fylToast = FylToast.makeText(requireContext(), message, Toast.LENGTH_SHORT)
        fylToast.setGravity(Gravity.CENTER, 0, 0)
        fylToast.setMessage(message)
        fylToast.show()
    }

    fun showDialog() {
        promptDialog.showLoading("")
    }

    fun dismissDialog() {
        promptDialog.dismiss()
    }


    abstract fun logic()

    abstract fun initBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    abstract fun createViewModel(): VM
}