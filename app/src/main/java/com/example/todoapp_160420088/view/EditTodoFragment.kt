package com.example.todoapp_160420088.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.todoapp_160420088.R
import com.example.todoapp_160420088.viewmodel.DetailTodoViewModel

class EditTodoFragment : Fragment() {
    private lateinit var viewModel: DetailTodoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)
        val uuid = EditTodoFragmentArgs.fromBundle(requireArguments()).uuid
        viewModel.fetch(uuid)

        val btnAdd=view.findViewById<Button>(R.id.btnAdd)
        val txtJudulTodo=view.findViewById<TextView>(R.id.txtJudulTodo)
        btnAdd.text = "Save Changes"
        txtJudulTodo.text = "Edit Todo"

        btnAdd.setOnClickListener(){
            val txtTitle = view.findViewById<EditText>(R.id.txtTitle)
            val txtNotes = view.findViewById<EditText>(R.id.txtNotes)
            var radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupPriority)
            var radioButton = view.findViewById<RadioButton>(radioGroup.checkedRadioButtonId)

            /*viewModel.update(txtTitle.text.toString(), txtNotes.text.toString(),
                radioButton.tag.toString().toInt(), is_done, uuid)
            Toast.makeText(view.context, "Todo updated", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()*/

        }
        observeViewModel()
    }
    fun observeViewModel() {
        viewModel.todoLD.observe(viewLifecycleOwner, Observer {
            val txtTitle = view?.findViewById<EditText>(R.id.txtTitle)
            val txtNotes = view?.findViewById<EditText>(R.id.txtNotes)
            txtTitle?.setText(it.title)
            txtNotes?.setText(it.notes)

            val high = view?.findViewById<RadioButton>(R.id.radioHigh)
            val medium = view?.findViewById<RadioButton>(R.id.radioMedium)
            val low = view?.findViewById<RadioButton>(R.id.radioLow)

            when (it.priority) {
                1 -> low?.isChecked = true
                2 -> medium?.isChecked = true
                else -> high?.isChecked = true
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_todo, container, false)
    }

}