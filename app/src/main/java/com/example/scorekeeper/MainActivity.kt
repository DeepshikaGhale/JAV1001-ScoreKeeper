package com.example.scorekeeper

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var decrease : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         decrease = findViewById(R.id.decrease_btn)

        decrease.setOnClickListener(){
            printData()
            print("This is message")
        }

    }

    fun printData(){
        Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
    }
}