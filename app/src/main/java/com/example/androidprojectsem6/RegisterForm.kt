package com.example.androidprojectsem6

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream

class RegisterForm : AppCompatActivity(){

    lateinit var name_et_register : EditText
    lateinit var email_et_register : EditText
    lateinit var password_et_register : EditText
    lateinit var contact_et_register : EditText
    lateinit var register_btn_register : Button

    private val file = "myRegisterData.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)

        name_et_register = findViewById(R.id.nameRegister)
        email_et_register = findViewById(R.id.emailRegister)
        password_et_register = findViewById(R.id.passwordRegister)
        contact_et_register = findViewById(R.id.contactRegister)
        register_btn_register = findViewById(R.id.registerRegisterBtn)

        register_btn_register.setOnClickListener {
            try {
                val f_out : FileOutputStream = openFileOutput(file, MODE_APPEND)
                f_out.write(name_et_register.text.toString().toByteArray())
                f_out.write(email_et_register.text.toString().toByteArray())
                f_out.write(password_et_register.text.toString().toByteArray())
                f_out.write(contact_et_register.text.toString().toByteArray())
                f_out.close()

                Toast.makeText(baseContext, "Registered Successfully!!! Ur info is saved to Internal Storage", Toast.LENGTH_LONG).show()
            }
            catch(e: Exception) {
                e.printStackTrace()
            }

            val intent = Intent(this, FirstPage::class.java)
            startActivity(intent)
        }
    }
}