package com.example.androidprojectsem6

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginForm : AppCompatActivity() {

    lateinit var shared_preference : SharedPreferences
    lateinit var email_et_login : EditText
    lateinit var password_et_login : EditText
    lateinit var login_btn_login : Button
    lateinit var clear_btn_login :Button
    lateinit var retrieve_btn_login : Button
    lateinit var register_tv_login : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)

        email_et_login = findViewById(R.id.loginEmail)
        password_et_login = findViewById(R.id.loginPassword)
        login_btn_login = findViewById(R.id.loginButton)
        clear_btn_login = findViewById(R.id.clearButton)
        retrieve_btn_login = findViewById(R.id.retrieveButton)
        register_tv_login = findViewById(R.id.registerTv)

        shared_preference = getSharedPreferences("myPref", Context.MODE_PRIVATE)

        login_btn_login.setOnClickListener {
            val editor = shared_preference.edit()
            editor.apply {
                putString("Email Id", email_et_login.text.toString())
                putString("Password", password_et_login.text.toString())
            }

            editor.apply()
        }

        retrieve_btn_login.setOnClickListener {
            email_et_login.setText(shared_preference.getString("Email Id", null))
            password_et_login.setText(shared_preference.getString("Password", null))
        }

        clear_btn_login.setOnClickListener {
            email_et_login.setText("")
            password_et_login.setText("")
        }

        register_tv_login.setOnClickListener {
            val intent = Intent(this, RegisterForm::class.java)
            startActivity(intent)
        }

    }


}