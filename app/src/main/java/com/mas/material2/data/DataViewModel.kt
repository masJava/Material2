package com.mas.material2.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {

    private val viewStateLiveData: MutableLiveData<MutableList<DataClass>> = MutableLiveData()

    init {
        viewStateLiveData.value = DataList.get().value
    }

    fun viewState(): MutableLiveData<MutableList<DataClass>> = viewStateLiveData

    fun add(newData: DataClass) {
        viewStateLiveData.value?.add(newData)
    }
}