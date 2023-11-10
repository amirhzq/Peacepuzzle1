package com.example.peacepuzzle1

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


class CrsWrdActivityR2 : AppCompatActivity() {
    val correctLettersMap = mapOf(
        R.id.cell06 to 'r',
        R.id.cell08 to 's',


        R.id.cell11 to 'o',
        R.id.cell12 to 'n',
        R.id.cell13 to 'f',
        R.id.cell14 to 'i',
        R.id.cell15 to 'd',
        R.id.cell16 to 'e',
        R.id.cell17 to 'n',
        R.id.cell18 to 't',


        R.id.cell23 to 'r',
        R.id.cell26 to 's',
        R.id.cell28 to 'a',


        R.id.cell30 to 'j',
        R.id.cell31 to 'i',
        R.id.cell32 to 'v',
        R.id.cell33 to 'e',
        R.id.cell36 to 'p',
        R.id.cell38 to 'r',


        R.id.cell40 to 'o',
        R.id.cell43 to 'e',
        R.id.cell44 to 'n',
        R.id.cell45 to 'd',
        R.id.cell46 to 'e',
        R.id.cell47 to 'a',
        R.id.cell48 to 'r',


        R.id.cell50 to 'y',
        R.id.cell53 to 'd',
        R.id.cell56 to 'c',
        R.id.cell58 to 'y',


        R.id.cell60 to 'f',
        R.id.cell61 to 'a',
        R.id.cell62 to 'v',
        R.id.cell63 to 'o',
        R.id.cell64 to 'r',
        R.id.cell65 to 'i',
        R.id.cell66 to 't',
        R.id.cell67 to 'e',


        R.id.cell70 to 'u',
        R.id.cell73 to 'm',
        R.id.cell80 to 'l',
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crs_wrd_r2)
        Log.d("CrsWrdActivity2", "Activity started")


        val number1 = findViewById<TextView>(R.id.number1)
        number1.text = "1"
        val number2 = findViewById<TextView>(R.id.number2)
        number2.text = "2"
        val number3 = findViewById<TextView>(R.id.number3)
        number3.text = "3"
        val number4 = findViewById<TextView>(R.id.number4)
        number4.text = "4"
        val number5 = findViewById<TextView>(R.id.number5)
        number5.text = "5"
        val number6 = findViewById<TextView>(R.id.number6)
        number6.text = "6"
        val number7 = findViewById<TextView>(R.id.number7)
        number7.text = "7"




        val cell10 = findViewById<TextView>(R.id.cell10)
        cell10.text = "c"


        val horizontalClues = findViewById<TextView>(R.id.hor_clues)
        horizontalClues.text = "Horizontal Clues"
        val verticalClues = findViewById<TextView>(R.id.ver_clues)
        verticalClues.text = "Vertical Clues"


        // Initialize and set up the RecyclerView for horizontal clues
        val horizontalCluesRecyclerView =
            findViewById<RecyclerView>(R.id.horizontalCluesRecyclerView)
        horizontalCluesRecyclerView.layoutManager = LinearLayoutManager(this)
        horizontalCluesRecyclerView.adapter = MeaningsAdapter(createHorizontalCluesList())


        // Initialize and set up the RecyclerView for vertical clues
        val verticalCluesRecyclerView = findViewById<RecyclerView>(R.id.verticalCluesRecyclerView)
        verticalCluesRecyclerView.layoutManager = LinearLayoutManager(this)
        verticalCluesRecyclerView.adapter = MeaningsAdapter(createVerticalCluesList())


