package com.example.hw2_pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    var totalPrice = 0.0
    var toppingsPrice = 0.00
    var sizePrice = 0.00
    var deliveryPrice = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfPizza = listOf("Pepperoni", "Margarita", "Hawaiian", "BBQ Chicken")
        val myAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listOfPizza)
        pizza_list.adapter = myAdapter
        pizza_list.setOnItemClickListener { _, _, position, _ ->
            val images = when (position)
            {
                0 -> R.drawable.pepperoni
                1 -> R.drawable.margheritta
                2 -> R.drawable.hawaiian
                else -> R.drawable.bbq_chicken

            }
            imagePizza.setImageResource(images)
            pizza_type.text = when(position)
            {
                0 -> "Pepperoni"
                1 -> "Margarita"
                2 -> "Hawaiian"
                else -> "BBQ Chicken"
            }


        }
        updateTotal()
    }

    fun radioButton(view: View){
        sizePrice = when (view){
            radioMed -> 9.99
            radioLrg -> 13.99
            else -> 15.99
        }
        updateTotal()
    }

    fun deliveryButton(view: View){
        deliveryPrice = if(switchDelivery.isChecked)
            2.00
        else
            0.00
        updateTotal()
    }

    fun toppingsButton(view: View){
         toppingsPrice = 0.00
         if(checkCheese.isChecked)
            toppingsPrice += 1.69
        if(checkMush.isChecked)
            toppingsPrice += 1.69
        if(checkOni.isChecked)
            toppingsPrice += 1.69
        if(checkSpin.isChecked)
            toppingsPrice += 1.69
        if(checkBroc.isChecked)
            toppingsPrice += 1.69
        if(checkOli.isChecked)
            toppingsPrice += 1.69
        if(checkToma.isChecked)
            toppingsPrice += 1.69
        updateTotal()
    }

    fun clearTotal(view: View){
        totalPrice = 0.00
        if (radioMed.isChecked)
            radioMed.isChecked = false;

        if (radioLrg.isChecked)
            radioLrg.isChecked = false;

        if (radioXL.isChecked)
            radioXL.isChecked = false;

        if (checkCheese.isChecked)
            checkCheese.isChecked = false;

        if (checkMush.isChecked)
            checkMush.isChecked = false;

        if (checkOni.isChecked)
            checkOni.isChecked = false;

        if (checkSpin.isChecked)
            checkSpin.isChecked = false;

        if (checkBroc.isChecked)
            checkBroc.isChecked = false;

        if (checkOli.isChecked)
            checkOli.isChecked = false;

        if (checkToma.isChecked)
            checkToma.isChecked = false;

        if (switchDelivery.isChecked)
            switchDelivery.isChecked = false;


        total_price_box.text = (String.format("Total Price: $%.2f", totalPrice))
    }



        fun updateTotal() {
        totalPrice =  toppingsPrice + sizePrice + deliveryPrice
        total_price_box.text = (String.format("Total Price: $%.2f", totalPrice))
    }
}
