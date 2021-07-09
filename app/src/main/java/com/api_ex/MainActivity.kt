package com.api_ex

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var service: api
    private var recyclerView: RecyclerView? = null
    private var apiAdapter: api_adapter? = null
    private var getApi: ArrayList<ApiModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.ApiRecyclerView)
        recyclerView!!.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false,
        )
        recyclerView!!.layoutManager = GridLayoutManager(this, 2)

        service = APIClient.getClient()?.create(api::class.java)!!
        service.getAllLanguages().enqueue(object : Callback<List<ApiModel>> {
            override fun onResponse(
                call: Call<List<ApiModel>>,
                response: Response<List<ApiModel>>
            ) {
                val callapi: List<ApiModel>? = response.body()!!
                getApi.clear()
                callapi!!.forEach {
                    getApi.add(it)
                }

                apiAdapter = api_adapter(
                    getApi
                )
                recyclerView!!.adapter = apiAdapter

                apiAdapter!!.clicked = {
                    val intent = Intent(this@MainActivity, showImg::class.java)
                    intent.putExtra("getimgfromAdapter", it)
                    this@MainActivity.startActivity(intent)
                }
            }

            override fun onFailure(call: Call<List<ApiModel>>, t: Throwable) {
            }
        })
    }
}