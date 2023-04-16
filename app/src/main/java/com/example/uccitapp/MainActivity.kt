package com.example.uccitapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set click listener on card views
        findViewById<CardView>(R.id.staff_directory_card_view).setOnClickListener(this)
        findViewById<CardView>(R.id.courses_card_view).setOnClickListener(this)
        findViewById<CardView>(R.id.social_media_card_view).setOnClickListener(this)
        findViewById<CardView>(R.id.email_card_view).setOnClickListener(this)
        findViewById<CardView>(R.id.admissions_card_view).setOnClickListener(this)
        findViewById<CardView>(R.id.exit_card_view).setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.staff_directory_card_view -> {
                val intent = Intent(this, DirectoryActivity::class.java)
                startActivity(intent)
            }
            R.id.courses_card_view -> {
                val intent = Intent(this, CourseActivity::class.java)
                startActivity(intent)
            }
            R.id.admissions_card_view -> {
                val intent = Intent(this, AdmissionsActivity::class.java)
                startActivity(intent)
            }
            R.id.social_media_card_view -> {
                    val intent = Intent(this, SocialMediaActivity::class.java)
                    startActivity(intent)
            }
            R.id.email_card_view -> {
                val intent = Intent(this, EmailActivity::class.java)
                startActivity(intent)
            }
            R.id.exit_card_view -> {
                finishAffinity()
            }
        }
    }
}