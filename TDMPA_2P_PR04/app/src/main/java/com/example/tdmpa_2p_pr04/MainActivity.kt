package com.example.tdmpa_2p_pr04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chpGroup =  findViewById<ChipGroup>(R.id.chpGroup)
        val chpRefresco = findViewById<Chip>(R.id.chpRefresco)
        val chpPollo = findViewById<Chip>(R.id.chpPollo)
        val chpHamburguesa = findViewById<Chip>(R.id.chpHamburguesa)
        val chpPasta = findViewById<Chip>(R.id.chpPasta)
        val chpPizza = findViewById<Chip>(R.id.chpPizza)

        val btnMinusRefresco = findViewById<ImageButton>(R.id.btnMinusRefresco)
        val btnMinusPollo = findViewById<ImageButton>(R.id.btnMinusPollo)
        val btnMinusHamburguesa = findViewById<ImageButton>(R.id.btnMinusHamburguesa)
        val btnMinusPasta = findViewById<ImageButton>(R.id.btnMinusPasta)
        val btnMinusPizza = findViewById<ImageButton>(R.id.btnMinusPizza)
        val btnPlusRefresco = findViewById<ImageButton>(R.id.btnPlusRefresco)
        val btnPlusPollo = findViewById<ImageButton>(R.id.btnPlusPollo)
        val btnPlusHamburguesa = findViewById<ImageButton>(R.id.btnPlusHamburguesa)
        val btnPlusPasta = findViewById<ImageButton>(R.id.btnPlusPasta)
        val btnPlusPizza = findViewById<ImageButton>(R.id.btnPlusPizza)

        val txtInstruccionesExtras = findViewById<EditText>(R.id.txtInstruccionesExtras)
        val chpExtras = findViewById<ChipGroup>(R.id.chpExtras)

        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        btnMinusRefresco.setOnClickListener{
            restarUnoRefresco()
        }
        btnPlusRefresco.setOnClickListener{
            sumaUnoRefresco()
        }

        btnMinusPollo.setOnClickListener{
            restarUnoPollo()
        }
        btnPlusPollo.setOnClickListener{
            sumaUnoPollo()
        }

        btnMinusHamburguesa.setOnClickListener{
            restarUnoHamburguesas()
        }
        btnPlusHamburguesa.setOnClickListener{
            sumaUnoHamburguesas()
        }

        btnMinusPasta.setOnClickListener{
            restarUnoPasta()
        }
        btnPlusPasta.setOnClickListener{
            sumaUnoPasta()
        }

        btnMinusPizza.setOnClickListener{
            restarUnoPizza()
        }
        btnPlusPizza.setOnClickListener{
            sumaUnoPizza()
        }

        chpRefresco.setOnClickListener{
            modificarLista(chpRefresco, contadorRefresco)
        }
        chpPollo.setOnClickListener{
            modificarLista(chpPollo, contadorPollo)
        }
        chpHamburguesa.setOnClickListener{
            modificarLista(chpHamburguesa, contadorHamburguesas)
        }
        chpPasta.setOnClickListener{
            modificarLista(chpPasta, contadorPasta)
        }
        chpPizza.setOnClickListener{
            modificarLista(chpPizza, contadorPizza)
        }

        txtInstruccionesExtras.setOnKeyListener{_,keyCode,event->
            if(event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                agregarChip(txtInstruccionesExtras.text.toString())
                return@setOnKeyListener true
            }
            false
        }
    }

    var contadorRefresco = 0
    fun sumaUnoRefresco(){
        contadorRefresco++
        actualizarCantidadRefresco()
    }

    fun restarUnoRefresco(){
        if (contadorRefresco > 0) {
            contadorRefresco--
            actualizarCantidadRefresco()
        }
    }

    fun actualizarCantidadRefresco(){
        val txtCantidadRefresco = findViewById<TextView>(R.id.txtCantidadRefresco)
        txtCantidadRefresco.text = contadorRefresco.toString()
    }

    var contadorPollo = 0
    fun sumaUnoPollo(){
        contadorPollo++
        actualizarCantidadPollo()
    }

    fun restarUnoPollo(){
        if (contadorPollo > 0) {
            contadorPollo--
            actualizarCantidadPollo()
        }
    }

    fun actualizarCantidadPollo(){
        val txtCantidadPollo = findViewById<TextView>(R.id.txtCantidadPollo)
        txtCantidadPollo.text = contadorPollo.toString()
    }

    var contadorHamburguesas = 0
    fun sumaUnoHamburguesas(){
        contadorHamburguesas++
        actualizarCantidadHamburguesas()
    }

    fun restarUnoHamburguesas(){
        if (contadorHamburguesas > 0) {
            contadorHamburguesas--
            actualizarCantidadHamburguesas()
        }
    }

    fun actualizarCantidadHamburguesas(){
        val txtCantidadHamburguesa = findViewById<TextView>(R.id.txtCantidadHamburguesa)
        txtCantidadHamburguesa.text = contadorHamburguesas.toString()
    }

    var contadorPasta = 0
    fun sumaUnoPasta(){
        contadorPasta++
        actualizarCantidadPasta()
    }

    fun restarUnoPasta(){
        if (contadorPasta > 0) {
            contadorPasta--
            actualizarCantidadPasta()
        }
    }

    fun actualizarCantidadPasta() {
        val txtCantidadPasta = findViewById<TextView>(R.id.txtCantidadPasta)
        txtCantidadPasta.text = contadorPasta.toString()


    }

    var contadorPizza = 0
    fun sumaUnoPizza(){
        contadorPizza++
        actualizarCantidadPizza()
    }

    fun restarUnoPizza(){
        if (contadorPizza > 0) {
            contadorPizza--
            actualizarCantidadPizza()
        }
    }

    fun actualizarCantidadPizza() {
        val txtCantidadPizza = findViewById<TextView>(R.id.txtCantidadPizza)
        txtCantidadPizza.text = contadorPizza.toString()

    }


    val arrayProductos = arrayOf("Refresco                                 $15", "Pollo                                       $90", "Hamburguesa                        $70", "Pasta                                      $85", "Pizza                                      $150")
    val arrayPrecios = arrayOf(15, 90, 70, 85, 150)
    var detallesOrden:MutableList<String> = mutableListOf()

    var totalOrden = 0

    fun actualizarTotal() {
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val txtDetallesTotal = findViewById<TextView>(R.id.txtDetallesTotal)
        txtTotal.text = "$" + "$totalOrden" + ".0"
    }

    fun modificarLista(chip: Chip, cantidad: Int) {
        val txtCantidadPizza = findViewById<TextView>(R.id.txtCantidadPizza)
        val txtCantidadHamburguesa = findViewById<TextView>(R.id.txtCantidadHamburguesa)
        val txtCantidadRefresco = findViewById<TextView>(R.id.txtCantidadRefresco)
        val txtCantidadPollo = findViewById<TextView>(R.id.txtCantidadPollo)
        val txtCantidadPasta = findViewById<TextView>(R.id.txtCantidadPasta)
        val txtDetallesTotal = findViewById<TextView>(R.id.txtDetallesTotal)
        val itemNombre = chip.text.toString()
        val itemCantidad = "$cantidad $itemNombre"

        val precioPorUnidad = obtenerPrecioPorNombre(itemNombre)
        val precioTotalPorItem = precioPorUnidad * cantidad

        if (chip.isChecked) {
            detallesOrden.add("$itemCantidad: $precioTotalPorItem")
            totalOrden += precioTotalPorItem
        } else {
            detallesOrden.removeAll { it.contains(itemCantidad) }
            detallesOrden.removeAll { it.contains(itemNombre) }

            totalOrden -= precioTotalPorItem

            if(txtCantidadPizza.text == "0"){
                txtCantidadPizza.text = "0"
                contadorPizza = 0
            }
            if(txtCantidadPasta.text == "0"){
                txtCantidadPasta.text = "0"
                contadorPasta = 0
            }
            if(txtCantidadHamburguesa.text == "0"){
                txtCantidadHamburguesa.text = "0"
                contadorHamburguesas = 0
            }
            if(txtCantidadPollo.text == "0"){
                txtCantidadPollo.text = "0"
                contadorPollo = 0
            }
            if(txtCantidadRefresco.text == "0"){
                txtCantidadRefresco.text = "0"
                contadorRefresco = 0
            }

        }

        txtDetallesTotal.text = detallesOrden.joinToString("\n\n")
        actualizarTotal()
    }
    
    fun obtenerPrecioPorNombre(nombre: String): Int {
        val index = arrayProductos.indexOf(nombre)
        if (index != -1) {
            return arrayPrecios[index]
        }
        return 0
    }

    private fun agregarChip(instruccion: String){
        val txtDetallesTotal = findViewById<TextView>(R.id.txtDetallesTotal)
        val chip = Chip(this@MainActivity)
        chip.text = instruccion
        chip.isClickable = true
        chip.isCheckable = false
        val chpExtras = findViewById<ChipGroup>(R.id.chpExtras)
        detallesOrden.add("$instruccion")
        chpExtras.addView(chip as View)
        chip.setOnClickListener{
            detallesOrden.removeAll { it.contains(chip.text.toString()) }
            chpExtras.removeView(chip as View)
            txtDetallesTotal.text = detallesOrden.joinToString("\n\n")

        }
        txtDetallesTotal.text = detallesOrden.joinToString("\n\n")
    }

    fun resetearCantidades(){
        val txtCantidadPizza = findViewById<TextView>(R.id.txtCantidadPizza)
        val txtCantidadHamburguesa = findViewById<TextView>(R.id.txtCantidadHamburguesa)
        val txtCantidadRefresco = findViewById<TextView>(R.id.txtCantidadRefresco)
        val txtCantidadPollo = findViewById<TextView>(R.id.txtCantidadPollo)
        val txtCantidadPasta = findViewById<TextView>(R.id.txtCantidadPasta)

        txtCantidadPizza.text = "0"
        txtCantidadHamburguesa.text = "0"
        txtCantidadRefresco.text = "0"
        txtCantidadPollo.text = "0"
        txtCantidadPasta.text = "0"


    }

}