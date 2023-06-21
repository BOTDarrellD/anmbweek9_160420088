package com.example.todoapp_160420088.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.example.todoapp_160420088.R
import com.example.todoapp_160420088.databinding.FragmentCreateTodoBinding
import com.example.todoapp_160420088.model.Todo
import com.example.todoapp_160420088.util.NotificationHelper
import com.example.todoapp_160420088.util.TodoWorker
import com.example.todoapp_160420088.viewmodel.DetailTodoViewModel
import java.util.concurrent.TimeUnit

class CreateTodoFragment : Fragment(), TodoCreateLayoutInterfaces {
    private lateinit var viewModel: DetailTodoViewModel
    private lateinit var dataBinding: FragmentCreateTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_create_todo, container, false)
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_create_todo, container, false)
        return  dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this).get(DetailTodoViewModel::class.java)
        dataBinding.todo=Todo("","",3,0)
        dataBinding.radioListener=this
        dataBinding.buttonListener=this
        /*val btnAdd = view.findViewById<Button>(R.id.btnAdd)
        btnAdd.setOnClickListener {
            val myWorkRequest= OneTimeWorkRequestBuilder<TodoWorker>()
                .setInitialDelay(30,TimeUnit.SECONDS)
                .setInputData(workDataOf(
                                "title" to "Todo Created",
                                "message" to "A new todo has been created! Stay focus!"))
                .build()
            WorkManager.getInstance(requireContext()).enqueue(myWorkRequest)

            NotificationHelper(view.context)
                .createNotification("Todo Created",
                    "A new todo has been created! Stay focus!")

            var radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupPriority)
            var radioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
            val txtTitle = view.findViewById<EditText>(R.id.txtTitle)
            val txtNotes = view.findViewById<EditText>(R.id.txtNotes)
            var todo = Todo(txtTitle.text.toString(), txtNotes.text.toString(),radioButton.tag.toString().toInt())
            val list = listOf(todo)
            viewModel.addTodo(todo)
            Toast.makeText(view.context, "Todo Data added", Toast.LENGTH_LONG).show()
            Navigation.findNavController(it).popBackStack()
        }*/
    }

    override fun onRadioClick(v: View, priority: Int, obj: Todo) {
        TODO("Not yet implemented")
    }

    override fun onButtonAddClick(v: View) {
        TODO("Not yet implemented")
    }
}