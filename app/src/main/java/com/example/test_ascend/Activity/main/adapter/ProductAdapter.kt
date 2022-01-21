package com.example.test_ascend.Activity.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test_ascend.Activity.main.model.ProductModel
import com.example.test_ascend.R
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(
    val context: Context,
    var list: List<ProductModel>,
    private val delegate: Delegate
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    interface Delegate {
        fun onItemClick(product: ProductModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener { delegate.onItemClick(list[position]) }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: ProductModel) {
            itemView.apply {
                if (product.isNewProduct == true) {
                    tv_new.visibility = View.VISIBLE
                }
                Glide
                    .with(context)
                    .load(product.image)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(img_product)
                tv_title.text = product.title
                tv_price.text = product.price.toString()
            }
        }
    }
}