package com.example.test_ascend.Activity.main.dialog

import android.app.Activity
import android.app.Dialog
import android.content.DialogInterface
import android.view.Window
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.example.test_ascend.R

class DialogError {

    fun showDialog(activity: Activity,message:String) {
        val dialogBuilder = AlertDialog.Builder(activity)
        dialogBuilder.setMessage(message)
            // if the dialog is cancelable
            .setCancelable(false)
            .setPositiveButton("Close", DialogInterface.OnClickListener { dialog, id ->
                dialog.dismiss()

            })

        val alert = dialogBuilder.create()
        alert.setTitle("Error")
        alert.show()
    }
}