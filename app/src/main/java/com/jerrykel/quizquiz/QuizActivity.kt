package com.jerrykel.quizquiz

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class QuizActivity : AppCompatActivity() {
    var quizArrayList = ArrayList<Quiz>()
    var nbOfGoodAnswers: Int = 0
    var currentQuizIndex:Int = 0
    private var textViewQuestion: TextView?= null
    private var textViewFirstAnswer:TextView? =null
    private var textViewSecondAnswer:TextView? = null
    private var textViewThreeAnswer:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        quizArrayList.add(Quiz("Quelle est la capitale de l'Algérie ?","Alger","Paris","caire",1))
        quizArrayList.add(Quiz("Quelle est la capitale du Togo ?","Vienne","Lome","Bruxelle",2))
        quizArrayList.add(Quiz("Quelle est la capitale du Salvadore ?","Vienne","Lome","Bruxelle",2))
        initQuizViews()
        showQuestion(quizArrayList[currentQuizIndex])
    }
    private fun initQuizViews(){
        textViewQuestion = findViewById(R.id.textViewQuestion)
        textViewFirstAnswer= findViewById(R.id.textViewFirstAnswer)
        textViewSecondAnswer = findViewById(R.id.textViewSecondAnswer)
        textViewThreeAnswer= findViewById(R.id.textViewThreeAnswer)
    }
    private fun showQuestion(quiz:Quiz ){

        textViewQuestion?.text = quiz.question


        textViewFirstAnswer?.text = quiz.answer1

        textViewSecondAnswer?.text = quiz.answer2

        textViewThreeAnswer?.text = quiz.answer3

        textViewFirstAnswer?.setOnClickListener{answerOnclick(it)}
        textViewSecondAnswer?.setOnClickListener{answerOnclick(it)}
        textViewThreeAnswer?.setOnClickListener{ answerOnclick(it)}

    }
    private fun answerOnclick(view: View){
        if(view == textViewFirstAnswer){
            handleAnswer(1)
        }
        else if (view== textViewSecondAnswer){
            handleAnswer(2)
        }
        else{
            handleAnswer(3)
        }
    }
    private fun handleAnswer(answerId: Int){
        val quiz = quizArrayList[currentQuizIndex]
        if(quiz.isCorrect((answerId))){
            nbOfGoodAnswers++
            Toast.makeText(this,"+1",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"+0",Toast.LENGTH_SHORT).show()
        }
        currentQuizIndex++
        if(currentQuizIndex >= quizArrayList.size){
            val alert = AlertDialog.Builder(this)
            alert.setTitle("OOOOh the play are ending:)")
            alert.setMessage("you had: "+ nbOfGoodAnswers +"good answer(s) And see you Later")
            alert.setPositiveButton("Ok"){
                dialogInterface: DialogInterface?,i:Int-> finish()
            }
            alert.show()
        }else{
            showQuestion(quizArrayList[currentQuizIndex])
        }
    }
    fun onClickAnswer(view: View) {


    }
}