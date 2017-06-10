package com.androidessence.todo_room

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.Menu
import android.view.MenuItem

class TaskActivity : AppCompatActivity() {

    private val adapter = TaskAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val recyclerview = findViewById(R.id.task_list) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = layoutManager

        val fab = findViewById(R.id.fab)
        fab.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()

        adapter.tasks = taskDao().getAll()
    }
}
