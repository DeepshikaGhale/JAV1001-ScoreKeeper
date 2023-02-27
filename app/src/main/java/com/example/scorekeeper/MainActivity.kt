package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var decrease : ImageButton
    private lateinit var increase : ImageButton
    private lateinit var teamARadioGroup: RadioGroup
    private lateinit var teamBRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decrease = findViewById(R.id.decrease_btn)
        increase = findViewById(R.id.increase_btn)
        teamARadioGroup = findViewById(R.id.teamA_radio_grp)
        teamBRadioGroup = findViewById(R.id.teamB_radio_grp)

        decrease.setOnClickListener() { decrease() }
        increase.setOnClickListener() { increase }

        teamARadioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { _,
                                                 checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(this,"Score of team A is :"+
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()
            }
        )

        teamBRadioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { _,
                                                 checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(this,"Score of team B is :"+
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()
            }
        )
        }



    private fun increase(){
        Toast.makeText(this, "Score will be increased.", Toast.LENGTH_SHORT).show()
    }

    private fun decrease(){
        Toast.makeText(this, "Score will be decreased.", Toast.LENGTH_SHORT).show()
    }
}