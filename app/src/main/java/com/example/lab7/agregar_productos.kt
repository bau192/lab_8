package com.example.lab7

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.lab7.clases.adaptadorr
import com.example.lab7.clases.cartillas
import kotlinx.android.synthetic.main.activity_agregar_productos.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_agregar_productos.*
import kotlinx.android.synthetic.main.productoss.*

class agregar_productos : AppCompatActivity() {

var listaProductosx :ArrayList<cartillas> =ArrayList()
    //lo necesitamos para almacenarlo
    var prelistaProductosx :ArrayList<String> =ArrayList()
    public var listaRecicle:RecyclerView?=null
    public var miAdaptador:RecyclerView.Adapter<*>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_productos)

        buttonCancelar.setOnClickListener(View.OnClickListener {
            //codigo para cancelar y regresar al menu
            val tryOne = Intent(this, MainActivity::class.java)
            startActivity(tryOne)
        })

        buttonGuardar.setOnClickListener(View.OnClickListener {
            //codigo para cancelar y regresar al menu
             //   val cartillax:cartillas
               // cartillax=cartillas()
             //   var nombre=textUnico.text.toString()
             //   var codigo=textoCodigo.text.toString()
            //    var cantidadw=0
             //   cartillax.cantidad=cantidadw
             //   cartillax.nombre=nombre
             //   cartillax.codigow=codigo
             //   listaProductosx!!.add(cartillax)

            // para agregar elementos a lista

           // listaRecicle=findViewById(R.id.recicleVista)
           // var mLayountManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
           // listaRecicle!!.layoutManager=mLayountManager
          //  miAdaptador= adaptadorr(listaProductosx)
          //  listaRecicle!!.adapter=miAdaptador


            prelistaProductosx.clear()
            prelistaProductosx

            val tryOne = Intent(this, MainActivity::class.java)
            startActivity(tryOne)
        })

    }
}
