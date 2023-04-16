package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.scorekeeper.databinding.ActivityMainBinding
import com.example.scorekeeper.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.apply {
            title = "Settings"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val scoreA = intent.getIntExtra("scoreA", 0)
        val scoreB = intent.getIntExtra("scoreB", 0)

        binding.switchId.setOnClickListener(){
            val switch =  binding.switchId.isChecked
            Log.d("switch_state", switch.toString())
        }
    }
}