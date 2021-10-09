package na.severinchik.lesson6.presentarion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson6.R
import na.severinchik.lesson6.data.Responce
import na.severinchik.lesson6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val adapter = BreweriesAdapter()

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        Intent(this, GlideActivity::class.java).apply {
            startActivity(this)
        }

        binding.amListBreweries.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.state.collect { state ->
                when (state) {
                    is Responce.Error -> Toast.makeText(
                        this@MainActivity,
                        "Error -->> ${state.message}",
                        Toast.LENGTH_LONG
                    ).show()
                    Responce.Loading -> Toast.makeText(
                        this@MainActivity,
                        "Loading...",
                        Toast.LENGTH_LONG
                    ).show()
                    is Responce.Success -> {
                        adapter.submitList(state.responceBreweries)
                        adapter.notifyDataSetChanged()

                    }
                }


            }
        }

        binding.amGetButton.setOnClickListener {
            viewModel.getBreweries()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}