package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.example.assignment1.MySingleton.Companion.getInstance
import com.squareup.picasso.Picasso
import org.json.JSONObject
import java.lang.reflect.Array
import java.util.Calendar.getInstance

class SubActivity1 : AppCompatActivity() {

    companion object {
        const val URL = "URL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub1)

        /*
        val url = intent.getStringArrayExtra(URL)
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf("A", "B", "C", "D", "E")

        var mListView = findViewById<ListView>(R.id.userlist)
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
        mListView.adapter = arrayAdapter
         */


        val queue = Volley.newRequestQueue(this@SubActivity1)

        val testurl =
            "https://hub.dummyapis.com/ImagesList?text=Test&noofimages=10&height=120&width=120"

        val jsonArrayRequest = JsonArrayRequest(Request.Method.GET, testurl, null,
            { response ->
                //println("Response is $it")

                val imageList = findViewById<ListView>(R.id.userlist)
                val imageView =  findViewById<ImageView>(R.id.imageView)

                val image_url = List(response.length()) {
                    response.getString(it)
                    Picasso.get().load(response.getString(it)).into(imageView)
                }

                val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, image_url)
                imageList.adapter = listAdapter
            },
            {})

            queue.add(jsonArrayRequest)

            // MySingleton.getInstance(this).addToRequestQueue(jsonArrayRequest)
    }
}


