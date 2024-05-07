package com.qualentum.sprint2.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.qualentum.sprint2.R
import com.qualentum.sprint2.data.PolygonTypes
import com.qualentum.sprint2.domain.PolygonFactory

class PolygonDetail : AppCompatActivity() {
    lateinit var polygonType: String
    lateinit var image: ImageView
    var etApotem: EditText? = null
    var etSide: EditText? = null
    var tvArea: TextView? = null
    var tvPerimeter: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_polygon_detail)
        getBundle()

        etApotem = findViewById(R.id.etApotem)
        etSide = findViewById(R.id.etSide)
        initImage()
        tvArea = findViewById(R.id.tvArea)
        tvPerimeter = findViewById(R.id.tvPerimeter)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        btnCalculate.setOnClickListener(View.OnClickListener {
            createButton()
        })
    }

    fun getBundle(){
        val bundle = intent.extras
        polygonType = bundle?.getString("type").toString()
    }

    private fun initImage(){
        image = findViewById(R.id.imageView)
        image.setImageResource(showImage())
    }

    private fun showImage(): Int {
        return when (polygonType) {
            PolygonTypes.Triangle.polygonType -> {
                etSide?.hint = "Base"
                etApotem?.hint = "Altura"
                R.drawable.triangulo_sinfondo
            }
            PolygonTypes.Pentagon.polygonType -> R.drawable.pentagono_sinfondo
            else -> R.drawable.octogono_sinfondo
        }
    }

    fun createButton(){
        if (etSide?.text.isNullOrBlank() or etApotem?.text.isNullOrEmpty() or
                etSide?.text.toString().equals("0") or etApotem?.text.toString().equals("0")){
            Toast.makeText(this, "Los campos no pueden ser vacios o '0'", Toast.LENGTH_SHORT).show()
        } else {
            var polygon = PolygonFactory(
                    type = polygonType,
                    side = etSide!!.toDouble(),
                    apotem =  etApotem!!.toDouble()
                    //side = etSide?.text.toString().toDouble(),
                    //apotem = etApotem?.text.toString().toDouble()
                )
            tvArea?.text = "Area: " + polygon?.calculateArea().toString()
            tvPerimeter?.text = "Perimetro: " + polygon?.calculatePerimeter().toString()
            //Toast.makeText(this, "figura creada: " + polygon.calculateArea(), Toast.LENGTH_SHORT).show()
        }
    }
}