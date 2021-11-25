package com.example.dbdemo3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast

class AdminActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        var helper = MyHelper(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM LOGIN WHERE username != 'admin.in'",null)

        var adapter = SimpleCursorAdapter(applicationContext,
           // android.R.layout.simple_expandable_list_item_2,
            R.layout.mylayout,
            rs,
            arrayOf("name","username","is_active"),
            //intArrayOf(android.R.id.text1,android.R.id.text2),
            intArrayOf(R.id.t1,R.id.t3,R.id.t2),
            0)

        var lv = findViewById<ListView>(R.id.listview)
        lv.adapter = adapter
    }
}
