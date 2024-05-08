package com.qualentum.sprint2.domain

import com.qualentum.sprint2.data.PolygonTypes

class PolygonFactory(
    val type: String,
    val side: Double,
    val apotem: Double
) {

    fun calculateArea(): Double {
        return when (type){
            PolygonTypes.Triangle.polygonType -> Triangle(apotem, side).calculateArea()
            PolygonTypes.Pentagon.polygonType -> Pentagon(apotem, side).calculateArea()
            else -> { Octagon(apotem, side).calculateArea() }
        }
    }

    fun calculatePerimeter(): Double {
        return when (type){
            PolygonTypes.Triangle.polygonType -> Triangle(apotem, side).calculatePerimeter()
            PolygonTypes.Pentagon.polygonType -> Pentagon(apotem, side).calculatePerimeter()
            else -> { Octagon(apotem, side).calculatePerimeter() }
        }
    }

    fun showPerimeterFormula(): String{
        return when (type) {
            PolygonTypes.Triangle.polygonType -> Triangle(apotem, side).buildPerimeterFormula()
            PolygonTypes.Pentagon.polygonType -> Pentagon(apotem, side).buildPerimeterFormula()
            else -> { Octagon(apotem, side).buildPerimeterFormula() }
        }
    }

    fun showAreaFormula(): String{
        return when (type) {
            PolygonTypes.Triangle.polygonType -> Triangle(apotem, side).buildAreaFormula()
            PolygonTypes.Pentagon.polygonType -> Pentagon(apotem, side).buildAreaFormula()
            else -> { Octagon(apotem, side).buildAreaFormula() }
        }
    }
}