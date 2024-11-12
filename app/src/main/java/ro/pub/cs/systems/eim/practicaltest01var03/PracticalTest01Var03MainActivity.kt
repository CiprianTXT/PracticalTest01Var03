package ro.pub.cs.systems.eim.practicaltest01var03

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    private lateinit var plus_btn: Button
    private lateinit var minus_btn: Button

    private lateinit var op1: EditText
    private lateinit var op2: EditText

    private lateinit var result_textbox: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        plus_btn = findViewById(R.id.plus_btn)
        minus_btn = findViewById(R.id.minus_btn)

        op1 = findViewById(R.id.op1)
        op2 = findViewById(R.id.op2)

        result_textbox = findViewById(R.id.result_textbox)

        plus_btn.setOnClickListener { view ->
            if (op1.text.isEmpty() || op2.text.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val op1_val = op1.text.toString()
            val op2_val = op2.text.toString()

            val result = op1_val.toInt() + op2_val.toInt()
            result_textbox.setText("$op1_val + $op2_val = $result")
        }
        minus_btn.setOnClickListener { view ->
            if (op1.text.isEmpty() || op2.text.isEmpty()) {
                Toast.makeText(this, "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val op1_val = op1.text.toString()
            val op2_val = op2.text.toString()

            val result = op1_val.toInt() - op2_val.toInt()
            result_textbox.setText("$op1_val - $op2_val = $result")
        }
    }
}