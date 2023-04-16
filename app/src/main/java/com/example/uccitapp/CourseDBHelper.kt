package com.example.uccitapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.provider.SyncStateContract.Helpers.insert

class CourseDBHelper (context: Context) : SQLiteOpenHelper(context, "courses.db", null, 1) {

    companion object {
        const val TABLE_NAME = "courses"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE $TABLE_NAME (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "code TEXT, " +
                    "name TEXT, " +
                    "credits INTEGER, " +
                    "prerequisites TEXT, " +
                    "description TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addCourse(course: Course): Boolean {
        val values = ContentValues().apply {
            put("code", course.code)
            put("name", course.name)
            put("credits", course.credits)
            put("prerequisites", course.prerequisites)
            put("description", course.description)
        }

        return try {
            val result = writableDatabase.use { db ->
                db.insert(TABLE_NAME, null, values)
            }
            result != -1L
        } catch (e: SQLiteException) {
            // handle the exception
            false
        }
    }

    @SuppressLint("Range")
    fun getAllCourses(): List<Course> {
        val courses = mutableListOf<Course>()
        var cursor: Cursor? = null
        try {
            cursor = readableDatabase.rawQuery("SELECT * FROM $TABLE_NAME", null)
            if (cursor.moveToFirst()) {
                do {
                    val code = cursor.getString(cursor.getColumnIndex("code"))
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val credits = cursor.getInt(cursor.getColumnIndex("credits"))
                    val prerequisites = cursor.getString(cursor.getColumnIndex("prerequisites"))
                    val description = cursor.getString(cursor.getColumnIndex("description"))
                    courses.add(Course(code, name, credits, prerequisites, description))
                } while (cursor.moveToNext())
            }
        } catch (ex: Exception) {
            // handle the exception
        } finally {
            cursor?.close()
        }
        return courses
    }
}