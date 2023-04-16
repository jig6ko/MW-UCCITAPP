package com.example.uccitapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class AdmissionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admissions)

        val uccApplicationLink = findViewById<TextView>(R.id.ucc_application_link)
        uccApplicationLink.setOnClickListener {
            val url = "https://www.ucc.edu.jm/programmes/tm/bsc-in-information-technology#:~:text=To%20be%20accepted%2C%20applicants%20must,professional%20references%20will%20be%20required."
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }
}