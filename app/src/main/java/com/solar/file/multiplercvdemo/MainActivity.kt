package com.solar.file.multiplercvdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private val travels = mutableListOf(Travel())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(travels) {
            Log.e("HVV1312", "ok")
        }
        var grid = GridLayoutManager(this, 4)
        rcl_view.apply {
            adapter = this@MainActivity.adapter
            grid.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    var type = adapter?.getItemViewType(position)
                    return if (type == 0) {
                        4
                    } else {
                        1
                    }
                }

            }
            rcl_view.layoutManager = grid
            addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        }
    }
}