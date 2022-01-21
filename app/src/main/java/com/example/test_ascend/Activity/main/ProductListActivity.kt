package com.example.test_ascend.Activity.main

import android.os.Bundle
import com.example.test_ascend.Activity.main.base.BaseActivity
import com.example.test_ascend.R

class ProductListActivity : BaseActivity() , ProductListFragment.Delegate {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbarTitle("Product",false)
        addFragment(R.id.container, ProductListFragment.newInstance())

    }

    override fun onClickItem(id:Int) {
        this.navigator.toProduct(this,id)
    }
}