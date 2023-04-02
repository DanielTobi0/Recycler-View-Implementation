package com.example.recyclerviewlearn

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewlearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateTodo()

    }


    private fun updateTodo() {
        var todoList = mutableListOf(
            // Todo("Eat food", false)
            Todo("I wake up."),
            Todo("Open my pc."),
            Todo("Go through my socials in 10mins max."),
            Todo("Check mytodo list for the day."),
            Todo("Work for about 2hrs"),
            Todo("Get ready for school classes.")

        )

        val adapter = ToDoAdapter(todoList)
        binding.rvTodos.adapter = adapter
        binding.rvTodos.layoutManager = LinearLayoutManager(this)

        binding.btnAddTodo.setOnClickListener {
            val title = binding.etTodo.text.toString()
            //val todo = Todo(title, false)
            val todo = Todo(title)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size - 1)

            binding.etTodo.text.clear()

            closeKeyBoard(binding.btnAddTodo)
        }
    }


    // a function to auto drop the keyBoard softly.
    private fun closeKeyBoard(view: View?) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (view != null) {
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


}