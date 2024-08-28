package com.example.mythirdapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import android.os.Bundle
import android.view.Display
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val index: Int = intent.getIntExtra("com.example.mythirdapplication.ITEM_INDEX", -1)

        if (index > -1){
            val pic = getImg(index)
            val img: ImageView = findViewById(R.id.imageView)
            scaleImg(img, pic)
        }

    }

    private fun getImg(index: Int): Int{
        return when (index){
            0 -> R.drawable.peach
            1 -> R.drawable.tomato
            2 -> R.drawable.squash
            else -> -1

        }
    }
    private fun scaleImg(img: ImageView, pic: Int){
        val screen: Display = windowManager.defaultDisplay
        val options = BitmapFactory.Options()

        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, pic, options)

        val imgWidth: Int = options.outWidth
        val screenWidth: Int = screen.width

        if (imgWidth > screenWidth){
            val ratio = Math.round((imgWidth / screenWidth).toDouble()).toInt()
            options.inSampleSize = ratio
        }

        options.inJustDecodeBounds = false
        val scaledImg = BitmapFactory.decodeResource(resources, pic, options)
        img.setImageBitmap(scaledImg)
    }
}