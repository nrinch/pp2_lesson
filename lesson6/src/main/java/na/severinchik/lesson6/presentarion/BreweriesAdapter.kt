package na.severinchik.lesson6.presentarion

import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import na.severinchik.lesson6.data.entities.BreweryItem
import na.severinchik.lesson6.databinding.ItemBreweryBinding

class BreweriesAdapter :
    ListAdapter<BreweryItem, BreweriesAdapter.BreweryViewHolder>(BreweryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreweryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBreweryBinding.inflate(layoutInflater, parent, false)
        return BreweryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BreweryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class BreweryViewHolder(private val binding: ItemBreweryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(brewery: BreweryItem) {
            with(binding){
                ibCity.text = brewery.city
                ibCountry.text = brewery.country
                ibName.text = brewery.name
                ibPhone.text = brewery.phone
                ibState.text = brewery.state
                ibStreet.text = brewery.street
                ibType.text = brewery.brewery_type
                ibWebsiteUrl.text = brewery.website_url
                ibWebsiteUrl.movementMethod = LinkMovementMethod.getInstance()
            }
        }
    }

    class BreweryDiffCallback : DiffUtil.ItemCallback<BreweryItem>() {
        override fun areItemsTheSame(oldItem: BreweryItem, newItem: BreweryItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BreweryItem, newItem: BreweryItem): Boolean {
            return oldItem == newItem
        }

    }
}