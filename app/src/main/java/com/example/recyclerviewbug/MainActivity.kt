package com.example.recyclerviewbug

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }
    private val adapter by lazy { ElementsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        grid.layoutManager = GridLayoutManager(this, 10)
        grid.adapter = adapter
        button.setOnClickListener { viewModel.update() }
        viewModel.listOfLettersLiveData.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
