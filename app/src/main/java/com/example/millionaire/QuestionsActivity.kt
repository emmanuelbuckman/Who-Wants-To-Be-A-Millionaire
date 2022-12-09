package com.example.millionaire

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var progressBar: ProgressBar
    lateinit var tvProgress: TextView
    lateinit var questiontv: TextView

    private var mCurrentPos: Int = 1
    private var mQuestionsList: ArrayList<Question>? = Constants.getQuestions()
    private var mSelected: Int = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        val optionOne = findViewById<TextView>(R.id.optionOne)
        val optionTwo = findViewById<TextView>(R.id.optionTwo)
        val optionThree = findViewById<TextView>(R.id.optionThree)
        val optionZero = findViewById<TextView>(R.id.optionZero)

        optionZero.setOnClickListener(this)
        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)

        val subBtn = findViewById<Button>(R.id.subBtn)
        subBtn.setOnClickListener(this)

    }

    private fun setQuestion(){
        val subBtn = findViewById<Button>(R.id.subBtn)


        val question = mQuestionsList!!.get((mCurrentPos-1))

        defaultOptionsView()

        if(mCurrentPos == mQuestionsList!!.size){
            subBtn.text = "FINISH"
        }else{
            subBtn.text = "SUBMIT"
        }

        progressBar= findViewById(R.id.progressBar)
        progressBar.progress = mCurrentPos

        tvProgress = findViewById(R.id.tvProgress)
        tvProgress.text = "$mCurrentPos"

        questiontv = findViewById(R.id.question)
        questiontv.text = question!!.question
        val optionOne = findViewById<TextView>(R.id.optionOne)
        val optionTwo = findViewById<TextView>(R.id.optionTwo)
        val optionThree = findViewById<TextView>(R.id.optionThree)
        val optionZero = findViewById<TextView>(R.id.optionZero)

        optionZero.text = question.optionZero
        optionOne.text = question.optionOne
        optionTwo.text = question.optionTwo
        optionThree.text = question.optionThree
    }

    private fun defaultOptionsView(){
        val optionOne = findViewById<TextView>(R.id.optionOne)
        val optionTwo = findViewById<TextView>(R.id.optionTwo)
        val optionThree = findViewById<TextView>(R.id.optionThree)
        val optionZero = findViewById<TextView>(R.id.optionZero)

        val options = ArrayList<TextView>()
        options.add(0, optionZero)
        options.add(1, optionOne)
        options.add(2, optionTwo)
        options.add(3, optionThree)

        for (option in options){
            option.setTextColor(Color.parseColor("grey"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_borders)
        }

    }

    override fun onClick(p0: View?) {
        val optionOne = findViewById<TextView>(R.id.optionOne)
        val optionTwo = findViewById<TextView>(R.id.optionTwo)
        val optionThree = findViewById<TextView>(R.id.optionThree)
        val optionZero = findViewById<TextView>(R.id.optionZero)

        val subBtn = findViewById<Button>(R.id.subBtn)

        when(p0?.id){
            R.id.optionZero ->{
                selectedOptionView(optionZero, 0)
            }
            R.id.optionOne ->{
                selectedOptionView(optionOne, 1)
            }
            R.id.optionTwo ->{
                selectedOptionView(optionTwo,2 )
            }
            R.id.optionThree ->{
                selectedOptionView(optionThree, 3)
            }
            R.id.subBtn -> {
                if(mSelected == 0){
                    mCurrentPos++

                    when {
                        mCurrentPos <= mQuestionsList!!.size ->{setQuestion()
                        }
                        else -> {
                            Toast.makeText(this, "Congratulations! You have become a millionaire!", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else{
                    val question = mQuestionsList?.get(mCurrentPos -1)
                    if(question!!.correctAnswer != mSelected){
                        answerView(mSelected, R.drawable.wrong_option_borders)
                    }

                    answerView(question.correctAnswer, R.drawable.correct_option_borders)

                    if(mCurrentPos ==mQuestionsList!!.size){
                        subBtn.text = "FINISH"
                    }
                    else{
                        subBtn.text = "NEXT QUESTION"
                    }
                    mSelected = 0
                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int){
        val optionOne = findViewById<TextView>(R.id.optionOne)
        val optionTwo = findViewById<TextView>(R.id.optionTwo)
        val optionThree = findViewById<TextView>(R.id.optionThree)
        val optionZero = findViewById<TextView>(R.id.optionZero)

        when (answer){
            0 -> {
                optionZero.background = ContextCompat.getDrawable(this, drawableView)
            }
            1 -> {
                optionOne.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                optionTwo.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                optionThree.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }

    private fun selectedOptionView(tv: TextView,
    selectedNum: Int){
        defaultOptionsView()
        mSelected = selectedNum

        tv.setTextColor(Color.parseColor("black"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.select_option_borders)
    }
}