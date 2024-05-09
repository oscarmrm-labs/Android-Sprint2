package com.qualentum.sprint2.domain

interface Polygon {
    fun calculatePerimeter(): Double
    fun calculateArea(): Double

    fun buildPerimeterFormula() :String
    fun buildAreaFormula() :String
}