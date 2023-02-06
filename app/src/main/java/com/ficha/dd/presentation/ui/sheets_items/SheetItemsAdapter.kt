package com.ficha.dd.presentation.ui.sheets_items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ficha.dd.databinding.ListItemBinding
import com.ficha.dd.domain.model.Item

class SheetItemsAdapter(val onClick: (Item) -> Unit) :
    RecyclerView.Adapter<SheetItemsAdapter.ViewHolder>() {

    private val items: MutableList<Item> = mutableListOf()

    private var filteredList: MutableList<Item> = mutableListOf()

    fun setItems(itemsList: List<Item>?) {
        if(!itemsList.isNullOrEmpty()){
            items.clear()
            items.addAll(itemsList)
            notifyDataSetChanged()
        }
        items.map {
            filteredList.add(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredList[position]
        holder.bind(item, onClick)
    }
    fun filterItemsList(itemName: String?) {
        filteredList.clear()
        items.map {
            if(itemName.isNullOrEmpty())
                filteredList.add(it)
            else{
                if(it.name.lowercase().contains(itemName.lowercase()))
                    filteredList.add(it) else {}
            }
        }
        notifyDataSetChanged()
    }

    class ViewHolder (private val itemBinding: ListItemBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind (item: Item, onClick: (Item) -> Unit) = with(itemBinding) {
            this.itemName.text = item.name

            root.setOnClickListener{
                onClick(item)
            }
        }
    }
}