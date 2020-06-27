package com.test.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setText(str: String) {
        if (tv_result.text.isNotEmpty()) {
            tv_math.text = tv_result.text
            tv_result.text = ""
        }
        tv_math.append(str)
    }

    fun setText(view: View) {
        val button:Button = view as Button
        setText(button.text.toString())
    }

    fun backButton(view:View){
        var str = tv_math.text.toString()
        if (tv_math.text.isNotEmpty()) {
            tv_math.text = str.substring(0, str.length - 1)
        }
        tv_result.text = ""
    }

    fun acButton(view:View){
        tv_math.text = ""
        tv_result.text = ""
    }

    fun equals(view:View){
        try {
            val ex = ExpressionBuilder(tv_math.text.toString()).build()
            val result = ex.evaluate()
            val resultLong = result.toLong()
            if (result == resultLong.toDouble()) {
                tv_result.text = resultLong.toString()
            } else {
                tv_result.text = result.toString()
            }
        } catch (e: Exception) {
//            tv_result.text = e.message
            tv_result.text = getString(R.string.failed)
        }
    }
}
