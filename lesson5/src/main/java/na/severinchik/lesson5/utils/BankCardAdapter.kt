package na.severinchik.lesson5.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import na.severinchik.lesson5.databinding.ItemBankCardBinding
import na.severinchik.lesson5.models.BankCard

class BankCardAdapter :
    ListAdapter<BankCard, BankCardAdapter.BankCardViewHolder>(BankCardDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankCardViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBankCardBinding.inflate(layoutInflater, parent, false)
        return BankCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BankCardViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BankCardViewHolder(private val binding: ItemBankCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bankCard: BankCard) {
            binding.ibcOwner.text = bankCard.owner
            binding.ibcNumber.text = bankCard.number
            binding.ibcExpireData.text = bankCard.expireData
            binding.ibcCurrency.text = bankCard.currency
            binding.ibcCard.setCardBackgroundColor(bankCard.color)
            binding.ibcBank.text = bankCard.bankName
        }
    }

    class BankCardDiffCallback : DiffUtil.ItemCallback<BankCard>() {
        override fun areItemsTheSame(oldItem: BankCard, newItem: BankCard): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: BankCard, newItem: BankCard): Boolean {
            return oldItem == newItem
        }

    }

}