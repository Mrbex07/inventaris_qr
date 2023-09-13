package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import android.widget.ProgressBar
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.myapplication.R
import com.example.myapplication.API.RetroServer
import com.example.myapplication.API.APIRequestData
import com.example.myapplication.Model.ResponseModel
import com.example.myapplication.Model.DataModel
import com.example.myapplication.Adapter.AdapterData
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class table : AppCompatActivity() {
    var rvData: RecyclerView? = null
    var adData: RecyclerView.Adapter<*>? = null
    var lmData: RecyclerView.LayoutManager? = null
    var listData: List<DataModel> = ArrayList<DataModel>()
    var srlData: SwipeRefreshLayout? = null
    var pbData: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.table)
        rvData = findViewById(R.id.rv_data)
        srlData = findViewById(R.id.srl_data)
        pbData = findViewById(R.id.pb_data)

        lmData = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        with(rvData){
            this?.setLayoutManager(lmData)
        }
        with(srlData){
            this?.setOnRefreshListener(OnRefreshListener {
                setRefreshing(true)
                retrieveData()
                setRefreshing(false)
            })
        }
    }

    override fun onResume() {
        super.onResume()
        retrieveData()
    }
    fun retrieveData(){
        pbData!!.visibility = View.VISIBLE

        val ardData: APIRequestData = RetroServer.konekRetrofit().create(APIRequestData::class.java)
        val tampilData: Call<ResponseModel> = ardData.ardRetrieveData()

        tampilData.enqueue(object : Callback<ResponseModel>{
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                listData = response.body()!!.getData()
                adData = AdapterData(this@table,listData)
                rvData!!.adapter = adData
                adData!!.notifyDataSetChanged()
                pbData!!.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(
                    this@table,
                    "gagal terkoneksi: "+ t.message,
                    Toast.LENGTH_SHORT
                ).show()
                pbData!!.visibility = View.INVISIBLE
            }
        })
    }
}