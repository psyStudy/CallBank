package com.minseo.callbank.view.map

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.minseo.callbank.databinding.BankItemBinding
import com.minseo.callbank.model.Bank

class BankListAdapter: ListAdapter<Bank, BankListAdapter.BankViewHolder>(callback) {

    private lateinit var binding: BankItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = BankItemBinding.inflate(inflater, parent, false)
        return BankViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        val item = getItem(position)

        with(holder.binding) {
            tvBankName.text = item.name
            tvBankPlace.text = item.place
            tvBankAddress.text = item.address
            tvBankTel.text = item.tel
        }

        holder.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                val name = item.name
                val tel = item.tel
                val address = item.address
                Log.e("Adapter", "$name, $tel, $address")
            }
        })
    }

    class BankViewHolder(val binding: BankItemBinding) : RecyclerView.ViewHolder(binding.root)

    private fun toggleLayout(isExpanded: Boolean, view: View, layoutMore: LinearLayout, layoutExpanded: LinearLayout) : Boolean {
        if (isExpanded)
            ToggleAnimation.expand(layoutMore, layoutExpanded)
        else
            ToggleAnimation.collapse(layoutMore, layoutExpanded)

        return isExpanded
    }

    companion object {
        private val callback = object : DiffUtil.ItemCallback<Bank>() {
            override fun areItemsTheSame(oldItem: Bank, newItem: Bank): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Bank, newItem: Bank): Boolean {
                return oldItem.name == newItem.name &&
                        oldItem.place == newItem.place &&
                        oldItem.address == newItem.address &&
                        oldItem.tel == newItem.tel
            }

            override fun getChangePayload(oldItem: Bank, newItem: Bank): Any {
                return Any()
            }
        }
    }
}