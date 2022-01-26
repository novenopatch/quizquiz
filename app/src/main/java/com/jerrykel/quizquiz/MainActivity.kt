package com.jerrykel.quizquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonPlays:Button = findViewById(R.id.buttonPlays)

        buttonPlays.setOnClickListener{
            startActivity( Intent(this,QuizActivity::class.java));
        }
    }




}


