package com.example.lab7

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.lab7.clases.adaptadorr
import com.example.lab7.clases.cartillas
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import java.util.ArrayList


//NOTA:
// esta información fue estraida de :
//Kanojia, R. K. (s.f.). https://tutorial.eyehunts.com. Obtenido de https://tutorial.eyehunts.com: https://tutorial.eyehunts.com/android/recyclerview-android-example-cardview-kotlin/Rohit Kumar Kanojia


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    //declaramos nuestros elementos necesarios como listas y el mismo recicle para trabajar
    public var listaRecicle:RecyclerView?=null
    public var miAdaptador:RecyclerView.Adapter<*>?=null
    var listaProductosx :ArrayList<cartillas> =ArrayList()
    //lo necesitamos para almacenarlo
    var prelistaProductosx :ArrayList<String> =ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         for (i in 0..20){
           val cartillax:cartillas
          cartillax=cartillas()
            val intentoCero:Intent=intent

         var nombre="cajas $i"
            var codigo="1234"
           var cantidadw=i
           cartillax.cantidad=cantidadw
           cartillax.nombre=nombre
              cartillax.codigow=codigo
             listaProductosx!!.add(cartillax)
           }
       // para agregar elementos a lista

            listaRecicle=findViewById(R.id.recicleVista)
         var mLayountManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
         listaRecicle!!.layoutManager=mLayountManager
            miAdaptador=adaptadorr(listaProductosx)
         listaRecicle!!.adapter=miAdaptador

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }


    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.np -> {
                Toast.makeText(this, "Nuevo producto seleccionado", Toast.LENGTH_LONG).show()
                val tryOne= Intent(this,agregar_productos::class.java)
                startActivity(tryOne)

                return super.onOptionsItemSelected(item)

            }
            R.id.rl -> {


                Toast.makeText(this, "reinicio de lista selecccionado ", Toast.LENGTH_LONG).show()
                listaRecicle=findViewById(R.id.recicleVista)
                var mLayountManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
                listaRecicle!!.layoutManager=mLayountManager
                listaProductosx.clear()
                miAdaptador=adaptadorr(listaProductosx)
                listaRecicle!!.adapter=miAdaptador



                return super.onOptionsItemSelected(item)
            }
            R.id.ia -> {
                Toast.makeText(this, "Inventario actual seleccionado ", Toast.LENGTH_LONG).show()

                //agregamos codigo para listas de invetnario
                return super.onOptionsItemSelected(item)
            }
            R.id.ac -> {
                Toast.makeText(this, "Actualización completa", Toast.LENGTH_LONG).show()

                //agregamos codigo para listas de invetnario
                return super.onOptionsItemSelected(item)
            }


            else -> return super.onOptionsItemSelected(item)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_inventario -> {
                // Handle the camera action
            }
            R.id.nav_producto -> {

            }
            R.id.scanear_producto -> {

                val escaner = IntentIntegrator(this)
                //corremos el proceso de scanner
                escaner.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                escaner.initiateScan()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (resultCode == Activity.RESULT_OK) {
            val resultado = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            //agregamos programación defensiva basica, basada en cita superior
            if (resultado != null) if (resultado.contents != null) {
                //mostramos en texto de notificación el codigo leido
                Toast.makeText(this, "codigo escaneado es " + resultado.contents, Toast.LENGTH_LONG).show()
            }

        }

    }


}
