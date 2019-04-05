package com.example.recyclerviewbug

import android.support.v7.util.DiffUtil

data class Element(val letter: Char) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Element>() {
            override fun areItemsTheSame(l1: Element, l2: Element) = l1.letter == l2.letter

            override fun areContentsTheSame(l1: Element, l2: Element) = l1 == l2
        }
    }
}