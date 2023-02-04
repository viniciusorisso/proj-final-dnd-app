package com.ficha.dd.presentation.ui.spells_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ficha.dd.databinding.SpellsListItemBinding
import com.ficha.dd.domain.Element.Spell

class SpellsListAdapter() :
    RecyclerView.Adapter<SpellsListAdapter.ViewHolder>() {

    private val spells: MutableList<Spell> = mutableListOf()

    fun setSpells(spellsList: List<Spell>) {
        spells.clear()
        spells.addAll(spellsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = SpellsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return spells.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spell = spells[position]
        holder.bind(spell)
    }

    class ViewHolder(private val itemBinding: SpellsListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind (spell : Spell) = with(itemBinding) {
            this.spellName.text = spell.name
            this.spellUrl.text = spell.url
            this.spellIndex.text = spell.index
        }
    }
}