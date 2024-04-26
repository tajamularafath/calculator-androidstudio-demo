package com.example.calculatordemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import com.example.calculatordemo.databinding.ActivityMainBinding
import kotlin.time.Duration
import kotlin.time.Duration.Companion.parse

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding:ActivityMainBinding

    private val textWatcher : TextWatcher = object :TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            Log.d("beforeTextChange","beforeTextChange is start : $start , after: $after, s-> $s")
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//            Toast.makeText(this@MainActivity, s, Toast.LENGTH_SHORT).show()
            Log.d("onTextChange","onTextChange is start: $start. before: $before . s -> $s")
        }

        override fun afterTextChanged(s: Editable?) {
            Toast.makeText(this@MainActivity, s, Toast.LENGTH_SHORT).show()
            Log.i(s.toString(),"Here is the s")
            var num1 :String
            for(i in s.toString()){
                if (i != '+' && i != '-' && i != '*' && i != '/' && i != '%' ) {
                    num1 = s!!.first().toString()
                    if (num1.isNotEmpty()) {
                        num1 = num1 + i.toString()
                        println(num1)
                    }
                }
            }

//            if (s != null) {
//                if(s.equals("+") && (s.equals("-")) && (s.equals("*")) && (s.equals("/")) && s.equals("%")){
//
//
//                }


//            }
//            val num1 = s?.get(0)
//            println(num1)
//            Log.e(s?.get(num1).toString(), "This is a Number")
//            val operator1 = (s?.length ?: 1) -1
//                    Log.e(s?.get(operator1).toString(), "This is a Number")


//            for(i in s.toString()){
//            if (s != null) {
//                val operators = "+"
//                if (s.isDigitsOnly()) {
//                    val value1 = s
//                    Log.e(value1.toString(), "This is a Number")
//                } else (s.contains("@")){
//                    val operator1 = s
//                    Log.e(operator1.toString(), "This is a operator")
//                }
//            }
//
//
//                //            for(i in s.toString()){
//        //                if(i.equals(1) || i.equals(2)){
//        //
//        //                Log.e(i.toString(),"For Running")
//        //                }
//        ////                var total = 0
//        ////                total =total + i
//        //            }
//
//            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.etResult.showSoftInputOnFocus(false)

        binding.apply {
            btn7.setOnClickListener(this@MainActivity)
            btn8.setOnClickListener(this@MainActivity)
            btn9.setOnClickListener(this@MainActivity)
            btn4.setOnClickListener(this@MainActivity)
            btn5.setOnClickListener(this@MainActivity)
            btn6.setOnClickListener(this@MainActivity)
            btn1.setOnClickListener(this@MainActivity)
            btn2.setOnClickListener(this@MainActivity)
            btn3.setOnClickListener(this@MainActivity)
            btn0.setOnClickListener(this@MainActivity)
            btn00.setOnClickListener(this@MainActivity)
            btndot.setOnClickListener(this@MainActivity)
            btnErace.setOnClickListener(this@MainActivity)
            btnAC.setOnClickListener(this@MainActivity)
            btnPlus.setOnClickListener(this@MainActivity)
            btnMinus.setOnClickListener(this@MainActivity)
            btnMultiply.setOnClickListener(this@MainActivity)
            btndivision.setOnClickListener(this@MainActivity)
            btnequalto.setOnClickListener(this@MainActivity)
            btnModulus.setOnClickListener(this@MainActivity)
            etResult.addTextChangedListener(textWatcher)
        }

//        binding.btn7.setOnClickListener {
//            binding.etResult.setText("7")
//        }


    }

    override fun onClick(v: View?) {
        if (v != null) {
            when(v){

                binding.btn7 -> binding.etResult.append("7")
                binding.btn8 -> binding.etResult.append("8")
                binding.btn9 -> binding.etResult.append("9")
                binding.btn4 -> binding.etResult.append("4")
                binding.btn5 -> binding.etResult.append("5")
                binding.btn6 -> binding.etResult.append("6")
                binding.btn1 -> binding.etResult.append("1")
                binding.btn2 -> binding.etResult.append("2")
                binding.btn3 -> binding.etResult.append("3")
                binding.btn0 -> binding.etResult.append("0")
                binding.btn00 -> binding.etResult.append("00")
                binding.btndot -> binding.etResult.append(".")
                binding.btnMultiply -> binding.etResult.append("*")
                binding.btnPlus -> binding.etResult.append("+")
                binding.btnMinus -> binding.etResult.append("-")
                binding.btnModulus -> binding.etResult.append("%")
//                binding.btnequalto -> binding.etResult.append("=")
                binding.btndivision -> binding.etResult.append("/")
                binding.btnAC -> {
                    binding.etResult.text.clear()
                    binding.tvTotal.setText("")
                }
                binding.btnErace -> {
                    val text = binding.etResult.text.toString()
                    if (text.isNotEmpty()) {
                        val newText = text.substring(0, text.length - 1)
                        binding.etResult.setText(newText)
                        binding.etResult.setSelection(newText.length) // Move cursor to the end
                    }
                }
//                binding.btnPlus -> {
//                    val num = binding.etResult.text.toString().split("+")
//                    val num1: Duration = parse(num[0])
//                    val num2: Duration = parse(num[1])
//                    val addNum = num1 + num2
//                    binding.tvTotal.setText(addNum.toString())
//                    Log.e(addNum.toString()," <----------------------")
//                }

                binding.btnequalto -> {
                    val num = binding.etResult.text.split("+")
                    Log.e(num.toString(),"Here is the num")
                    var num1: Int = Integer.parseInt(num[0])
                    Log.e(num1.toString(),"num1")
                    val num2: Int = Integer.parseInt(num[1])
                    Log.e(num2.toString(),"num2")
                    val addNum = num1 + num2
                    binding.tvTotal.setText(addNum.toString())
                    Log.e(addNum.toString()," <----------------------")
                }

            }
        }
    }


}