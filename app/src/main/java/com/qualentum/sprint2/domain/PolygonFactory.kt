package com.qualentum.sprint2.domain

import com.qualentum.sprint2.data.PolygonTypes

class PolygonFactory(
    val type: String,
    val side: Double,
    val apotem: Double
) {

    fun calculateArea(): Double {
        return when (type){
            PolygonTypes.Triangle.polygonType -> Triangle(side, apotem).calculateArea()
            PolygonTypes.Pentagon.polygonType -> Pentagon(side, apotem).calculateArea()
            else -> { Octagon(side, apotem).calculateArea() }
        }
    }

    fun calculatePerimeter(): Double {
        return when (type){
            PolygonTypes.Triangle.polygonType -> Triangle(side, apotem).calculatePerimeter()
            PolygonTypes.Pentagon.polygonType -> Pentagon(side, apotem).calculatePerimeter()
            else -> { Octagon(side, apotem).calculatePerimeter() }
        }
    }
}