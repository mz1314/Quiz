package zepeda.dan.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import zepeda.dan.quiz.databinding.ActivityMainBinding
private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate Called")
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "Tengo un view model: $quizViewModel")


        binding.trueButtom.setOnClickListener { view: View ->
            checkAnswer(true,view)
        }
        binding.falseButtom.setOnClickListener { view: View ->
            checkAnswer(false,view)
        }

        binding.nextButton.setOnClickListener { view: View ->
            quizViewModel.moveToNext()
            updateQuestion()
        }
        updateQuestion()
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
    private fun updateQuestion() {
        val preguntaTextResId = quizViewModel.currentQuestionText
        binding.questionText.setText(preguntaTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean,view:View) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        val colorBackgroud=if(userAnswer==correctAnswer){
            R.color.verde
        }else
            R.color.naranja
        val mySnackbar=Snackbar.make(view,messageResId,Snackbar.LENGTH_LONG)
        mySnackbar.setBackgroundTint(getColor(colorBackgroud))
        mySnackbar.show()
    }
}