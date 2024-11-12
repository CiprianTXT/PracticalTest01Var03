package ro.pub.cs.systems.eim.practicaltest01var03

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01Var03SecondaryActivity : AppCompatActivity() {
    private lateinit var correct_btn: Button
    private lateinit var incorrect_btn: Button

    private lateinit var result_textbox2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_secondary)

        correct_btn = findViewById(R.id.correct_btn)
        incorrect_btn = findViewById(R.id.incorrect_btn)

        result_textbox2 = findViewById(R.id.result_textbox2)

        result_textbox2.text = intent.getStringExtra(Constants.RESULT)

        correct_btn.setOnClickListener { view ->
            setResult(Constants.CORRECT_BTN)
            finish()
        }

        incorrect_btn.setOnClickListener { view ->
            setResult(Constants.INCORRECT_BTN)
            finish()
        }
    }
}