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
}