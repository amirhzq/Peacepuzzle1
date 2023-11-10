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


class CrsWrdActivity : AppCompatActivity() {
    val correctLettersMap = mapOf(
        R.id.cell01 to 'm',
        R.id.cell02 to 'a',
        R.id.cell03 to 'z',
        R.id.cell04 to 'e',
        R.id.cell05 to 'm',
        R.id.cell06 to 'e',
        R.id.cell07 to 'n',
        R.id.cell08 to 't',


        R.id.cell23 to 'p',
        R.id.cell24 to 'a',
        R.id.cell25 to 'r',
        R.id.cell26 to 'a',
        R.id.cell27 to 'd',
        R.id.cell28 to 'e',


        R.id.cell30 to 'n',
        R.id.cell31 to 'i',
        R.id.cell32 to 'c',
        R.id.cell33 to 'e',


        R.id.cell45 to 'c',
        R.id.cell46 to 'a',
        R.id.cell47 to 'l',
        R.id.cell48 to 'm',


        R.id.cell51 to 'e',
        R.id.cell52 to 'x',
        R.id.cell53 to 'c',
        R.id.cell54 to 'e',
        R.id.cell55 to 'l',


        R.id.cell75 to 's',
        R.id.cell76 to 'o',
        R.id.cell77 to 'f',
        R.id.cell78 to 't',


        //Vertical Words Section
        //Leftover letters to spell miracle, motive, nod, peace, mint
        R.id.cell11 to 'o',
        R.id.cell15 to 'i',
        R.id.cell17 to 'o',
        R.id.cell35 to 'a',


        R.id.cell21 to 't',


        R.id.cell41 to 'v',
        R.id.cell43 to 'a',


        R.id.cell58 to 'i',


        R.id.cell63 to 'e',
        R.id.cell65 to 'e',
        R.id.cell68 to 'n',
    )
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crosswordsr1)
        Log.d("CrsWrdActivity", "Activity started")


        val cell00 = findViewById<TextView>(R.id.cell00)


        val number01 = findViewById<TextView>(R.id.number01)
        number01.text = "2"
        val number05 = findViewById<TextView>(R.id.number05)
        number05.text = "4"
        val number07 = findViewById<TextView>(R.id.number07)
        number07.text = "6"
        val number23 = findViewById<TextView>(R.id.number23)
        number23.text = "3"
        val number30 = findViewById<TextView>(R.id.number30)
        number30.text = "5"
        val number45 = findViewById<TextView>(R.id.number45)
        number45.text = "7"
        val number48 = findViewById<TextView>(R.id.number48)
        number48.text = "8"
        val number51 = findViewById<TextView>(R.id.number51)
        number51.text = "9"
        val number75 = findViewById<TextView>(R.id.number75)
        number75.text = "10"




        val number00 = findViewById<TextView>(R.id.number00)
        number00.text = "1"
        cell00.text = "a"


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
            "1. Astonishment from witnessing a magician's surprising act.",
            "3. Public celebration with music and floats.",
            "5. Agreeable and kind in social interactions.",
            "7. A state of peace and tranquility; free from agitation.",
            "9. Achieve superior performance; stand out greatly.",
            "10. Gentle to touch, like cotton.",
        )
        return horizontalClues
    }


    private fun createVerticalCluesList(): List<String> {
        val verticalClues = listOf(
            "2. Driving reason behind a person's actions.",
            "3. Harmony prevailing without any conflict.",
            "4. Events causing wonder, often seen as divine.",
            "6. Simple gesture signifying agreement or acknowledgment.",
            "8. Refreshing herb; symbolizes freshness and coolness.",
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
                        cell.setTextColor(Color.parseColor("#FA0000"))
                    }
                }
            }
        })
    }
    private fun setupAllCells() {
        val cellIds = listOf(
            R.id.cell01, R.id.cell02, R.id.cell03, R.id.cell04,
            R.id.cell05, R.id.cell06, R.id.cell07, R.id.cell08, R.id.cell10,
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
            dialog.setMessage("You've completed the puzzle! Would you like to continue to the next round?")


            // Use a custom layout for AlertDialog to customize buttons
            val inflater = this.layoutInflater
            val dialogView = inflater.inflate(R.layout.custom_dialogue, null)
            dialog.setView(dialogView)


            val alertDialog = dialog.create()


            // Get buttons from custom layout
            val buttonYes = dialogView.findViewById<Button>(R.id.buttonYes)
            val buttonNo = dialogView.findViewById<Button>(R.id.buttonNo)


            // Set button colors
            buttonYes.setBackgroundColor(Color.parseColor("#008000"))
            buttonYes.setTextColor(Color.WHITE)
            buttonNo.setBackgroundColor(Color.parseColor("#eb9800"))
            buttonNo.setTextColor(Color.WHITE)


            // Set up button listeners
            buttonYes.setOnClickListener {
                Log.d("CrsWrdActivity", "User clicked Yes button")
                //Go to CrsWrdActivityR2
                val intent = Intent(this, CrsWrdActivityR2::class.java)
                startActivity(intent)
                alertDialog.dismiss() // Dismiss the dialog
            }


            buttonNo.setOnClickListener {
                Log.d("CrsWrdActivity", "User clicked No button")
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
class MeaningsAdapter(private val meanings: List<String>) : RecyclerView.Adapter<MeaningsAdapter.MeaningViewHolder>() {
    class MeaningViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeaningViewHolder {
        val textView = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        return MeaningViewHolder(textView)
    }


    override fun onBindViewHolder(holder: MeaningViewHolder, position: Int) {
        holder.textView.text = meanings[position]
    }


    override fun getItemCount() = meanings.size
}
