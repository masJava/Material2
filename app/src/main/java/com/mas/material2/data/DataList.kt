package com.mas.material2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mas.material2.R

object DataList {
    private val hamsterLiveData = MutableLiveData<MutableList<DataClass>>()

    init {
        hamsterLiveData.value = mutableListOf(
            DataClass("Апполон", R.drawable.hamster1),
            DataClass("Винтик", R.drawable.hamster2),
            DataClass("Жолудь", R.drawable.hamster3),
            DataClass("Винни", R.drawable.hamster4),
            DataClass("Жан", R.drawable.hamster5),
            DataClass("Бандит", R.drawable.hamster6),
            DataClass("Бублик", R.drawable.hamster7),
            DataClass("Зорро", R.drawable.hamster8),
            DataClass("Зуффи", R.drawable.hamster9)
        )
    }

    fun get(): LiveData<MutableList<DataClass>> = hamsterLiveData

}