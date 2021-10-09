package na.severinchik.lesson6.presentarion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.flow.collect
import na.severinchik.lesson6.databinding.ActivityGlideBinding

class GlideActivity : AppCompatActivity() {

    val url = "https://coffee.alexflipnote.dev/random"

    private val viewModel: GlideViewModel by viewModels()

    private var _binding: ActivityGlideBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityGlideBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        lifecycleScope.launchWhenCreated {
            viewModel.state.collect {
                Glide.with(this@GlideActivity)
                    .load(it.imageUrl)
                    .centerCrop()
                    .into(binding.gaImage)
            }
        }

        binding.gaGetButton.setOnClickListener {
            viewModel.getNewPicture()
        }
    }
}