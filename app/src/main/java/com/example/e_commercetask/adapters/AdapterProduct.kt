package com.example.e_commercetask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_commercetask.databinding.ItemProductsBinding
import com.example.e_commercetask.pojo.Product

class AdapterProduct: RecyclerView.Adapter<AdapterProduct.Holder>(){

    var productList: List<Product>? = null
    private lateinit var onClick: (String) -> Unit?
    fun setOnClick(onClick: (String) -> Unit) {
        this.onClick = onClick}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount() = productList?.size ?: 0

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = productList!![position]
        holder.bind(data)
    }


    inner class Holder(private val binding: ItemProductsBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onClick.invoke(productList!![layoutPosition].id.toString())
            }
        }

        fun bind(productList: Product) {
            binding.apply {
                Glide.with(binding.root.context)
                    .load(productList.images[0])
                    .into(imgProduct)
                tvProductName.text = productList.title
                tvProductThumb.text = productList.description
                tvPrice.text = productList.price.toString()
                tvOldPrice.text = (productList.discountPercentage.toString() + "%")
                tvReviewCount.text = productList.rating.toString()
            }
        }
    }
}