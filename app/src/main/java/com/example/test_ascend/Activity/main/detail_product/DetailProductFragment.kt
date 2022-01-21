package com.example.test_ascend.Activity.main.detail_product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.test_ascend.Activity.main.base.BaseFragment
import com.example.test_ascend.Activity.main.model.ProductModel
import com.example.test_ascend.R
import kotlinx.android.synthetic.main.fragment_detail_product.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_PARAM1 = "param1"

class DetailProductFragment : BaseFragment() {

    private var productId: Int = 0
    private val viewModel: DetailProductViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            productId = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_product, container, false)
    }

    companion object {
        fun newInstance(productId: Int) =
            DetailProductFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, productId)
                }
            }
    }

    override fun initView() {

    }

    override fun getData() {
        super.getData()
        viewModel.onGetProductById(productId)
        viewModel.getProductById.observe(this, {
            if (it != null) {
                productRetrieved(it)
            }
        })
    }

    fun productRetrieved(productModel: ProductModel) {
        var data = viewModel.getProductById.value
        Glide
            .with(this)
            .load(data?.image)
            .placeholder(R.drawable.cookie_monster)
            .into(img_product)

        if (data?.isNewProduct == true) {
            tv_new.visibility = View.VISIBLE
        }

        tv_title.text = data?.title
        tv_content.text = data?.content
        tv_price.text = data?.price.toString()
    }
}