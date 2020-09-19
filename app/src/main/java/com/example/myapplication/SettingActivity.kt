package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        txt_edit.setOnClickListener{
            val intent = Intent(this, EditActivity::class.java)
            startActivity(intent)
        }

        txt_protector.setOnClickListener{
            val intent = Intent(this, PlusProtectorActivity::class.java )
            startActivity(intent)
        }

        txt_protected.setOnClickListener{
            val intent = Intent(this, PlusProtectedActivity::class.java )
            startActivity(intent)
        }
    }
}