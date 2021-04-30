package com.test.applicationactivities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder
import com.google.android.material.button.MaterialButton

class RouterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<MaterialButton>(R.id.createTask).setOnClickListener {
            val taskStackBuilder = TaskStackBuilder.create(this)
                .addNextIntent(Intent(this, Standard::class.java))
                .addNextIntent(Intent(this, Standard::class.java))
                .addNextIntent(Intent(this, Standard::class.java))
            taskStackBuilder.startActivities()
        }

        /**
        Case 1:
        Suppose you have A, B and C activities and your activity D has “launch mode = singleTask”.
        Now you launching activity D -

        State of Activity Stack before launch D
        A -> B -> C

        State of Activity Stack after launch D activity
        A -> B -> C -> D (Here D launch as usual)

        Case 2:
        Suppose you have A, B, C and D activities and your activity B has “launch mode = singleTask”.
        Now you again launching activity B-

        State of Activity Stack before launch D
        A -> B -> C -> D

        State of Activity Stack after launch B activity
        A -> B (Here old instance gets called and intent data route through onNewIntent() callback)

        Also notice that C and D activities get destroyed here.
         */
        findViewById<MaterialButton>(R.id.singleTask).setOnClickListener {
            startActivity(Intent(this, SingleTask::class.java))
        }


        /**
        Case 1:
        Suppose you have A, B and C activities and your activity D has “launch mode = singleTop”.
        Now you launching activity D -

        State of Activity Stack before launch D
        A -> B -> C
        State of Activity Stack after launch D activity
        A -> B -> C -> D (Here D launch as usual)

        Case 2:
        Suppose you have A, B, C and D activities and your activity D has “launch mode = singleTop”.
        Now you again launching activity D -

        State of Activity Stack before launch D
        A -> B -> C -> D

        State of Activity Stack after launch D activity
        A -> B -> C -> D (Here old instance gets called and intent data route through onNewIntent() callback)

         */
        findViewById<MaterialButton>(R.id.singleTop).setOnClickListener {
            startActivity(Intent(this, SingleTop::class.java))
        }


        /**
        Case 1:
        Suppose you have A, B and C activities and your activity D has “launch mode = singleInstance”.

        Now you launching activity D -
        State of Activity Stack before launch D
        A -> B -> C

        State of Activity Stack after launch D activity
        Task1 — A -> B -> C
        Task2 — D (here D will be in different task)

        Now if you continue this and start E and D then Stack will look like-
        Task1 — A -> B -> C -> E
        Task2 — D
        Case 2:
        Suppose you have A, B, C activities in one task and activity D is in another task with “launch mode = singleInstance”.
        Now you again launching activity D-

        State of Activity Stack before launch D
        Task1 — A -> B -> C
        Task2 — D

        State of Activity Stack after launch B activity
        Task1 — A -> B -> C
        Task2 — D (Here old instance gets called and intent data route through onNewIntent() callback)
         */
        findViewById<MaterialButton>(R.id.singleInstance).setOnClickListener {
            startActivity(Intent(this, SingleInstance::class.java))
        }


        /**
        State of Activity Stack before launch B
        A -> B -> C -> D
        State of Activity Stack after launch B
        A -> B -> C -> D -> B
         */
        findViewById<MaterialButton>(R.id.standard).setOnClickListener {
            startActivity(Intent(this, Standard::class.java))
        }
    }
}