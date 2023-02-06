package com.ficha.dd.presentation.ui.sheet_spells

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ficha.dd.databinding.SpellsListItemBinding
import com.ficha.dd.domain.model.Item
import com.ficha.dd.domain.model.Spell

class SheetSpellsAdapter(val onClick: (Spell) -> Unit) :
    RecyclerView.Adapter<SheetSpellsAdapter.ViewHolder>() {

    private val spells: MutableList<Spell> = mutableListOf()

    private var filteredList: MutableList<Spell> = mutableListOf()

    fun setSpells(spellsList: List<Spell>?) {
        if(!spellsList.isNullOrEmpty()){
            spells.clear()
            spells.addAll(spellsList)
            notifyDataSetChanged()
        }
        spells.map {
            filteredList.add(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = SpellsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spell = filteredList[position]
        holder.bind(spell, onClick)
    }
    fun filterSpellsList(spellName: String?) {
        filteredList.clear()
        spells.map {
            if(spellName.isNullOrEmpty())
                filteredList.add(it)
            else{
                if(it.name.lowercase().contains(spellName.lowercase()))
                    filteredList.add(it) else {}
            }
        }
        notifyDataSetChanged()
    }

    class ViewHolder (private val itemBinding: SpellsListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind (spell: Spell, onClick: (Spell) -> Unit) = with(itemBinding) {
            this.spellName.text = spell.name


            root.setOnClickListener{
                onClick(spell)
            }
        }
    }
}