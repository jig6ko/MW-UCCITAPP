package com.example.uccitapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class SocialMediaActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)

        // Set up click listeners for each social media link
        val facebookLink = findViewById<LinearLayout>(R.id.facebook_link)
        facebookLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/uccjamaica"))
            startActivity(intent)
        }

        val twitterLink = findViewById<LinearLayout>(R.id.twitter_link)
        twitterLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/uccjamaica"))
            startActivity(intent)
        }

        val instagramLink = findViewById<LinearLayout>(R.id.instagram_link)
        instagramLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/uccjamaica?igshid=YmMyMTA2M2Y="))
            startActivity(intent)
        }

        val youtubeLink = findViewById<LinearLayout>(R.id.youtube_link)
        youtubeLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/uccjamaica"))
            startActivity(intent)
        }

        val linkedinLink = findViewById<LinearLayout>(R.id.linkedin_icon_xml)
        linkedinLink.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/uccjamaica/"))
            startActivity(intent)
        }
    }
}