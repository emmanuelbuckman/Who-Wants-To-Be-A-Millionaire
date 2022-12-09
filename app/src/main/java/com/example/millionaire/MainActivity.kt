package com.example.millionaire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

private const val QUESTIONS = "https://github.com/aaronnech/Who-Wants-to-Be-a-Millionaire/blob/master/questions.json"
private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    lateinit var question: TextView
    lateinit var answer1: TextView
    lateinit var answer2: TextView
    lateinit var answer3: TextView
    lateinit var answer4: TextView
    lateinit var subBtn: Button

    lateinit var startBtn: Button
    lateinit var userName: EditText

    lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn = findViewById(R.id.startBtn)
        userName = findViewById(R.id.userName)

        startBtn.setOnClickListener{

            if(userName.text.toString().isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, QuestionsActivity::class.java)
                startActivity(intent)
                finish()
            }

        }
    }
}