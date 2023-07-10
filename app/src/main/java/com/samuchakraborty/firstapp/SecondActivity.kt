package com.samuchakraborty.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val data = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvText)



        textView.text = data.toString() + "/////////////"

        




    }
}
