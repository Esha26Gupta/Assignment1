package com.example.assignment1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun OpenSubActivity1(view : View){
        val url = "https://hub.dummyapis.com/ImagesList?text=Test&noofimages=10&height=120&width=120"
        val intent = Intent(this, SubActivity1::class.java)
       // intent.putExtra(SubActivity1.URL, url)
        intent.putExtra("URL", url)
        startActivity(intent)
    }
}