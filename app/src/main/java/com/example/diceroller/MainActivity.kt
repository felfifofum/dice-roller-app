package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
                .show() // Make the toast call itself
//            val resultTextView: TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
            rollDice()

        }
        // Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        // Create instance of Dice called dice - give it 6 sides
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Show result of the roll on-screen
        val diceImage: ImageView = findViewById(R.id.imageView)

        //WHEN - method 1
//        val drawableResource = when (diceRoll) {
//            1 -> diceImage.setImageResource(R.drawable.dice_1)
//            2 -> diceImage.setImageResource(R.drawable.dice_2)
//            3 -> diceImage.setImageResource(R.drawable.dice_3)
//            4 -> diceImage.setImageResource(R.drawable.dice_4)
//            5 -> diceImage.setImageResource(R.drawable.dice_5)
//            else -> diceImage.setImageResource(R.drawable.dice_6)
//        }

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description for image each time dice is 'rolled'
        diceImage.contentDescription = diceRoll.toString()

//        //DICE 2
//        val dice2 = Dice(6)
//        val diceRoll2 = dice2.roll()
//        val resultTextView2: TextView = findViewById(R.id.textView2)
//        resultTextView2.text = diceRoll2.toString()
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}