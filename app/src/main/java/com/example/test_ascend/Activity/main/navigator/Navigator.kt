package com.example.test_ascend.Activity.main.navigator

import android.content.Context
import com.example.test_ascend.Activity.main.detail_product.DetailProductActivity

open class Navigator {

    fun toProduct(context : Context,id:Int){
        val activity = DetailProductActivity.callingIntent(context,id)
        context.startActivity(activity)
    }
}