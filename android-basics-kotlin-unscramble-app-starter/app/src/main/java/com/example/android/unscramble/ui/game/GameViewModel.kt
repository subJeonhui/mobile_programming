package com.example.android.unscramble.ui.game

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    private var _score = 0
    val score: Int
        get() = _score
    private var _currentWordCount = 0
    val currentWordCount: Int
        get() = _currentWordCount
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord

    private var currentWord: String = "test"

    init {
        getNextWord()
    }

    fun getNextWord() {
        val word = allWordsList.random().toCharArray()
        currentWord = String(word)
        word.shuffle()
        _currentScrambledWord = String(word)
    }

    fun isPlayerWordCorrect(playerWord:String):Boolean {
        return playerWord.equals(currentWord)
    }

    fun increaseScore() {
        _score += SCORE_INCREASE
    }
    fun increasCount() {
        _currentWordCount += 1
    }
}