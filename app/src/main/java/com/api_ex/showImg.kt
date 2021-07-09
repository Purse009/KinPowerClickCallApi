package com.api_ex

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class showImg : AppCompatActivity() {
    private var ImgView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_img)

        ImgView = findViewById(R.id.showBigImg)

        val getImg = intent.getStringExtra("getimgfromAdapter")
        Picasso.get().load(getImg).into(ImgView)
    }
}