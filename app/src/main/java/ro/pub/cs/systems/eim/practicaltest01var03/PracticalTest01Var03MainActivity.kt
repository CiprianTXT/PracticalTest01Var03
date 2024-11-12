package ro.pub.cs.systems.eim.practicaltest01var03

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    private lateinit var plus_btn: Button
    private lateinit var minus_btn: Button
    private lateinit var switch_activity_btn: Button

    private lateinit var op1: EditText
    private lateinit var op2: EditText

    private lateinit var result_textbox: TextView

    private lateinit var activity_result_launcher: ActivityResultLauncher<Intent>

    private lateinit var service_intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        plus_btn = findViewById(R.id.plus_btn)
        minus_btn = findViewById(R.id.minus_btn)
        switch_activity_btn = findViewById(R.id.switch_activity_btn)

        op1 = findViewById(R.id.op1)
        op2 = findViewById(R.id.op2)

        result_textbox = findViewById(R.id.result_textbox)

        activity_result_launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Constants.CORRECT_BTN) {
                Toast.makeText(this, "Pressed Correct", Toast.LENGTH_LONG).show()
            } else if (result.resultCode == Constants.INCORRECT_BTN) {
                Toast.makeText(this, "Pressed Incorrect", Toast.LENGTH_LONG).show()
            }
        }

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
            result_textbox.text = "$op1_val - $op2_val = $result"

            service_intent = Intent(this, PracticalTest01Var03Service::class.java)
            service_intent.putExtra(Constants.SERVICE_PLUS_RESULT, (op1_val.toInt() + op2_val.toInt()).toString())
            service_intent.putExtra(Constants.SERVICE_MINUS_RESULT, (op1_val.toInt() - op2_val.toInt()).toString())
            startForegroundService(service_intent)
        }
        switch_activity_btn.setOnClickListener { view ->
            val intent = Intent(this, PracticalTest01Var03SecondaryActivity::class.java)
            intent.putExtra(Constants.RESULT, result_textbox.text.toString())
            activity_result_launcher.launch(intent)
        }
    }

    @Override
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(Constants.OP1, op1.text.toString())
        outState.putString(Constants.OP2, op2.text.toString())
        outState.putString(Constants.RESULT, result_textbox.text.toString())
    }

    @Override
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.containsKey(Constants.OP1)) {
            op1.setText(savedInstanceState.getString(Constants.OP1))
        }
        if (savedInstanceState.containsKey(Constants.OP2)) {
            op2.setText(savedInstanceState.getString(Constants.OP2))
        }
        if (savedInstanceState.containsKey(Constants.RESULT)) {
            result_textbox.text = savedInstanceState.getString(Constants.RESULT)
        }
        Toast.makeText(this, "Restored state", Toast.LENGTH_SHORT).show()
    }
}