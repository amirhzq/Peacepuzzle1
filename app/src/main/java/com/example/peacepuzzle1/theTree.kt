package com.example.peacepuzzle1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class theTree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_the_tree)

        val messageInput:EditText=findViewById(R.id.ventMessage)
        val sendTreeButton:Button =findViewById(R.id.sendTreeButton)

        sendTreeButton.setOnClickListener {
            val message=messageInput.text.toString()
//            val toast = Toast.makeText(this,message,Toast.LENGTH_SHORT)
//            toast.setGravity(Gravity.CENTER,-200,0)
//            toast.show()
            Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        }
    }
}