package zepeda.dan.quiz

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"
class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val bancoPreguntas=listOf(
        preguntas(R.string.pregunta_lapuertanegra,true),
        preguntas(R.string.pregunta_chuy_mau,false),
        preguntas(R.string.pregunta_jgl,false),
        preguntas(R.string.pregunta_elnumero1,false),
        preguntas(R.string.los_sanguinarios,false)

    )

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)


    private var Indice:Int
    get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
    set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)
    val currentQuestionAnswer: Boolean
        get() = bancoPreguntas[Indice].respuesta
    val currentQuestionText: Int
        get() = bancoPreguntas[Indice].TextoPregunta
    fun moveToNext() {
        Indice = (Indice + 1) % bancoPreguntas.size
}}
