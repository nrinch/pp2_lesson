package na.severinchik.lesson3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ARG1 = "arg1"
        const val ARG2 = "arg2"
        const val USER = "user"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Получение аргументов из интента

//        findViewById<TextView>(R.id.ad_text_field).text = "${
//            intent.getStringExtra(ARG1) ?: "No passing data"
//        } ${
//            intent.getIntExtra(ARG2, 0)
//        }"

        //Получение аргументов в виде парсеализирующегося класса из интента

        val user: User = intent.getParcelableExtra<User>(USER) ?: User.DEFAULT
        findViewById<TextView>(R.id.ad_text_field).text = "${
//            intent.getParcelableExtra<User>(USER) ?: "No user data"
            intent.getParcelableExtra<User>(USER) ?: User.DEFAULT
        }"
    }
}