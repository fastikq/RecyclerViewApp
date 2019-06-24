package dudukov.andrey.recyclerviewapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import dudukov.andrey.recyclerviewapp.R
import dudukov.andrey.recyclerviewapp.adapter.base.BaseAdapter
import dudukov.andrey.recyclerviewapp.adapter.model.Fruit
import dudukov.andrey.recyclerviewapp.adapter.model.Separator

class FruitAdapter: BaseAdapter<ItemType, BaseAdapter.BaseViewHolder>() {

    private val lambdaForDefineSeparator = { p: Int -> p != 0 && p % 2 == 0 }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            ItemType.DEFAULT_ITEM_TYPE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
                ViewHolderDefault(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_separator_recycler, parent, false)
                ViewHolderSeparator(view)
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentItem = items[position]
        when(holder){
            is ViewHolderDefault -> {
               holder.apply {
                   currentItem as Fruit
                   tvName.text = currentItem.name
                   tvPrice.text = currentItem.price.toString()
               }
            }
            is ViewHolderSeparator -> {
                holder.apply {}
            }
        }
    }
    override fun getItemViewType(position: Int): Int {
        return if(items[position] is Fruit) ItemType.DEFAULT_ITEM_TYPE else ItemType.SEPARATOR_ITEM_TYPE
    }
    override fun swap(newItems: List<ItemType>) {
        items.clear()
        for ((index, item) in newItems.withIndex()) {
            if(index.isNeedSeparator(lambdaForDefineSeparator)) {
                items.add(Separator())
            }
            items.add(item)
        }
        notifyDataSetChanged()
    }
    private inline fun <reified T> Int.isNeedSeparator(body:(p: Int) -> Boolean) : T{
        return body(this) as T
    }

    private class ViewHolderDefault(itemView: View): BaseViewHolder(itemView) {
        val tvName: AppCompatTextView = itemView.findViewById(R.id.tvName)
        val tvPrice: AppCompatTextView = itemView.findViewById(R.id.tvPrice)
    }
    private class ViewHolderSeparator(itemView: View): BaseViewHolder(itemView)
}