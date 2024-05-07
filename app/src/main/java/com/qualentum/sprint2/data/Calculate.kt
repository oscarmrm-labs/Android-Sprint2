package com.qualentum.sprint2.data

val areaDivider: Int = 2

fun regularPolygonArea(apotem: Double, perimeter: Double): Double {
    return perimeter * apotem / areaDivider
}

fun regularPolygonPerimeter(side: Double, nSides: Int): Double {
    return side * nSides
}