package com.example.e_commercetask.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.e_commercetask.R
import com.example.e_commercetask.adapters.AdapterProduct
import com.example.e_commercetask.base.BaseFragment
import com.example.e_commercetask.databinding.FragmentProductsBinding
import com.example.e_commercetask.pojo.Product
import com.example.e_commercetask.util.Resource
import com.example.e_commercetask.util.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate){
    private val productsViewModel : ProductsViewModel by viewModels()
    private val adapterProduct = AdapterProduct()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        productsViewModel.getProductsDetails()
    }

    override fun observe() {
        super.observe()
        productsViewModel.productsLiveData.observe(viewLifecycleOwner) {it ->
            when (it) {
                is Resource.Success -> {
                    finishLoading()
                    it.data?.let {
                        setContentInViews(it)
                    }
                }

                is Resource.Error -> {
                    it.message?.let { message ->
                        showToast(message)
                    }
                }
            }
        }
    }

    override fun showLoading() {
        super.showLoading()
    }

    override fun finishLoading() {
        super.finishLoading()
    }

    private fun setContentInViews(product:List<Product>){
        adapterProduct.productList = product
        binding.rvProducts.adapter = adapterProduct
    }
}
