package com.example.newsapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import com.example.newsapi.webview
import kotlinx.android.synthetic.main.activity_webview.*

class webview : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)



        val bundle:Bundle = intent.extras
        val position = bundle.get("item")
        Toast.makeText(applicationContext,position.toString(),Toast.LENGTH_LONG).show()
        webview1.loadUrl(position.toString())
    }

}
