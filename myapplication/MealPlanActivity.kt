package com.example.myapplication
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MealPlanActivity : AppCompatActivity() {

    private lateinit var mealRecyclerView: RecyclerView
    private lateinit var mealAdapter: MealAdapter
    private lateinit var mealList: List<Meal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal_plan)

        mealRecyclerView = findViewById(R.id.mealRecyclerView)
        mealRecyclerView.layoutManager = LinearLayoutManager(this)

        mealList = listOf(
            Meal("Breakfast Smoothie", "Banana, almond milk, oats, and peanut butter."),
            Meal("Grilled Chicken Salad", "Lettuce, grilled chicken, cucumber, olive oil."),
            Meal("Tuna Sandwich", "Whole grain bread, tuna, lettuce, and tomato."),
            Meal("Protein Bowl", "Brown rice, quinoa, chickpeas, and veggies."),
            Meal("Greek Yogurt Snack", "Greek yogurt with honey and nuts.")
        )

        mealAdapter = MealAdapter(mealList)
        mealRecyclerView.adapter = mealAdapter
    }
}
