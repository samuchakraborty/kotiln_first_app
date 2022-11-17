package com.samuchakraborty.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textID)
        val nameText = findViewById<EditText>(R.id.nameEditText)
        val emailEdit = findViewById<EditText>(R.id.emailEditText)

        val phone = findViewById<EditText>(R.id.phoneEditText)

        val password = findViewById<EditText>(R.id.passwordEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val offersButton = findViewById<Button>(R.id.offerButton)


        submitButton.setOnClickListener {
            hideKeyboard()
            if (nameText.text.isEmpty()) {
                Toast.makeText(this, "Please Enter your Name", Toast.LENGTH_LONG).show()
                offersButton.visibility = INVISIBLE
            } else {
//                hideKeyboard()
                val message = nameText.text.toString() + "\n" + emailEdit.text.toString()
                val msg = hide(phone.text.toString(), password.text.toString())

                textView.text = message + "\n\n" + msg


//                nameText.text.clear()
//                emailEdit.text.clear()
                offersButton.visibility = VISIBLE
            }

        }

        offersButton.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)

            intent.putExtra("USER", nameText.text.toString())
            nameText.text.clear()
            emailEdit.text.clear()
            startActivity(intent)


        }


    }

    private fun AppCompatActivity.hideKeyboard() {
        val view: View? = this.currentFocus
        if (view != null) {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}


fun hide(firstNumber: String, lastNumber: String): String {

    println(firstNumber)
    return (firstNumber.toDouble() + lastNumber.toDouble()).toString()

}