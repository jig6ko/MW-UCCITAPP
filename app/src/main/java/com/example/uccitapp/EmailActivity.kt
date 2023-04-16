package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email)

        val fabSend: FloatingActionButton = findViewById(R.id.fabSend)
        val editTextSubject: EditText = findViewById(R.id.editTextSubject)
        val editTextMessage: EditText = findViewById(R.id.editTextMessage)

        fabSend.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:ithod@ucc.edu.jm")

            intent.putExtra(Intent.EXTRA_SUBJECT,editTextSubject.text.toString())
            intent.putExtra(Intent.EXTRA_TEXT,editTextMessage.text.toString())
            startActivity(Intent.createChooser(intent, "Send email"))
        }
    }
}