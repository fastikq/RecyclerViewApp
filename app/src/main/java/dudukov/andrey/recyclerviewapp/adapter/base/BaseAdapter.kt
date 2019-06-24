package dudukov.andrey.recyclerviewapp.adapter.base

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<M, VH: BaseAdapter.BaseViewHolder>: RecyclerView.Adapter<VH>() {

    protected val items: MutableList<M> = mutableListOf()
    abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH
    abstract override fun getItemCount(): Int
    abstract override fun onBindViewHolder(holder: VH, position: Int)
    abstract override fun getItemViewType(position: Int): Int
    internal open fun swap(newItems: List<M>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}