package com.example.recyclerviewbug

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val listOfLettersLiveData = MutableLiveData<List<Element>>()

    private val alphabet = listOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',  'm', 'n', 'o', 'p', 'q', 'r', 's', 't',  'u', 'v', 'w', 'x', 'y', 'z')

    init {
        update()
    }

    fun update() {
        val newLetters = arrayListOf<Element>()
        for (i in 0..99) {
            newLetters.add(Element(alphabet.random()))
        }
        listOfLettersLiveData.postValue(newLetters)
    }
}