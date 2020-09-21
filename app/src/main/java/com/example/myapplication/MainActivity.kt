package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val TAG : String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        //사용자 입력 값
        val usr_email = findViewById<EditText>(R.id.reg_email_et)
        val usr_password = findViewById<EditText>(R.id.reg_password_et)

        btn_login.setOnClickListener {
            val intent = Intent(this, LoginResultActivity::class.java)
            if (usr_email.text.toString().length == 0 || usr_password.text.toString().length == 0){
                Toast.makeText(this, "email 혹은 password가 입력되지 않았습니다.", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(usr_email.text.toString(), usr_password.text.toString())
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                            startActivity(intent)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                        }

                        // ...
                    }
            }
        }

        txt_register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
}