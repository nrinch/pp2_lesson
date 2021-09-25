package na.severinchik.lesson5.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import na.severinchik.lesson5.R
import na.severinchik.lesson5.databinding.ActivityMainWithBindingBinding

class MainActivityWithBinding : AppCompatActivity() {

    private var _binding: ActivityMainWithBindingBinding? = null
    val binding: ActivityMainWithBindingBinding get() = _binding!!

//    lateinit var _binding: ActivityMainWithBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainWithBindingBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.amwbButton.setOnClickListener {
            //TODO(SOMETHING)
        }
    }

    override fun onStop() {
        super.onStop()
        _binding = null
    }
}