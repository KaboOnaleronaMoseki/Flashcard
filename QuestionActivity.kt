package com.example.hackquestions

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    lateinit var questionText: TextView
    lateinit var feedbackText: TextView

    var index = 0
    var score = 0

    val questions = arrayOf(
        "Putting phone in rice fixes water damage.",
        "Drinking water improves concentration.",
        "Cracking knuckles causes arthritis.",
        "Dark mode saves battery.",
        "Carrots improve night vision."
    )

    val answers = arrayOf(false, true, false, true, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)

        val hackButton = findViewById<Button>(R.id.hackButton)
        val mythButton = findViewById<Button>(R.id.mythButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        loadQuestion()

        hackButton.setOnClickListener { checkAnswer(true) }
        mythButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            index++
            if (index < questions.size) {
                loadQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("score", score)
                startActivity(intent)
            }
        }
    }

    fun loadQuestion() {
        questionText.text = questions[index]
        feedbackText.text = ""
    }

    fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            feedbackText.text = getString(R.string.correct)
            score++
        } else {
            feedbackText.text = getString(R.string.wrong)
        }
    }
}