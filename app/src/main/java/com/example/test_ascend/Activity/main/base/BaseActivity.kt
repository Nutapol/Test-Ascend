package com.example.test_ascend.Activity.main.base

import android.view.MenuItem
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.test_ascend.Activity.main.navigator.Navigator
import com.example.test_ascend.R
import kotlinx.android.synthetic.main.toolbarcenter.*
import org.koin.android.ext.android.get

open class BaseActivity : AppCompatActivity() {

    val navigator: Navigator = get()

    fun addFragment(containerViewId: Int, fragment: Fragment) {
        val fragmentTransaction: FragmentTransaction =
            this.supportFragmentManager.beginTransaction()
        fragmentTransaction.add(containerViewId, fragment)
        fragmentTransaction.commit()
    }

    open fun setToolbarTitle(title: String?, disable: Boolean) {
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        supportActionBar?.setCustomView(R.layout.toolbarcenter);
        home.setOnClickListener { onBackPressed() }
        tv_toolbar.text = title
        if (disable) {
            home.visibility = View.VISIBLE
        }
    }

    fun showActionBar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}