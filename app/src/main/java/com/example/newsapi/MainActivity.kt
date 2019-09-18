package com.example.newsapi


import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val httpClient = OkHttpClient.Builder().build()




        val baseurl = "https://newsapi.org/v2/top-headlines?country="
//        val apiKey = "=c9228cd9cf464caa9174e8c3f2ec51eb"

        recylerV.addOnItemTouchListener(NextActivity(this, recylerV, object : NextActivity.OnItemClickListener {

            @SuppressLint("ShowToast")
            override fun onItemClick(view: View, position: Int) {

               Toast.makeText(applicationContext, "Single Click on position :"+position, Toast.LENGTH_SHORT).show()
                intent = Intent(this@MainActivity , webview::class.java)
                intent.putExtra("item" ,position )
                startActivity(intent)
                //do your work here..
            }
            @SuppressLint("ShowToast")
            override fun onItemLongClick(view: View?, position: Int) {
                Toast.makeText(applicationContext , "longclicked"  , Toast.LENGTH_SHORT).show()

            }
        }))

        btn.setOnClickListener {
            val name = et.text.toString().toLowerCase()
            val request = Request.Builder().url("$baseurl$name&apiKey=c9228cd9cf464caa9174e8c3f2ec51eb").build()

            httpClient.newCall(request).enqueue(object : Callback{
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {

                    val responseBody = response.body()
                    val result = responseBody?.string()
                    val gson = Gson()

                    val root = gson.fromJson(result , root::class.java)
                    runOnUiThread {
                        recylerV.layoutManager = LinearLayoutManager(baseContext)
                        recylerV.adapter = Newsadpter(root.articles)

                    }

                }



            })
        }


    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }


}
