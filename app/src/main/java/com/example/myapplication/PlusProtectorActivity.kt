package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.alert_popup.*


class PlusProtectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plus_protector)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main2,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {

            R.id.action_btn2 -> {
                // 기능 소스

                showSettingPopup()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showSettingPopup() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alert_popup, null)
        val textView: TextView = view.findViewById(R.id.txt_pop)
        val textView2: TextView = view.findViewById(R.id.txt_pop2)
        val textView3: TextView = view.findViewById(R.id.txt_pop3)

        
        val arrayList = ArrayList<Int>()

        val rand = java.util.Random().nextInt(999999)
        if(arrayList.contains(rand)){
            kotlin.run { butSave }
        } else{
            textView2.text = rand.toString()
        }
        arrayList.add(rand)

        textView.text = "인증번호: "
        textView3.text = "보호자는 이 인증번호를 등록하십시오."

        val alertDialog = AlertDialog.Builder(this).setTitle("인증번호 생성").create()

        val butSave = view.findViewById<Button>(R.id.butSave)
        butSave.setOnClickListener {
            alertDialog.dismiss()
        }
        alertDialog.setView(view)
        alertDialog.show()
    }
}
