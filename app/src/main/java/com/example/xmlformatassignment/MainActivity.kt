package com.example.xmlformatassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var myRv: RecyclerView
    private lateinit var students: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRv = findViewById(R.id.recyclerView)

        try{
            val parser = MyXmlPullParserHandler()
            val iStream = assets.open("studentdetails.xml")
            students = parser.parse(iStream)
            myRv.adapter = RecyclerViewAdapter(students)
            myRv.layoutManager = LinearLayoutManager(this)
        }catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}