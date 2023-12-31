package com.example.todoapp_160420088.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.example.todoapp_160420088.model.Todo
import com.example.todoapp_160420088.model.TodoDatabase
import com.example.todoapp_160420088.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DetailTodoViewModel(application: Application)
    : AndroidViewModel(application), CoroutineScope {
    val todoLD = MutableLiveData<Todo>()
    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun fetch(uuid:Int) {
        launch {
            val db = buildDb(getApplication())
            todoLD.postValue(db.todoDao().selectTodo(uuid))
        }
    }
    fun update(title:String, notes:String, priority:Int,is_done:Int, uuid:Int) {
        launch {
            val db = buildDb(getApplication())
            db.todoDao().update(title, notes, priority, is_done, uuid)
        }
    }
    fun addTodo(todo:Todo) {
        launch {
            /*val db = Room.databaseBuilder(
                getApplication(), TodoDatabase::class.java,
                "newtododb").build()*/

            val db = buildDb(getApplication())
            db.todoDao().insertAll(todo)
        }
    }
}