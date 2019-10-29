package com.example.calculatorvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState!=null){
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tv_result.text = result
        }

        btn_calculate.setOnClickListener(this)
    }

    companion object{
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tv_result.text.toString())
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate){
            val inputLength = et_length.text.toString().trim()
            val inputWidth = et_width.text.toString().trim()
            val inputHeight = et_height.text.toString().trim()
            //trim = biar kalo user misal masukin spaci, dia g bakal ke detect selain objek utama

            var isEmptyFields = false
            val errorMessage = "Field is not value"

            if (inputLength.isEmpty()){
                isEmptyFields = true
                et_length.error = errorMessage
            }
            if (inputWidth.isEmpty()){
                isEmptyFields = true
                et_width.error = errorMessage
            }
            if (inputHeight.isEmpty()){
                isEmptyFields = true
                et_height.error = errorMessage
            }

            if (!isEmptyFields){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                //double = karena tipe int tidak bisa menampung banyak angka jika jumlahnya terlalu banyak
                //cuma sampe 2 pangkat 6
                //tipe paling besar itu float

                tv_result.text = volume.toString() //untuk nampilin jumlahny dgn tipe string
            }

        }
    }

}
