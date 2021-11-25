package com.example.dbdemo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var helper = MyHelper(applicationContext)
        var db = helper.readableDatabase

        var edName = findViewById<EditText>(R.id.edName)
        var edPassword = findViewById<EditText>(R.id.edPassword)

        var login = findViewById<Button>(R.id.button)
        login.setOnClickListener {
            var rs = db.rawQuery("SELECT * FROM LOGIN WHERE USERNAME = ? AND PASSWORD = ?", arrayOf(edName.text.toString(),edPassword.text.toString()))

            if(rs.moveToFirst())
            {
                var active = rs.getString(4).toString()
                if(edName.text.toString().equals("admin.in"))
                {
                    var intent = Intent(applicationContext,AdminActivity::class.java)
                    startActivity(intent)
                }
                else if(active.equals("yes"))
                {
                    Toast.makeText(applicationContext,"Welcome you ae authenthicate",Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext,"Your profile is not aproved",Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(applicationContext,"Invalid Creadentail",Toast.LENGTH_LONG).show()
            }
        }
    }
}