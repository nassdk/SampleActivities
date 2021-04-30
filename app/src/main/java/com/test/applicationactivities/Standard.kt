package com.test.applicationactivities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Standard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standard)

        findViewById<MaterialButton>(R.id.singleTask).setOnClickListener {
            startActivity(Intent(this, SingleTask::class.java))
        }

        findViewById<MaterialButton>(R.id.singleTop).setOnClickListener {
            startActivity(Intent(this, SingleTop::class.java))
        }

        findViewById<MaterialButton>(R.id.singleInstance).setOnClickListener {
            startActivity(Intent(this, SingleInstance::class.java))
        }

        findViewById<MaterialButton>(R.id.standard).setOnClickListener {
            startActivity(Intent(this, Standard::class.java))
        }
    }
}