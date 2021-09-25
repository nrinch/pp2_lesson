package na.severinchik.lesson5.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import na.severinchik.lesson5.R
import na.severinchik.lesson5.viewmodels.MainAndroidViewModel


private val KEY = "key"

class MainActivity : AppCompatActivity() {

    var button: Button? = null
    var textOutput: TextView? = null

    //    val mainViewModel by viewModels<MainViewModel>()
//    var mainViewModel: MainViewModel? = null
    val androidViewModel by viewModels<MainAndroidViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Intent(this, ListBankCardsActivity::class.java).apply {
            startActivity(this)
        }

//        val factory = MainViewModelFactory("John")
//        mainViewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        button = findViewById(R.id.am_button)
        textOutput = findViewById(R.id.am_output_tv)

        button?.setOnClickListener {
//            mainViewModel?.fetchData()
            androidViewModel.fetchData()
        }

        androidViewModel.data.observe(this, { list ->
            textOutput?.text = list.last().toString()
        })

//        mainViewModel?.data?.observe(this, { string ->
//            textOutput?.text = string
//        })

    }


//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString(KEY, textOutput?.text.toString())
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        textOutput?.text = savedInstanceState.getString(KEY, "No data")
//    }
}