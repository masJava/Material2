package com.mas.material2.data

import com.mas.material2.R

object DataList {
    fun get() = listOf(
            DataClass("Апполон", R.drawable.hamster1),
            DataClassRev(R.drawable.hamster2, "Винтик"),
            DataClass("Жолудь", R.drawable.hamster3),
            DataClassRev(R.drawable.hamster4, "Винни"),
            DataClass("Жан", R.drawable.hamster5),
            DataClassRev(R.drawable.hamster6, "Бандит"),
            DataClass("Бублик", R.drawable.hamster7),
            DataClassRev(R.drawable.hamster8, "Зорро"),
            DataClass("Зуффи", R.drawable.hamster9)
    )

}