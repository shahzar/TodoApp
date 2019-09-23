package com.shahzar.zirotodo.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SortedList
import com.shahzar.zirotodo.R
import com.shahzar.zirotodo.data.model.ItemModel
import kotlinx.android.synthetic.main.item_list.view.*

class ListAdapter() : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var onDeleteClick: ((ItemModel) -> Unit)? = null
    var onEditClick: ((ItemModel) -> Unit)? = null
    var onDoneCheck: ((ItemModel, Boolean) -> Unit)? = null

    private val mComparator = Comparator<ItemModel> { a, b -> a.id.compareTo(b.id) }

    val sortedList: SortedList<ItemModel> = SortedList(ItemModel::class.java, object: SortedList.Callback<ItemModel>(){
        override fun areItemsTheSame(item1: ItemModel?, item2: ItemModel?): Boolean {
            return item1?.title == item2?.title
        }

        override fun onMoved(fromPosition: Int, toPosition: Int) {
            notifyItemMoved(fromPosition, toPosition)
        }

        override fun onChanged(position: Int, count: Int) {
            notifyItemRangeChanged(position, count)
        }

        override fun onInserted(position: Int, count: Int) {
            notifyItemRangeInserted(position, count)
        }

        override fun onRemoved(position: Int, count: Int) {
            notifyItemRangeRemoved(position, count)
        }

        override fun compare(o1: ItemModel?, o2: ItemModel?): Int {
            return mComparator.compare(o1, o2)
        }

        override fun areContentsTheSame(oldItem: ItemModel?, newItem: ItemModel?): Boolean {
            return oldItem?.equals(newItem)!!
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.description.text = sortedList.get(position).description
        holder.title.text = sortedList.get(position).title
        holder.doneCheck.isChecked = sortedList.get(position).completed
    }

    override fun getItemCount(): Int {
        return sortedList.size()
    }

    fun add(item: ItemModel) {
        sortedList.add(item)
    }

    fun remove(item: ItemModel) {
        sortedList.remove(item)
    }

    fun add(items: List<ItemModel>) {
        this.sortedList.addAll(items)
    }

    fun remove(items: List<ItemModel>) {
        sortedList.beginBatchedUpdates()
        for (item in items) {
            sortedList.remove(item)
        }
        sortedList.endBatchedUpdates()
    }

    fun replaceAll(items: List<ItemModel>) {
        sortedList.beginBatchedUpdates()
        for (i in sortedList.size() - 1 downTo 0) {
            val model = sortedList.get(i)
            if (!items.contains(model)) {
                sortedList.remove(model)
            }
        }
        sortedList.addAll(items)
        sortedList.endBatchedUpdates()
    }

    inner class ViewHolder (view: View): RecyclerView.ViewHolder(view) {
        val description = view.description
        val title = view.title
        val doneCheck = view.doneCheck

        init {
            view.deleteBtn.setOnClickListener {
                onDeleteClick?.invoke(sortedList.get(adapterPosition))
            }
            view.editBtn.setOnClickListener {
                onEditClick?.invoke(sortedList.get(adapterPosition))
            }
            view.doneCheck.setOnCheckedChangeListener { button, checked ->
                onDoneCheck?.invoke(sortedList.get(adapterPosition), checked)
            }
        }
    }
}
