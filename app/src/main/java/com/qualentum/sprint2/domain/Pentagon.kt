package com.qualentum.sprint2.domain

import com.qualentum.sprint2.data.regularPolygonArea
import com.qualentum.sprint2.data.regularPolygonPerimeter

class Pentagon (
    val apotem: Double,
    val side: Double
): Polygon {

    val nSides = 5
    override fun calculatePerimeter(): Double {
        return regularPolygonPerimeter(side, nSides)
    }

    override fun calculateArea(): Double {
        val perimeter: Double = calculatePerimeter()
        return regularPolygonArea(apotem, perimeter)
    }
}