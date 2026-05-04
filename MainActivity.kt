package com.example.hackquestions

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var welcomeLayout: LinearLayout
    lateinit var questionLayout: LinearLayout
    lateinit var scoreLayout: LinearLayout

    lateinit var questionText: TextView
    lateinit var feedbackText: TextView
    lateinit var scoreText: TextView

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

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeLayout = findViewById(R.id.welcomeLayout)
        questionLayout = findViewById(R.id.questionLayout)
        scoreLayout = findViewById(R.id.scoreLayout)

        questionText = findViewById(R.id.questionText)
        feedbackText = findViewById(R.id.feedbackText)
        scoreText = findViewById(R.id.scoreText)

        val startButton = findViewById<Button>(R.id.startButton)
        val hackButton = findViewById<Button>(R.id.hackButton)
        val mythButton = findViewById<Button>(R.id.mythButton)
        val nextButton = findViewById<Button>(R.id.nextButton)
        val reviewButton = findViewById<Button>(R.id.reviewButton)

        startButton.setOnClickListener {
            welcomeLayout.visibility = View.GONE
            questionLayout.visibility = View.VISIBLE
            loadQuestion()
        }

        hackButton.setOnClickListener { checkAnswer(true) }
        mythButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            index++
            if (index < questions.size) {
                loadQuestion()
            } else {
                showScore()
            }
        }

        reviewButton.setOnClickListener {
            index = 0
            score = 0
            scoreLayout.visibility = View.GONE
            welcomeLayout.visibility = View.VISIBLE
        }
    }

    fun loadQuestion() {
        questionText.text = questions[index]
        feedbackText.text = ""
    }

    @SuppressLint("SetTextI18n")
    fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[index]) {
            feedbackText.text = "Correct!"
            score++
        } else {
            feedbackText.text = "Wrong!"
        }
    }

    @SuppressLint("SetTextI18n")
    fun showScore() {
        questionLayout.visibility = View.GONE
        scoreLayout.visibility = View.VISIBLE
        scoreText.text = "Your Score: $score / ${questions.size}"
    }
}