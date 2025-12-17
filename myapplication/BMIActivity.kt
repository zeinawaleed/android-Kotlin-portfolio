package com.example.myapplication


import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BMIActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        val weight = findViewById<EditText>(R.id.weight_input)
        val height = findViewById<EditText>(R.id.height_input)
        val result = findViewById<TextView>(R.id.bmi_result)
        val calcButton = findViewById<Button>(R.id.calculate_button)

        calcButton.setOnClickListener {
            val w = weight.text.toString().toFloatOrNull()
            val h = height.text.toString().toFloatOrNull()

            if (w != null && h != null && h > 0) {
                val bmi = w / (h * h)
                val status = when {
                    bmi < 18.5 -> "Underweight"
                    bmi < 25 -> "Normal"
                    bmi < 30 -> "Overweight"
                    else -> "Obese"
                }
                result.text = "BMI: %.2f\nStatus: %s".format(bmi, status)
            } else {
                result.text = "Enter valid weight and height!"
            }
        }
    }
}
