package na.severinchik.lesson3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.TextView
import kotlinx.parcelize.Parcelize

class MainActivity : AppCompatActivity() {

    var textView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("-->>onCreate")

        textView = findViewById<TextView>(R.id.textField)
        textView?.setOnClickListener {
            textView?.text = "Abra cadabra"
        }

        val user = User("John", "Doe", 42)

        findViewById<Button>(R.id.am_go_to_detail_screen).setOnClickListener {

            //создаение интента
//            val intent = Intent(this,DetailActivity::class.java)
//            startActivity(intent)

            //создаение интента 2 ой вариант с передачей аргуметов
                       Intent(this, DetailActivity::class.java).apply {
                           putExtra(DetailActivity.USER, user)
           //                    putExtra(DetailActivity.ARG1, "Mahalai Mahalai")
           //                    putExtra(DetailActivity.ARG2, 42)
                           startActivity(this)

                       }
            dialPhoneNumber("911")

            //создаение интента 3 ий
//            Intent(this,DetailActivity::class.java).also { intent->
//                startActivity(intent)
//            }

        }
    }

    //конкатенация строк
    var helpNumber = 101
    val helpString = "If u have some troubles call: $helpNumber"
    val helpString1 = "If u have some troubles call: " + helpNumber.toString()

    //вызов неявного интента для которого требуется указаать разррешение в AndroidManifest.xml
    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        println("-->>onStart")
    }

    override fun onResume() {
        super.onResume()
        println("-->>onResume")
    }

    override fun onRestart() {
        super.onRestart()
        println("-->>onRestart")
    }

    override fun onPause() {
        super.onPause()
        println("-->>onPause")
    }

    override fun onStop() {
        super.onStop()
        println("-->>onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("-->>onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(AGBARCADBRA_KEY, textView?.text?.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView?.text = savedInstanceState.getString(AGBARCADBRA_KEY)
    }
}

//Парсеализурующий класс

@Parcelize
data class User(val name: String, val surname: String, val age: Int) : Parcelable {
    companion object {
        val DEFAULT = User("no name", "no surname", -1)
    }
}


private const val AGBARCADBRA_KEY = "abracadabra"