package com.qualentum.sprint2.data

val areaDivider: Int = 2

fun regularPolygonArea(apotem: Double, perimeter: Double): Double {
    return perimeter * apotem / areaDivider
}

fun regularPolygonAreaFormula(apotem: Double, perimeter: Double): String {
    return "Perimetro ($perimeter) * apotema ($apotem) / $areaDivider"
}

fun regularPolygonPerimeter(side: Double, nSides: Int): Double {
    return side * nSides
}

fun regularPolygonPerimeterFormula(side: Double, nSides: Int): String {
    return "Suma de sus lados ($nSides) * ($side)"
}