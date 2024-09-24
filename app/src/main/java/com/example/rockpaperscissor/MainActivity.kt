package com.example.rockpaperscissor

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random


        class MainActivity : AppCompatActivity() {

            private lateinit var Result: TextView
            private lateinit var UserChoice: TextView
            private lateinit var AppChoice: TextView
            private lateinit var b1: Button
            private lateinit var b2: Button
            private lateinit var b3: Button

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                Result = findViewById(R.id.result)
                UserChoice = findViewById(R.id.userchoice)
                AppChoice = findViewById(R.id.appchoice)
                b1 = findViewById(R.id.rock)
                b2 = findViewById(R.id.paper)
                b3 = findViewById(R.id.scissors)

                b1.setOnClickListener { playGame("Rock") }
                b2.setOnClickListener { playGame("Paper") }
                b3.setOnClickListener { playGame("Scissors") }
            }

            private fun playGame(userChoice: String) {
                val appChoice = getAppChoice()
                UserChoice.text = "Your Choice: $userChoice"
                AppChoice.text = "App's Choice: $appChoice"
                Result.text = getResult(userChoice, appChoice)
            }

            private fun getAppChoice(): String {
                val choices = listOf("Rock", "Paper", "Scissors")
                return choices[Random.nextInt(choices.size)]
            }

            private fun getResult(userChoice: String, appChoice: String): String {
                return when {
                    userChoice == appChoice -> "It's a Draw!"
                    (userChoice == "Rock" && appChoice == "Scissors") ||
                            (userChoice == "Paper" && appChoice == "Rock") ||
                            (userChoice == "Scissors" && appChoice == "Paper") -> "You Win!"

                    else -> "You Lose!"
                }
            }
        }




