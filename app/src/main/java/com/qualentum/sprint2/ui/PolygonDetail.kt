package com.qualentum.sprint2.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.qualentum.sprint2.R
import com.qualentum.sprint2.data.PolygonTypes
import com.qualentum.sprint2.domain.PolygonFactory
import java.lang.StringBuilder

class PolygonDetail : AppCompatActivity() {
    lateinit var polygonType: String

    //layout
    lateinit var image: ImageView

    var tieApotem: TextInputEditText? = null
    var tieSide: TextInputEditText? = null
    var tilApotem: TextInputLayout? = null
    var tilSide: TextInputLayout? = null

    var tvArea: TextView? = null
    var tvPerimeter: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_polygon_detail)
        getBundle()
        joinIdsLayout()
        showImage()

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        btnCalculate.setOnClickListener(View.OnClickListener {
            actionCalculateButton()
        })
    }

    fun getBundle(){
        val bundle = intent.extras
        polygonType = bundle?.getString("type").toString()
    }

    private fun joinIdsLayout(){
        image = findViewById(R.id.imageView)

        tieApotem = findViewById(R.id.tieApotem)
        tieSide = findViewById(R.id.tieSide)
        tilApotem = findViewById(R.id.tilApotem)
        tilSide = findViewById(R.id.tilSide)

        tvArea = findViewById(R.id.tvArea)
        tvPerimeter = findViewById(R.id.tvPerimeter)
    }

    private fun showImage(){
        image.setImageResource(getImage())
    }

    private fun getImage(): Int {
        return when (polygonType) {
            PolygonTypes.Triangle.polygonType -> {
                tilSide?.hint = "Base"
                tilApotem?.hint = "Altura"
                R.drawable.triangulo_sinfondo
            }
            PolygonTypes.Pentagon.polygonType -> R.drawable.pentagono_sinfondo
            else -> R.drawable.octogono_sinfondo
        }
    }

    fun actionCalculateButton(){
        if (tieSide?.text.isNullOrBlank() or tieApotem?.text.isNullOrEmpty() or
                tieSide?.text.toString().equals("0") or tieApotem?.text.toString().equals("0")){
            // TODO: marcar los editTexts en rojo
            Toast.makeText(this, "Los campos no pueden ser vacios o '0'", Toast.LENGTH_SHORT).show()
        } else {
            var polygon = PolygonFactory(
                    type = polygonType,
                    side = tieSide!!.toDouble(),
                    apotem =  tieApotem!!.toDouble()
                )
            tvArea?.text = buildString {
                append("Area: ")
                append(polygon.showAreaFormula())
                append(" = ")
                append(polygon.calculateArea().toString())
            }
            tvPerimeter?.text = buildString {
                append("Perimetro: ")
                append(polygon.showPerimeterFormula())
                append(" = ")
                append(polygon.calculatePerimeter().toString())
            }

        }
    }
}