package com.example.todoapp_160420088.model

import androidx.room.*

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todo:Todo)
    @Query("SELECT * FROM todo ORDER BY priority DESC")
    fun selectAllTodo(): List<Todo>
    @Query("SELECT * FROM todo WHERE uuid= :id")
    fun selectTodo(id:Int): Todo
    @Delete
    fun deleteTodo(todo:Todo)

    @Query("UPDATE todo SET title= :title, notes= :notes, priority= :priority, is_done=:is_done WHERE uuid= :id")
    fun update(title:String, notes:String, priority:Int, is_done:Int, id:Int)
}