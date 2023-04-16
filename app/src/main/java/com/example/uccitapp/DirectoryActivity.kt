package com.example.uccitapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Member

class DirectoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_directory)


        val memberList = listOf(
            DirectoryItem(
                "Natalie Rose HOD",
                "ithod@ucc.edu.jm",
                "1-876-339-0961",
                R.drawable.portrait___rose
            ),
            DirectoryItem(
                "Bryanna Chang",
                "itprogrammeofficer2@ucc.edu.jm",
                "876-802-4572",
                R.drawable.mschang
            ),
            DirectoryItem(
                "Otis Osbourne",
                "itfaculty@ucc.edu.jm",
                "1-876-906-3000",
                R.drawable.unnamed
            ),
            DirectoryItem(
                "Neil Williams",
                "itlecturer@ucc.edu.jm",
                "1-876-906-3000",
                R.drawable.neilwilliams
            ),
            DirectoryItem(
                "Jesica Campbell",
                "Jtcampbell@faculty.ucc.edu.jm",
                "1-876-906-3000",
                R.drawable.miss_jesica_campbell
            ),
            DirectoryItem(
                "Ricardo Reid",
                "itprogrammeofficer3@ucc.edu.jm",
                "876-548-0629",
                R.drawable.user
            )
        )

        // create an adapter and set it to the RecyclerView
        val directoryRecyclerView: RecyclerView = findViewById(R.id.directoryRecyclerView)
        directoryRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = DirectoryAdapter(memberList)
        directoryRecyclerView.adapter = adapter

    }
}