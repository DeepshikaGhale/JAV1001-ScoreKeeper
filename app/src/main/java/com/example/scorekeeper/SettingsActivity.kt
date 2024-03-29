package com.example.scorekeeper

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.scorekeeper.databinding.ActivityMainBinding
import com.example.scorekeeper.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //enable back button
        supportActionBar?.apply {
            title = "Settings"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        //set value from intent
        val scoreA = intent.getIntExtra("scoreA", 0)
        val scoreB = intent.getIntExtra("scoreB", 0)


        binding.switchId.setOnClickListener(){
            val switch_state =  binding.switchId.isChecked
            //switch is true
            if(switch_state){
                storeScore(scoreA, scoreB)
                Toast.makeText(this, "Score has been saved", Toast.LENGTH_SHORT).show()
            }
            //switch if false
            else{
                removeScore()
                Toast.makeText(this, "Score has been removed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //shared preference]
    //add data to local storage
    private fun storeScore(scoreA: Int, scoreB: Int){
        //initialize shared preferences
        val sharedPref = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        //store data
        editor.putInt("scoreA", scoreA)
        editor.putInt("scoreB", scoreB)
        editor.apply()
    }

    //remove data from local storage
    private fun removeScore(){
        val sharedPref = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.remove("scoreA")
        editor.remove("scoreB")
        editor.apply()
    }
}