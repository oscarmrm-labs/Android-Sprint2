package com.qualentum.sprint2.domain

import com.qualentum.sprint2.data.regularPolygonPerimeter
import com.qualentum.sprint2.data.regularPolygonPerimeterFormula

class Triangle(
    val height: Double,
    val base: Double
): Polygon {
    val nSides = 3
    override fun calculatePerimeter(): Double {
        return regularPolygonPerimeter(base, nSides)
    }

    override fun calculateArea(): Double {
        return base * height / 2
    }


    override fun buildPerimeterFormula(): String {
        return regularPolygonPerimeterFormula(base, nSides)
    }

    override fun buildAreaFormula(): String {
        return "Base ($base) * Altura ($height) / 2"
    }
}