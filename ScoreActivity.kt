package com.example.hackquestions

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scoreText = findViewById<TextView>(R.id.scoreText)

        val score = intent.getIntExtra("score", 0)

        scoreText.text = getString(R.string.score_format, score, 5)
    }
}