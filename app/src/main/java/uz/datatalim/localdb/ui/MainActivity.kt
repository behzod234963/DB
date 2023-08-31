package uz.datatalim.localdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.datatalim.localdb.adapter.Adapter
import uz.datatalim.localdb.R
import uz.datatalim.localdb.data.local.UsersRepository
import uz.datatalim.localdb.model.UsersModel

class MainActivity : AppCompatActivity() {

    lateinit var list: ArrayList<UsersModel>
    lateinit var adapter: Adapter
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
        adapter= Adapter()

        val btnSave:Button=findViewById(R.id.btnSave)
        val btnGet:Button=findViewById(R.id.btnGet)
        val etUsername:EditText=findViewById(R.id.etEmail)
        val etPassword:EditText=findViewById(R.id.etPassword)
        val etPhone:EditText=findViewById(R.id.etPhone)
        val tvBackup:TextView=findViewById(R.id.tvBackup)
        rvDB.layoutManager=LinearLayoutManager(this)
        rvDB.adapter=adapter
        adapter.submitList(list)

        btnSave.setOnClickListener {

            val user=UsersModel(null,etUsername.text.toString(),etPassword.text.toString(),etPhone.text.toString())
            repository.saveUsers(user)

        }

        btnGet.setOnClickListener {

            loadUsers()
            adapter.submitList(list)

        }

    }

    private fun loadUsers() {
        list= ArrayList()
        list= repository.getAllUser() as ArrayList<UsersModel>
    }

}