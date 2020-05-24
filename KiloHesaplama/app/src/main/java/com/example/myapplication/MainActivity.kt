package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    val mars_weight = 0.545
    val uranus_weight = 0.245
    val neptun_weight = 0.785
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Glide.with(this).load(R.drawable.uzay).into(imageView2);

        cb_mars.setOnClickListener(this)
        cb_neptün.setOnClickListener(this)
        cb_uranüs.setOnClickListener(this)


    }

    fun Double.format_cut(howmanynumber: Int) = java.lang.String.format("%.${howmanynumber}f", this)
    override fun onClick(v: View?) {

        var control = (v as CheckBox).isChecked

        if (!TextUtils.isEmpty(editKiloDegeri.text)) {
            when (v.id) {
                R.id.cb_mars -> if (control) {
                    cb_uranüs.isChecked = false
                    cb_neptün.isChecked = false
                    var x: Double = mars_weight * editKiloDegeri.text.toString().toDouble()
                    Result_Weight.text = x.format_cut(2).toString()

                }

                R.id.cb_uranüs -> if (control) {
                    cb_mars.isChecked = false
                    cb_neptün.isChecked = false

                    var x = neptun_weight * editKiloDegeri.text.toString().toDouble()
                    Result_Weight.text = x.format_cut(2).toString()
                }

                R.id.cb_neptün -> if (control) {
                    cb_mars.isChecked = false
                    cb_uranüs.isChecked = false

                    var x = uranus_weight * editKiloDegeri.text.toString().toDouble()
                    Result_Weight.text = x.format_cut(2).toString()
                }


            }
        }

    }


}
