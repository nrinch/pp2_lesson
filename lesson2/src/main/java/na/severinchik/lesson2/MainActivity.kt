package na.severinchik.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var output: TextView
    lateinit var number_1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        number_1.setOnClickListener { output.text = "${output.text}1" }

        output.text = "Infinity"

//        InitOrderDemo("Android").firstProperty
//
//        ExB().ExInner()
//        ExB.ExNested()
//
//        val exA: ExA = ExB()
//        exA.foo()
//
//        sumEverythings(1, 23, 4, 5, 6, 32, 2, 5, 6, 3, 2, 5, 6, 2, 2, 5, 6, 2)
//        (sumEverythings(0.0, 0.1) as Double).toInt()
    }

    private fun initViews() {
        output = findViewById(R.id.am_output_tv)
        number_1 = findViewById(R.id.number_1)
    }

    fun mult(view: View) {

    }

    fun div(view: View) {

    }

    fun inputNumber(v:View){
        val button = v as Button
        when(button.text){
            "1" ->  addToOutputField("1")
            "2" ->  addToOutputField("2")
            "3" ->  addToOutputField("3")
            "4" ->  addToOutputField("4")
            "5" ->  addToOutputField("5")
            "6" ->  addToOutputField("6")
            "7" ->  addToOutputField("7")
            "8" ->  addToOutputField("8")
            "9" ->  addToOutputField("9")
            "0" ->  addToOutputField("0")
        }
    }
    private fun addToOutputField(value:String){
        output.text = "${output.text}$value"
    }

}
//
//open class A {
//    fun foo() {}
//}
//
//var smthArray = arrayOf<A>()
//
//fun sumEverythings(vararg args: Int): Int {
//    var result = 0
//    for (i in args) {
//        result += i
//    }
//    return result
//}
//
//fun sumEverythings(vararg args: Double): Any {
//    var result = 0.0
//    for (i in args) {
//        result += i
//    }
//    return result
//}
//
//val stroka = "$smthArray ${Int.MAX_VALUE} sum: ${sumEverythings(1, 4, 5)}"
//
//fun exmplCondition(): Int {
//    val result = if (stroka.length < 10) {
//        //TODO
//        -1
//    } else {
//        //TODO
//        10
//    }
//    return result
//}
//
//val condition = if (stroka.length > 0) -1 else 0
//
//var result: Int? = null
//
//var secondResult: Int = result ?: 0
//
//
//fun ex() {
//    var a: Int = 10
//
//
//}
//
//class InitOrderDemo constructor(name: String) : A() {
//    val firstProperty = "Первое свойство: $name".also(::println)
//
//    init {
//        println("Первый блок инициализации: ${name}")
//    }
//
//    val secondProperty = "Второе свойство: ${name.length}".also(::println)
//
//    init {
//        println("Второй блок инициализации: ${name.length}")
//    }
//
//
//    constructor(name: String, surname: String, fatherName: String) : this(name) {
//
//    }
//
//
//}
//
//
//fun demo(anyObject: Any) {
//    if (anyObject is A) {
//        var aObject = anyObject as A
//        aObject.foo()
//    }
//    if (anyObject is Int) {
//        anyObject.rangeTo(1)
//    }
//
//    when (anyObject) {
//        is Int -> {
//            print(anyObject)
//            print(anyObject)
//        }
//        is A -> {
//
//        }
//        1 -> {
//            print("This is one")
//        }
//        1, 45, 2 -> {
//            print("This is winner number")
//        }
//        69..666 -> {
//
//        }
//
//        else -> {
//
//        }
//
//    }
//}
//
//open class ExA() {
//    open fun foo() {}
//}
//
//open class ExAA() {
//
//    val a: Boolean
//        get() {
//            return true
//        }
//
//    var b: Boolean = false
//        get() = true
//        set(value) {
//            field = value && true
//        }
//
//    fun foo() {
//        b = false
//    }
//}
//
//
//open class ExB() : ExA(), IDrawable {
//    final override fun foo() {
//
//    }
//
//    private val a = ""
//
//    inner class ExInner() {
//        private val b = ""
//        val c = ""
//        fun foo() {
//            super@ExB.foo()
//            a.length
//        }
//    }
//
//    class ExNested() {
//
//    }
//
//    override fun fill() {
//        TODO("Not yet implemented")
//    }
//}
//
//
//fun ExB.boo(`) {
//    val a: Int = 0
//    val ab: Int? = null
//
//    a.doubleLenght
//}
//
//val Int.doubleLenght: Int
//    get() = 10
//
//fun Int.foo() {}
//
//interface IDrawable {
//    fun draw() {
//        print("")
//    }
//
//    fun fill()
//}
//
//
//fun main() {
//    val room = Room()
//    room.createTable()
//    //Invoke another methods
//
//    ExB().boo()
//    print(room.table)
//    Room.MIN_SIZE
//    Room.deltaSize()
//
//    val superUser = SuperUser("John", "Doe")
//    val secondSuperUser = superUser.copy(surname = "Trawolta")
//    secondSuperUser.smth()
//
//    val state = APIRequest("")
//
//    when (state) {
//        APIResponse.Default -> TODO()
//        is APIResponse.Error -> TODO()
//    }
//}
//
//fun APIRequest(request: String): APIResponse {
//    return APIResponse.Loading
//}
//
//fun APIReceiver(request: String): APIResponse {
//    return APIResponse.Loaded("Reciving info")
//}
//
//class Room {
//    lateinit var subject: Subject
//
//
//    private var _table: Map<String, Int>? = null
//    val table: Map<String, Int>
//        get() {
//            if (_table == null) {
//                _table =
//                    HashMap() // параметры типа вычисляются автоматически // (ориг.: "Type parameters are inferred")
//            };return _table ?: throw AssertionError("Set to null by another thread")
//        }
//
//    fun createTable() {
//        subject = Subject()
//        //Do something with _table ex: Add new table to _table
//        if (this::subject.isInitialized) {
//            subject.isReadOnly
//        }
//
//    }
//
//    companion object {
//        const val MAX_SIZE: Int = 42
//    }
//}
//
//
//val Room.Companion.MIN_SIZE: Int
//    get() = 0
//
//fun Room.Companion.deltaSize(): Int = MAX_SIZE - MIN_SIZE
//fun SuperUser.deltaSize(): Int = Room.MAX_SIZE - Room.MIN_SIZE
//
//data class SuperUser(val name: String, val surname: String) : A() {
//    fun smth() {
//    }
//}
//
//enum class Numbers() {
//    FIRST,
//    SECOND,
//}
//
//
//sealed class APIResponse {
//    object Default : APIResponse()
//    object Loading : APIResponse()
//    data class Loaded(val result: String) : APIResponse()
//    data class Error(val message: String) : APIResponse()
//}
//
//object Singleton {
//    fun calc() {}
//}
//
//fun <T> setAny(value: T): T {
//    return value
//}
//
//val result = object : View.OnClickListener{
//    override fun onClick(v: View?) {
//        TODO("Not yet implemented")
//    }
//}
