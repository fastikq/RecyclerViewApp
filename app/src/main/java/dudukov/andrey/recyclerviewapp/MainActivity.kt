package dudukov.andrey.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dudukov.andrey.recyclerviewapp.adapter.FruitAdapter
import dudukov.andrey.recyclerviewapp.adapter.model.Fruit
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.List as List1

class MainActivity : AppCompatActivity() {

    private lateinit var fruitList: MutableList<Fruit>
    private val adapter: FruitAdapter by lazy { FruitAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerList.adapter = adapter
        fruitList = generateFruitList()
        adapter.swap(fruitList)
    }
    private fun generateFruitList(): MutableList<Fruit> {
        return mutableListOf(
            Fruit("Apple", 70),
            Fruit("Orange", 135),
            Fruit("Banana", 235),
            Fruit("Kiwi", 145),
            Fruit("Cherry", 300),
            Fruit("Lemon", 265),
            Fruit("Mandarin", 400),
            Fruit("Grapefruit", 500),
            Fruit("Mango", 160),
            Fruit("Apricot", 465),
            Fruit("Lime", 310),
            Fruit("Pear", 80),
            Fruit("Feijoa", 700),
            Fruit("Avocado", 565)
        )
    }
}
