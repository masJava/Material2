package com.mas.material2

import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val random = Random()

    private val style = arrayOf(
        R.style.Theme_Material2,
        R.style.BrokenGreenStyle,
        R.style.Theme_Material_Blue,
        R.style.Theme_Material_Red
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("SharedPreferences", MODE_PRIVATE)

        setTheme(sharedPreferences.getInt("style", style.first()))
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonStyle.setOnClickListener {
            sharedPreferences
                .edit()
                .putInt("style", style[random.nextInt(style.size)])
                .apply()
            recreate()
        }
    setFonts()
        textViewRoboto.typeface = Typeface.createFromAsset(baseContext.assets, "font/roboto.ttf")
        textViewCaveat.typeface = Typeface.createFromAsset(baseContext.assets, "font/caveat.ttf")
        textViewCaveat.textSize = 20f
    }

    private fun setFonts() {

    }
}
