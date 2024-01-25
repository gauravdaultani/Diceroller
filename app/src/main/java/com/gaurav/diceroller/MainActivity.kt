package com.gaurav.diceroller

import android.annotation.SuppressLint
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.core.graphics.drawable.toDrawable

class MainActivity : AppCompatActivity() {
    lateinit var RandomButton: Button
    lateinit var SettoButton: Button
    lateinit var DiceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RandomButton = findViewById(R.id.button3)
        SettoButton=findViewById(R.id.button2)
        DiceImage=findViewById((R.id.imageView))

        val dice_sound: MediaPlayer = MediaPlayer.create(this, R.raw.dice_sound)

        RandomButton.setOnClickListener{
            val random=(1..6).random()
            val drawable=when(random){
                1->R.drawable.dice_1
                2->R.drawable.dice_2
                3->R.drawable.dice_3
                4->R.drawable.dice_4
                5->R.drawable.dice_5
                6->R.drawable.dice_6
                else->
                {R.drawable.dice_random}
            }
            dice_sound.start()
            DiceImage.setImageResource(drawable)
        }

        // This resets the diceroller

        SettoButton.setOnClickListener {
            DiceImage.setImageResource(R.drawable.dice_random)
        }
    }
}
