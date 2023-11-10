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
        var crosswordCard = findViewById<androidx.cardview.widget.CardView>(R.id.puzzleCard)
        var meditationCard = findViewById<androidx.cardview.widget.CardView>(R.id.meditationTimerCard)

        exerciseCard.setOnClickListener()
        {
            openExerciseTimerActivity()
        }
        treeCard.setOnClickListener()
        {
            opentheTreeActivity()
        }
        crosswordCard.setOnClickListener()
        {
            openPuzzleActivity()
        }
        meditationCard.setOnClickListener(){
            openMeditationTimerActivity()
        }
    }

    public fun openExerciseTimerActivity()
    {
        startActivity(Intent(this@MainActivity, exerciseTimer::class.java))
    }

    public fun opentheTreeActivity() {
        startActivity(Intent(this@MainActivity, theTree::class.java))
    }

    public fun openPuzzleActivity(){
        startActivity(Intent(this@MainActivity,CrsWrdActivity::class.java))
    }

    public fun openMeditationTimerActivity(){
        startActivity((Intent(this@MainActivity,MeditationTimer::class.java)))
    }
}