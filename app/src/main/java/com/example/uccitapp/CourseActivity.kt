package com.example.uccitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CourseActivity : AppCompatActivity()  {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CourseAdapter
    private lateinit var databaseHelper: CourseDBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)

        recyclerView = findViewById(R.id.recycler_view)
        adapter = CourseAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        databaseHelper = CourseDBHelper(this)
        adapter.setCourses(databaseHelper.getAllCourses())
        addCourses()
    }

    private fun addCourses() {
        val courses = listOf(
            Course(
                "MTH002",
                "Core Mathematics",
                3,
                "This course is open-entry. There are no prerequisites for entry.",
                "The course sets out the basics of mathematical principles and moves into more advanced applications which will equip students to effectively cope with other mathematics courses they will encounter. Topics include arithmetic operations, and basic statistics, trigonometry, and graphs. This course is open-entry."
            ),
            Course(
                "ITT201",
                "Data Communication & Network I",
                3,
                "This course is open-entry. There are no prerequisites for entry.",
                "This introductory course in Data Communications and Networks is designed to give students an understanding of networks and how they can be used in organizations to increase efficiency. It will also introduce IP addressing and subnets and briefly look at security issues in networking.\n" +
                        "\n"
            ),
            Course("ITT420",
                "Mobile Application Development",
                3,
                "This course is open-entry. There are no prerequisites for entry.",
                "This course will introduce students to the core conceptual skills and basic practices needed to develop an Android application.  The course will focus on how the application communicates to retrieve, store and interact with other devices on any android platform. Topics will include memory management, user interface design, user interface building, input methods, data handling, and network techniques."
            ),
            Course(
                "ITT313",
                "Fundamentals of Computer Graphics Design",
                3,
                "Prerequisite: Computer Information Essentials",
                "This foundation course explores the essential knowledge students need to create, design and edit images in any graphical design software.  Students will use the concepts explored in this course in advertising, graphic design, web design, illustration, broadcast design, photography and game design and many others. Assessment will be based on technical understanding and creative use of resources for the completion of various assignments using Photoshop or Illustrator and InDesign."
                ),
            Course(
                "ITT200",
                "Object Oriented Programming using C++",
                3,
                "There are no prerequisites for entry.",
                "This course aims to broaden the student's knowledge of concepts and features of an object-oriented programming language. Students will be required to use these concepts to design solutions for real world problems."
                ),
            Course(
                "ITT208",
                "Internet Authoring I",
                3,
                "There are no prerequisites for entry",
                "This introductory course in Internet Authoring will introduce students to the tools needed to develop and publish Web Sites. At the end of this course, students should be able to comfortably design, develop, and publish their site on the Internet. Students will also be exposed to selected internet authoring tools to develop and publish web pages."
                ),
            Course(
                "ITT216",
                "Computer Essential & Troubleshooting II",
                3,
                "Computer Essentials and Troubleshooting I",
                " This introductory course in computer troubleshooting and repairs is designed to give students hands-on experience in diagnosing and solving some of the common hardware and software problems that can occur during the normal usage of a computer."
                ),
            Course(
                    "ITT203",
                    "Data Structure and File Management I",
                    3,
                    "There are no prerequisites for entry",
                    "This course will introduce basic algorithms and data structures in computer science.  It will also introduce students to the mathematical analysis of algorithms, and provide efficient programming techniques. "
                ),
            Course(
                    "ITT116",
                    "Computer Essentials and Troubleshooting I",
                    3,
                    "Computer Information Essentials",
                    "This course is aim to provide students with the basic functionality of the operating system and troubleshooting methodology, practice proper safety procedures and improve their skills in PC support and administration. By completing this course, students will also be assisted in the preparation of the technical support qualifications, CompTIA Core 1 exam."
                ),
            Course(
                    "ITT305",
                    "System Analysis and Design I",
                    3,
                    "There are no prerequisites for entry",
                    "This course covers the design of information systems and takes students right through to object oriented systems analysis and design using UML. The course will explore all aspects of the systems development life cycle (SDLC). The classes will use case studies to give students a practical sense of systems analysis and design and to introduce the concepts, methodologies, tools and techniques that can be used to develop systems."
                )

            )
        if (courses.isNotEmpty()) {
            val existingCourses = databaseHelper.getAllCourses().map { it.code }
            val newCourses = courses.filter { it.code !in existingCourses }
            newCourses.forEach { databaseHelper.addCourse(it) }
            adapter.setCourses(databaseHelper.getAllCourses())
        }
    }
}

