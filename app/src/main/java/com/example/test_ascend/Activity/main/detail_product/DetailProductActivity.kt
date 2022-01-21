package com.example.test_ascend.Activity.main.detail_product

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.test_ascend.Activity.main.base.BaseActivity
import com.example.test_ascend.R

class DetailProductActivity : BaseActivity() {

    companion object {
        val ID = "ID"
        fun callingIntent(context: Context,id:Int): Intent {
            val intent = Intent(context, DetailProductActivity::class.java)
            intent.putExtra(ID,id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)
        setToolbarTitle("Detail",true)
        val producId = intent.getIntExtra(ID,0)
        addFragment(R.id.container, DetailProductFragment.newInstance(producId))
    }

}