package com.example.recyclerviewbug

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.view_holder_element.*

class ElementsAdapter : ListAdapter<Element, ElementsAdapter.ElementViewHolder>(Element.DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ElementViewHolder {
        return ElementViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_element, parent, false))
    }

    override fun onBindViewHolder(viewHolder: ElementViewHolder, position: Int) {
        viewHolder.bind(getItem(position))
    }

    inner class ElementViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(element: Element) {
            letterText.text = element.letter.toString()
        }
    }
}