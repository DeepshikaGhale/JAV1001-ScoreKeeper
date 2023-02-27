package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //initialization
    private lateinit var decrease : ImageButton
    private lateinit var increase : ImageButton
    private lateinit var teamARadioGroup: RadioGroup
    private lateinit var teamBRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //connects xml and .kt file through view ids
        decrease = findViewById(R.id.decrease_btn)
        increase = findViewById(R.id.increase_btn)
        teamARadioGroup = findViewById(R.id.teamA_radio_grp)
        teamBRadioGroup = findViewById(R.id.teamB_radio_grp)

        //when minus button of team A is pressed
        decrease.setOnClickListener() { decrease() }

        //when plus button of team A is pressed
        increase.setOnClickListener() { increase() }

        //gives toast message with current radio button text for team A
        teamARadioGroup.setOnCheckedChangeListener(
            RadioGroup.OnCheckedChangeListener { _,
                                                 checkedId ->
                val radio: RadioButton = findViewById(checkedId)
                Toast.makeText(this,"Score of team A is :"+
                        " ${radio.text}",
                    Toast.LENGTH_SHORT).show()
            }
        )

        //gives toast message with current radio button text for team A
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