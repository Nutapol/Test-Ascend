package com.example.test_ascend.Activity.main.base

import android.R
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        getData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    open fun initView() {

    }

    open fun getData(){

    }

    fun showAlert(message: String) {
        if (message == "")
            return
        val builder: AlertDialog.Builder? = context?.let { AlertDialog.Builder(it) }
        builder?.setCancelable(false)
        builder?.setMessage(message)
        builder?.setPositiveButton(
            R.string.ok,
            DialogInterface.OnClickListener { dialog, id ->
                // Do something
            })
        builder?.create()?.show()
    }

}