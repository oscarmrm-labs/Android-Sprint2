package com.qualentum.sprint2.ui

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.qualentum.sprint2.R
import com.qualentum.sprint2.data.PolygonTypes
import com.qualentum.sprint2.domain.PolygonFactory

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
        btnCalculate.setOnClickListener{
            actionCalculateButton()
        }
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
        (tieSide?.text.toString() == "0") or (tieApotem?.text.toString() == "0")){
            showError()
            clearFormulas()
        } else {
            clearErrors()
            buildAreaAndPerimeter(buildPolygon())
        }
        clearErrors()
    }

    private fun buildPolygon() = PolygonFactory(
        type = polygonType,
        side = tieSide!!.toDouble(),
        apotem = tieApotem!!.toDouble()
    )

    fun buildAreaAndPerimeter(polygon: PolygonFactory){
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

    private fun showError() {
        if (tieSide?.text.isNullOrBlank() or (tieSide?.text.toString() == "0")) {
            if (polygonType == PolygonTypes.Triangle.polygonType) {
                tilSide?.error = "La base no puede ser vacía o '0'"
            } else {
                tilSide?.error = "El lado no puede ser vacío o '0'"
            }
        }
        if (tieApotem?.text.isNullOrBlank() or (tieApotem?.text.toString() == "0")) {
            if (polygonType == PolygonTypes.Triangle.polygonType){
                tilApotem?.error = "La altura no puede ser vacía o '0'"
            } else {
                tilApotem?.error = "El apotema no puede ser vacío o '0'"
            }
        }
    }

    fun clearErrors(){
        if (!tieSide?.text.isNullOrBlank() and (tieSide?.text.toString() != "0")) tilSide?.error = null
        if (!tieApotem?.text.isNullOrBlank() and (tieApotem?.text.toString() != "0")) tilApotem?.error = null
    }

    fun clearFormulas(){
        tvArea?.text = ""
        tvPerimeter?.text = ""
    }
}