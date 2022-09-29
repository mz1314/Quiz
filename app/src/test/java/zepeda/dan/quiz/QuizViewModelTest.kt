package zepeda.dan.quiz


import androidx.lifecycle.SavedStateHandle
import org.junit.Test

import org.junit.Assert.*
class QuizViewModelTest{
    @Test
    fun proveeElTextoDePreguntaEsperado(){
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.pregunta_lapuertanegra,quizViewModel.currentQuestionText)
        quizViewModel.moveToNext()
        assertEquals(R.string.pregunta_chuy_mau,quizViewModel.currentQuestionText)
    }

    @Test
    fun funcionaElBancoDePreguntas(){
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 3))
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.pregunta_chuy_mau,quizViewModel.currentQuestionText)
        quizViewModel.moveToNext()
        assertEquals(R.string.pregunta_el24,quizViewModel.currentQuestionText)
    }
}