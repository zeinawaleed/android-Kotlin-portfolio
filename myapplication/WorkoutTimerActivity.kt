package com.example.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WorkoutTimerActivity : AppCompatActivity() {

    private lateinit var timerTextView: TextView
    private lateinit var startButton: Button
    private lateinit var resetButton: Button
    private var countDownTimer: CountDownTimer? = null
    private var timeLeftInMillis: Long = 60000 // 1 minute

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_timer)

        timerTextView = findViewById(R.id.timerTextView)
        startButton = findViewById(R.id.startButton)
        resetButton = findViewById(R.id.resetButton)

        updateTimerText()

        startButton.setOnClickListener {
            startTimer()
        }

        resetButton.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        countDownTimer?.cancel() // Prevent multiple timers
        countDownTimer = object : CountDownTimer(timeLeftInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeftInMillis = millisUntilFinished
                updateTimerText()
            }

            override fun onFinish() {
                timerTextView.text = "Done!"
            }
        }.start()
    }

    private fun resetTimer() {
        countDownTimer?.cancel()
        timeLeftInMillis = 60000
        updateTimerText()
    }

    private fun updateTimerText() {
        val minutes = (timeLeftInMillis / 1000) / 60
        val seconds = (timeLeftInMillis / 1000) % 60
        timerTextView.text = String.format("%02d:%02d", minutes, seconds)
    }
}
