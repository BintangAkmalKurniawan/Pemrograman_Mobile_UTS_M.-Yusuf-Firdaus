package com.example.mymedia

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etRePassword = findViewById<EditText>(R.id.etRePassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvBackToLogin = findViewById<TextView>(R.id.tvBackToLogin)

        btnRegister.setOnClickListener {
            val nama = etNama.text.toString()
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val rePassword = etRePassword.text.toString()

            if (nama.isEmpty() || username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi", Toast.LENGTH_SHORT).show()
            } else if (password != rePassword) {
                Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
            } else {
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("nama", nama)
                    putString("username", username)
                    putString("password", password)
                    apply()
                }

                Toast.makeText(this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }

        tvBackToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
