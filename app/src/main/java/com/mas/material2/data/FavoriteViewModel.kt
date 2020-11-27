package com.mas.material2.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FavoriteViewModel : ViewModel() {

    private val viewStateLiveData: MutableLiveData<MutableList<DataClass>> = MutableLiveData()

    fun viewState(): MutableLiveData<MutableList<DataClass>> = viewStateLiveData

    fun add(newData: DataClass) {
        viewStateLiveData.value?.add(newData)
    }
}