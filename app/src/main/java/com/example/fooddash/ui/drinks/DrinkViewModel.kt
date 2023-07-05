package com.example.fooddash.ui.drinks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddash.db.entity.Product
import com.example.fooddash.repository.CustomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DrinkViewModel : ViewModel() {

    private val _listProducts: MutableLiveData<List<Product>> = MutableLiveData<List<Product>>()
    val listProducts: LiveData<List<Product>> = _listProducts

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _listProducts.postValue(CustomRepository.getProductsByCategoryDrinks())
            }
        }
    }

}