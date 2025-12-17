package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.bmi_button).setOnClickListener {
            startActivity(Intent(this, BMIActivity::class.java))
        }

        findViewById<Button>(R.id.meal_button).setOnClickListener {
            startActivity(Intent(this, MealPlanActivity::class.java))
        }

        findViewById<Button>(R.id.timer_button).setOnClickListener {
            startActivity(Intent(this, WorkoutTimerActivity::class.java))
        }

        findViewById<Button>(R.id.gallery_button).setOnClickListener {
            startActivity(Intent(this, ExerciseGalleryActivity::class.java))
        }

        findViewById<Button>(R.id.profile_button).setOnClickListener {
            val dialog = ProfileDialogFragment()
            dialog.show(supportFragmentManager, "ProfileDialog")
        }
    }
}