        setupAllCells()
    }


    private fun createHorizontalCluesList(): List<String> {
        val horizontalClues = listOf(
            "1. Walking tall and sure without any doubts.",
            "3. Energetically dancing to jazz tunes.",
            "5. To make oneself beloved or cherished.",
            "7. Most loved or preferred, like a best friend.",
        )
        return horizontalClues
    }


    private fun createVerticalCluesList(): List<String> {
        val verticalClues = listOf(
            "2. The joy of having no restrictions.",
            "3. Filled with happiness and delight.",
            "4. Deep admiration for someone's abilities or qualities.",
            "6. Resembling a twinkling night sky.",
        )
        return verticalClues
    }
    private fun setupTextWatcherForCell(cell: EditText, correctChar: Char) {
        cell.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No need to implement this
            }


            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // No need to implement this
            }


            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    // If the user enters the correct letter, color the cell green. Else, color it orange.
                    if (it.isNotEmpty() && it.toString().equals(correctChar.toString(), ignoreCase = true)) {
                        cell.setTextColor(Color.parseColor("#008000"))
                        checkForWin()
                    } else if (it.isNotEmpty()) {
                        cell.setTextColor(Color.parseColor("#eb9800"))
                    }
                }
            }
        })
    }
    private fun setupAllCells() {
        val cellIds = listOf(
            R.id.cell00, R.id.cell01, R.id.cell02, R.id.cell03, R.id.cell04,
            R.id.cell05, R.id.cell06, R.id.cell07, R.id.cell08,
            R.id.cell11, R.id.cell12, R.id.cell13, R.id.cell14, R.id.cell15,
            R.id.cell16, R.id.cell17, R.id.cell18, R.id.cell20, R.id.cell21,
            R.id.cell22, R.id.cell23, R.id.cell24, R.id.cell25, R.id.cell26,
            R.id.cell27, R.id.cell28, R.id.cell30, R.id.cell31, R.id.cell32,
            R.id.cell33, R.id.cell34, R.id.cell35, R.id.cell36, R.id.cell37,
            R.id.cell38, R.id.cell40, R.id.cell41, R.id.cell42, R.id.cell43,
            R.id.cell44, R.id.cell45, R.id.cell46, R.id.cell47, R.id.cell48,
            R.id.cell50, R.id.cell51, R.id.cell52, R.id.cell53, R.id.cell54,
            R.id.cell55, R.id.cell56, R.id.cell57, R.id.cell58, R.id.cell60,
            R.id.cell61, R.id.cell62, R.id.cell63, R.id.cell64, R.id.cell65,
            R.id.cell66, R.id.cell67, R.id.cell68, R.id.cell70, R.id.cell71,
            R.id.cell72, R.id.cell73, R.id.cell74, R.id.cell75, R.id.cell76,
            R.id.cell77, R.id.cell78, R.id.cell80, R.id.cell81, R.id.cell82,
            R.id.cell83, R.id.cell84, R.id.cell85, R.id.cell86, R.id.cell87,
            R.id.cell88
        )


        cellIds.forEach { cellId ->
            val cell = findViewById<EditText>(cellId)
            val correctChar = correctLettersMap[cellId] ?: ' '
            setupTextWatcherForCell(cell, correctChar)
        }
    }
    private fun checkForWin() {
        val allCellsCorrect = correctLettersMap.all { (cellId, correctChar) ->
            val cell = findViewById<EditText>(cellId)
            cell.text.toString().equals(correctChar.toString(), ignoreCase = true)
        }


        if (allCellsCorrect) {
            // Use the Activity's Context when making a Dialog
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Congratulations!")
            dialog.setMessage("You've completed all your daily crossword puzzles!")


            // Use a custom layout for AlertDialog to customize buttons
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.custom_finish_dialogue, null)
            dialog.setView(dialogView)


            val alertDialog = dialog.create()


            // Customize button from custom layout
            val buttonDone = dialogView.findViewById<Button>(R.id.buttonDone)


            // Set button color to be a shade of yellow with white text
            val yellowColor = Color.parseColor("#FFEB3B") // A shade of yellow that allows white text to be readable
            buttonDone.setBackgroundColor(yellowColor)
            buttonDone.setTextColor(Color.WHITE)
            buttonDone.text = "Done"


            // Set up button listener
            buttonDone.setOnClickListener {
                Log.d("CrsWrdActivity", "User clicked Done button")
                // Go back to home page (assuming MainActivity is your home page)
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP // Clears the activity stack
                startActivity(intent)
                alertDialog.dismiss() // Dismiss the dialog
            }


            // Show the AlertDialog
            alertDialog.show()
        }
    }
}
