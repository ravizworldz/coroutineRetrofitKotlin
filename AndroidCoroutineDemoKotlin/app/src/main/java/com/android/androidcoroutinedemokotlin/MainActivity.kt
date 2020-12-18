package com.android.androidcoroutinedemokotlin

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageView:ImageView = findViewById(R.id.imageview)
        initViewModel(imageView)
    }

    private fun initViewModel(imageView: ImageView) {


        val viewModel  = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.getImageObserver().observe(this, Observer<Bitmap> {
            imageView.setImageBitmap(it)
        })
        viewModel.makeApiCall("4")
    }
}