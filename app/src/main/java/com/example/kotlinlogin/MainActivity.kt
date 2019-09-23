package com.example.kotlinlogin

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinlogin.Constant.Companion.token


class MainActivity : AppCompatActivity() {
private lateinit var dataSaver:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         dataSaver = getDefaultSharedPreferences(this);

        val buttonLogin = findViewById(R.id.buttonLogin) as Button
        val editTextEmail = findViewById(R.id.editTextEmail) as EditText
        val editTextPassword = findViewById(R.id.editTextPassword) as EditText

        buttonLogin.setOnClickListener {

            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isEmpty()) {
                editTextEmail.error = "Email required"
                editTextEmail.requestFocus()
            } else if (password.isEmpty()) {
                editTextPassword.error = "Password required"
                editTextPassword.requestFocus()

            } else {
                var loginViewModel: LoginViewModel = ViewModelProviders.of(this)[LoginViewModel::class.java]

                loginViewModel.getData(email, password, applicationContext).observe(this,
                    Observer<LoginModel> { loginmodel ->
                        if (loginmodel != null) {

                            val customer_id = loginmodel.loginResult.accessToken
                            dataSaver.edit().putString(token  , customer_id).apply()


                            val id = dataSaver.getString(token, "");


                            Toast.makeText( applicationContext, loginmodel.loginResult.userMessage+"  "+id, Toast.LENGTH_LONG).show()
                        }
                    })
            }

        }
    }
}
