package com.example.test_ascend.Activity.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test_ascend.Activity.main.adapter.ProductAdapter
import com.example.test_ascend.Activity.main.base.BaseFragment
import com.example.test_ascend.Activity.main.dialog.DialogError
import com.example.test_ascend.Activity.main.model.ProductModel
import com.example.test_ascend.R
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductListFragment : BaseFragment(), ProductAdapter.Delegate {

    private val viewModel: ProductListViewModel by viewModel()
    var delegate: Delegate? = null
    var adapter: ProductAdapter? = null

    interface Delegate {
        fun onClickItem(id: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProductListFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Delegate)
            this.delegate = context
    }

    override fun initView() {
        super.initView()
        adapter = context?.let { ProductAdapter(it, emptyList(), this) }
        recycle_view.let {
            it.adapter = adapter
            it.layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        }
    }

    override fun getData() {
        super.getData()
        viewModel.onGetProduct()
        viewModel.listProduct.observe(this, {
            adapter?.list = it
            adapter?.notifyDataSetChanged()
            progress_bar.visibility = View.GONE
        })
        viewModel.error.observe(this, {
            val dialog = DialogError()
            activity?.let { c ->
                dialog.showDialog(c, it)
                progress_bar.visibility = View.GONE
            }
        })
    }

    override fun onItemClick(product: ProductModel) {
        product.id?.let { delegate?.onClickItem(it) }
    }
}