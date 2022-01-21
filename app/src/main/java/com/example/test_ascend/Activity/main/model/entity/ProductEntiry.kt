package com.example.test_ascend.Activity.main.model.entity

import com.example.test_ascend.Activity.main.model.ProductModel

data class ProductEntiry(
    var id: Int = 0,
    var title: String = "",
    var image: String = "",
    var content: String = "",
    var isNewProduct: Boolean = false,
    var price: Double = 0.000
) {
    fun toModel(): ProductModel {
        val model = ProductModel()
        model.id = id
        model.title = title
        model.image = image
        model.content = content
        model.isNewProduct = isNewProduct
        model.price = price

        return model
    }
}