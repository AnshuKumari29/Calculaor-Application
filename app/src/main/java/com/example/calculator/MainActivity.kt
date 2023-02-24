package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var isNewOp = true
    var oldNumber = ""
    var op = "+"    //default value of operator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigit(view: View) {
        if(isNewOp)
            editText.setText(" ")
        isNewOp=false

        var btnClick :String= editText.text.toString()
        var btnSelect :Button = view as Button
        when(btnSelect.id)
        {
            btnOne.id -> { btnClick += "1"}
            btnTwo.id -> {btnClick += "2"}
            btnThree.id -> {btnClick += "3"}
            btnFour.id -> {btnClick += "4"}
            btnFive.id -> {btnClick += "5"}
            btnSix.id -> {btnClick += "6"}
            btnSeven.id -> {btnClick += "7"}
            btnEight.id ->{btnClick += "8"}
            btnNine.id -> {btnClick += "9"}
            btnZero.id -> {btnClick += "0"}
            btnDecimal.id -> {btnClick += "."}
            btnAdd.id -> {btnClick += "+"}
            btnDecimal.id -> {btnClick += "."}
        }
       editText.setText(btnClick)

    }

    fun onOperator(view: View) {
        isNewOp = true
        oldNumber= editText.text.toString()
        var btnSelect : Button= view as Button

        when (btnSelect.id)
        {
            btnMultiply.id ->{op = "*"}
            btnAdd.id ->{op = "+"}
            btnSubtract.id ->{op = "-"}
            btnDivide.id ->{op = "/" }
        }
    }


    fun equalEvent(view: View) {
        var newNumber = editText.text.toString()
        var result=0.0
        when(op)
        {
            "+" ->  {result= oldNumber.toDouble() + newNumber.toDouble()}
            "-" ->  {result= oldNumber.toDouble() - newNumber.toDouble()}
            "*" ->  {result= oldNumber.toDouble() * newNumber.toDouble()}
            "/" ->  {result= oldNumber.toDouble() / newNumber.toDouble()}
        }
        editText.setText(result.toString())
    }


    fun clearEvent(view: View) {
        editText.setText("0")
        isNewOp= true

    }

}