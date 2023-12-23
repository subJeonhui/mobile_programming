package com.jeonhui.lesson8viewmodel.ui.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel(){
    private var _score = MutableLiveData<Int>(0)
    val score: LiveData<Int>
        get() = _score

    private var _currentWordCount = MutableLiveData<Int>(0)
    val currentWordCount:LiveData<Int>
        get() = _currentWordCount

    private var _currentScrambledWord = MutableLiveData<String>("test")
    val currentScrambledWord:LiveData<String>
        get() = _currentScrambledWord

    private var currentWord:String = "test"

    init{
        getNextWord()
    }
    fun getNextWord(){
        val word = allWordsList.random().toCharArray()
        currentWord = String(word)
        word.shuffle()
        _currentScrambledWord.value = String(word)
    }
    fun isPlayerWordCorrect(playerWord:String):Boolean{
        return playerWord == currentWord
    }
    fun increaseScore(){
        _score.value = _score.value!! + SCORE_INCREASE
    }
    fun increaseCount(){
        _currentWordCount.value = _currentWordCount.value!! + 1
    }

}