package com.example.e_commercetask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commercetask.pojo.Product
import com.example.e_commercetask.repo.Repository
import com.example.e_commercetask.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var _productsLiveData = MutableLiveData<Resource<List<Product>?>>()
    val productsLiveData get() = _productsLiveData
    private var saveStateProducts: Resource<List<Product>?>?=null


    fun getProductsDetails() {
        saveStateProducts?.let {
            productsLiveData.postValue(it)
            return
        }
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getProducts()
                if (response.products.isNotEmpty()) {
                    _productsLiveData.postValue(Resource.Success(response.products))
                    saveStateProducts = Resource.Success(response.products)

                } else {
                    _productsLiveData.postValue(Resource.Error(response.toString()))
                }

            } catch (e: Exception) {
                _productsLiveData.postValue(Resource.Error("An error occurred: ${e.message}"))
            }
        }
    }
}