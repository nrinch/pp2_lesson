package na.severinchik.lesson4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager

// ключи для получения аргументов из bundle
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment : Fragment() {
    //переменные которые будут хранить полученые аргументы
    private var param1: String? = null
    private var param2: String? = null

    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //получение аргументов и установление их в текстовое поле
    override fun onStart() {
        super.onStart()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1) ?: String.EMPTY
            param2 = it.getString(ARG_PARAM2) ?: ""
        }

        textView?.text = "$param1 $param2"
    }


    //присоедиение fragment_blank.xml к классу BlankFragment.kt
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blank, container, false)
        textView = view.findViewById(R.id.fb_text)
        return view
    }

    companion object {
        //тег для поиска фрагмета в приложении
        val TAG = BlankFragment.javaClass.toString()


        //создание экземпляра фрагмента с аргументами
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = bundleOf(
                    ARG_PARAM1 to param1,
                    ARG_PARAM2 to param2
                )
            }

        //получение фрагмента по тегу
        fun getInstance(fragmentManager: FragmentManager): BlankFragment =
            fragmentManager.findFragmentByTag(TAG) as BlankFragment? ?: BlankFragment()



        //получение фрагмента по тегу с параметрами
        fun getInstanceNewParams(
            fragmentManager: FragmentManager,
            param1: String,
            param2: String
        ): BlankFragment {

            val fragment = fragmentManager.findFragmentByTag(TAG) as BlankFragment?
            fragment?.apply {
                arguments = bundleOf(
                    ARG_PARAM1 to param1,
                    ARG_PARAM2 to param2
                )
                println("-->> finded")
            }

            return fragment ?: newInstance(param1, param2)
        }
    }
}


//расширение для строки позволяющие  создавать пустую строку
val String.Companion.EMPTY
    get() = ""