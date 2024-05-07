package com.qualentum.sprint2.domain

import com.qualentum.sprint2.data.regularPolygonPerimeter

class Triangle(
    val base: Double,
    val height: Double
): Polygon {
    val nSides = 3
    override fun calculatePerimeter(): Double {
        return regularPolygonPerimeter(base, nSides)
    }

    override fun calculateArea(): Double {
        return base * height / 2
    }
}