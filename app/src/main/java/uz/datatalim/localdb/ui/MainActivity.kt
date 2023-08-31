package uz.datatalim.localdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.datatalim.localdb.Adapter
import uz.datatalim.localdb.R
import uz.datatalim.localdb.data.local.UsersRepository
import uz.datatalim.localdb.model.UsersModel
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    lateinit var list: ArrayList<UsersModel>
    lateinit var ada:Adapter
    private lateinit var repository:UsersRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {
        repository= UsersRepository(application)
        loadUsers()
        val rvDB:RecyclerView=findViewById(R.id.rvDB)
        ada=Adapter()

        rvDB.layoutManager=LinearLayoutManager(this)
        rvDB.adapter=ada
        ada.submitList(list)
        val btnSave:Button=findViewById(R.id.btnSave)
        val btnGet:Button=findViewById(R.id.btnGet)
        val etUsername:EditText=findViewById(R.id.etEmail)
        val etPassword:EditText=findViewById(R.id.etPassword)
        val etPhone:EditText=findViewById(R.id.etPhone)
        val tvBackup:TextView=findViewById(R.id.tvBackup)

        btnSave.setOnClickListener {

            val user=UsersModel(null,etUsername.text.toString(),etPassword.text.toString(),etPhone.text.toString())
            repository.saveUsers(user)

        }

        btnGet.setOnClickListener {

            val getUsers=repository.getUserById(1)
            tvBackup.text=getUsers.toString()

        }

    }

    private fun loadUsers() {
        list= ArrayList()
        list=repository
    }

}