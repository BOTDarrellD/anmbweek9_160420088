package com.example.todoapp_160420088.view

import android.view.View
import android.widget.CompoundButton
import com.example.todoapp_160420088.model.Todo

interface TodoCreateLayoutInterfaces{
    fun onRadioClick(v:View, priority:Int, obj:Todo)
    fun onButtonAddClick(v:View)
}

interface TodoItemLayoutInterface {
    fun onCheckedChanged(cb: CompoundButton,
                         isChecked:Boolean,
                         obj: Todo
    )
    fun OnTodoEditClick(v: View)
}