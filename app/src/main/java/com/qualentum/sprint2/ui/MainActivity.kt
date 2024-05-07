package com.qualentum.sprint2.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.qualentum.sprint2.R
import com.qualentum.sprint2.data.PolygonTypes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTriangle: ImageButton = findViewById(R.id.btn_triangle)
        btnTriangle.setOnClickListener(View.OnClickListener {val intent = Intent(this, PolygonDetail::class.java)
            intent.putExtra("type", PolygonTypes.Triangle.polygonType)
            startActivity(intent)
        })

        val btnPentagon: ImageButton = findViewById(R.id.btn_pentagon)
        btnPentagon.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PolygonDetail::class.java)
            intent.putExtra("type", PolygonTypes.Pentagon.polygonType)
            startActivity(intent)
        })

        val btnOctagon: ImageButton = findViewById(R.id.btn_octagon)
        btnOctagon.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, PolygonDetail::class.java)
            intent.putExtra("type", PolygonTypes.Octagon.polygonType)
            startActivity(intent)
        })
    }
}