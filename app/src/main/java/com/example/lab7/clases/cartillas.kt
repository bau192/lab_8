package com.example.lab7.clases

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.lab7.R
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.productoss.*
public var cantidadq:Int=0

//nuestra cartilla debe tener nombre de producto y cantidad
class  cartillas: AppCompatActivity()  {
    //elementos de los card view
    var nombre: String? = null
    var codigow: String? =null
    var cantidad: Int = 3


//intentamos modificar el valor de cantidad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_productos)

        botonMas.setOnClickListener(View.OnClickListener {

            //tratamos de sumar el valor a la variable
            cantidadq=cantidad
            cantidadq=cantidadq+1;
            textoCodigo.text=cantidadq.toString();
        })

        botonMenos.setOnClickListener(View.OnClickListener {
            //tratamos de restar el valor de la variable
            cantidadq=cantidad

            if(cantidadq>0) {
                cantidadq = cantidadq -1;
                textoCodigo.text = cantidadq.toString();
            }
        })
    }

}




