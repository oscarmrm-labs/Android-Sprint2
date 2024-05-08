package com.qualentum.sprint2.domain

import com.qualentum.sprint2.data.regularPolygonArea
import com.qualentum.sprint2.data.regularPolygonAreaFormula
import com.qualentum.sprint2.data.regularPolygonPerimeter
import com.qualentum.sprint2.data.regularPolygonPerimeterFormula

class Octagon(
    val apotem: Double,
    val side: Double,
): Polygon {

    val nSides: Int = 8

    override fun calculatePerimeter(): Double {
        return regularPolygonPerimeter(side, nSides)
    }

    override fun calculateArea(): Double {
        val perimeter: Double = calculatePerimeter()
        return regularPolygonArea(apotem, perimeter)
    }


    override fun buildPerimeterFormula(): String {
        return regularPolygonPerimeterFormula(side, nSides)
    }

    override fun buildAreaFormula(): String {
        val perimeter: Double = calculatePerimeter()
        return regularPolygonAreaFormula(apotem, perimeter)
    }
}