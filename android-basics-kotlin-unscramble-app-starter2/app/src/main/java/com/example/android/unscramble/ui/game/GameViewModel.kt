package com.example.android.unscramble.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    private var _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score
    private var _currentWordCount = MutableLiveData(0)
    val currentWordCount: LiveData<Int>
        get() = _currentWordCount

    private var _currentScrambledWord = MutableLiveData("test")
    val currentScrambledWord: LiveData<String>
        get() = _currentScrambledWord

    private var currentWord: String = "test"

    init {
        getNextWord()
    }

    fun getNextWord() {
        val word = allWordsList.random().toCharArray()
        currentWord = String(word)
        word.shuffle()
        _currentScrambledWord.value = String(word)
    }

    fun isPlayerWordCorrect(playerWord: String): Boolean {
        return playerWord.equals(currentWord)
    }

    fun increaseScore() {
        _score.value = _score.value!! + SCORE_INCREASE
    }

    fun increasCount() {
        _currentWordCount.value = _currentWordCount.value!! + 1
    }
}