package com.example.peacepuzzle1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickListener();
    }

    public fun clickListener(){
        var exerciseCard = findViewById<androidx.cardview.widget.CardView>(R.id.exerciseCard);
        var treeCard = findViewById<androidx.cardview.widget.CardView>(R.id.theTreeCard)

        exerciseCard.setOnClickListener()
        {
            openExerciseTimerActivity()
        }
        treeCard.setOnClickListener(){
            opentheTreeActivity()
        }
    }

    public fun openExerciseTimerActivity()
    {
        startActivity(Intent(this@MainActivity, exerciseTimer::class.java))
    }

    public fun opentheTreeActivity() {
        startActivity(Intent(this@MainActivity, theTree::class.java))
    }

}