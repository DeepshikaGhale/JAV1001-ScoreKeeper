package com.example.scorekeeper

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //initialization
    private lateinit var increaseBtnA : ImageButton
    private lateinit var decreaseBtnA : ImageButton
    private lateinit var increaseBtnB : ImageButton
    private lateinit var decreaseBtnB : ImageButton
    private lateinit var radioBtnGrp: RadioGroup
    private lateinit var teamAScore : EditText
    private lateinit var teamBScore : EditText

    //stores score of team A and B
    private var scoreA: Int = 0
    private var scoreB: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //retrieve data from local storage
        displayScore()

        //connects xml and .kt file through view ids
        increaseBtnA = findViewById(R.id.teamA_increase_btn)
        decreaseBtnA = findViewById(R.id.teamA_decrease_btn)
        increaseBtnB = findViewById(R.id.teamB_increase_btn)
        decreaseBtnB = findViewById(R.id.teamB_decrease_btn)
        radioBtnGrp = findViewById(R.id.radio_btn_grp)
        teamAScore = findViewById(R.id.teamA_score)
        teamBScore = findViewById(R.id.teamB_score)

        //get the selected radio button id and value
        val selectedRadioButton: RadioButton = findViewById(radioBtnGrp.checkedRadioButtonId)
        var scoreValue: Int = selectedRadioButton.text.toString().toInt()

        //set the initial value for
        teamAScore.setText(scoreA.toString())
        teamBScore.setText(scoreB.toString())

        //increases team A score
        increaseBtnA.setOnClickListener() {
            teamAIncrease(scoreValue)
            teamAScore.setText(scoreA.toString())
        }

        //decreases team A score
        decreaseBtnA.setOnClickListener() {
            teamADecrease(scoreValue)
            teamAScore.setText(scoreA.toString())
        }

        //increases team B score
        increaseBtnB.setOnClickListener() {
            teamBIncrease(scoreValue)
            teamBScore.setText(scoreB.toString())
        }

        //decreases team B score
        decreaseBtnB.setOnClickListener() {
            teamBDecrease(scoreValue)
            teamBScore.setText(scoreB.toString())
        }

        //gets the currently selected radio button value
        radioBtnGrp.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { _,
                                                 checkedId ->

                val score: RadioButton = findViewById(checkedId)
                scoreValue = score.text.toString().toInt()
            }
        )
    }

    //adding menu to action bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.score_keeper_menu, menu)
        return true
    }

    //add action to menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.about_id -> {
                Toast.makeText(this, "This is about menu item", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.settings_id -> {
                settings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun settings(){
        val intent = Intent(this, SettingsActivity::class.java)
        intent.putExtra("scoreA", scoreA)
        intent.putExtra("scoreB", scoreB)
        Log.d("scores", "$scoreA $scoreB")
        applicationContext.startActivity(intent)
    }

    //increases team A score
    private fun teamAIncrease(score: Int){
        scoreA += score
        message('A')
    }

    //decreases team A score
    private fun teamADecrease(score: Int){
        if (scoreA >= score){
            scoreA -= score
            message('A')
        }else{
            Toast.makeText(this, "Please select different score value.", Toast.LENGTH_SHORT).show()
        }

    }

    //increases team B score
    private fun teamBIncrease(score: Int){
        scoreB += score
        message('B')
    }

    //decreases team B score
    private fun teamBDecrease(score: Int){
        if (scoreB >= score){
            scoreB -= score
            message('B')
        }else{
            Toast.makeText(this, "Please select different score value.", Toast.LENGTH_SHORT).show()
        }
    }

    //notifies user about score update
    private fun message(team: Char){
        Toast.makeText(this, "Score for team $team has been updates successfully.", Toast.LENGTH_SHORT).show()
    }

    //read data from local storage
    private fun displayScore(){

            val sharedPref = getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)
            val editor = sharedPref.all

            scoreA = sharedPref.getInt("scoreA", 0)
            scoreB = sharedPref.getInt("scoreB", 0)


            Log.d("alldata", editor.size.toString())

    }
}