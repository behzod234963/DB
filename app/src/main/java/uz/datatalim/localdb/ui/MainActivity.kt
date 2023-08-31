package uz.datatalim.localdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import uz.datatalim.localdb.R
import uz.datatalim.localdb.data.local.UsersRepository
import uz.datatalim.localdb.model.UsersModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

    }

    private fun initView() {

        val btnSave:Button=findViewById(R.id.btnSave)
        val btnGet:Button=findViewById(R.id.btnGet)
        val etUsername:EditText=findViewById(R.id.etEmail)
        val etPassword:EditText=findViewById(R.id.etPassword)
        val repository=UsersRepository(application)
        val tvBackup:TextView=findViewById(R.id.tvBackup)

        btnSave.setOnClickListener {

            val user=UsersModel(1,"Behzod","4444","+998973570498")
            repository.saveUsers(user)

        }

        btnGet.setOnClickListener {

            val getUsers=repository.getUserById(1)
            tvBackup.text=getUsers.toString()

        }

    }
}