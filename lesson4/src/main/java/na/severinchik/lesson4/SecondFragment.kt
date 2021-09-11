package na.severinchik.lesson4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class SecondFragment : Fragment() {

    companion object {
        val TAG = SecondFragment.javaClass.name.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        view.findViewById<TextView>(R.id.fs_text).setOnClickListener {
            goToAnotherScreenWithParams("John", "Doe")
        }

        return view
    }


    private fun goToAnotherScreen() {
        parentFragmentManager.beginTransaction()
            .add(MainActivity.fragmentContainer, BlankFragment())
            .commit()
    }

    private fun goToAnotherScreenWithParams(param1: String, param2: String) {
        parentFragmentManager.addNewFragment(
            MainActivity.fragmentContainer,
            BlankFragment.getInstanceNewParams(parentFragmentManager, param1, param2)
        )
    }
}

fun FragmentManager.addNewFragment(container: Int, fragment: Fragment) {
    beginTransaction()
        .add(container, fragment)
        .addToBackStack("")
        .commit()
}

