package na.severinchik.lesson5.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson5.R
import na.severinchik.lesson5.databinding.ActivityListBankCardsBinding
import na.severinchik.lesson5.utils.BankCardAdapter
import na.severinchik.lesson5.viewmodels.ListBankViewModel

class ListBankCardsActivity : AppCompatActivity() {

    private var _binding: ActivityListBankCardsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<ListBankViewModel>()
    private val adapter = BankCardAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityListBankCardsBinding.inflate(
            LayoutInflater.from(this)
        )

        binding.albcRecycler.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.card.collect { list->
                adapter.submitList(list)
            }
            adapter.notifyDataSetChanged()
        }

        binding.albcButtonFetch.setOnClickListener {
            viewModel.fetchCards()
        }

        setContentView(binding.root)
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}