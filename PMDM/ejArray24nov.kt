package com.example.holamundo2

fun main(){
    var arrayValores = arrayOf(1,2,3,4,5,6,7,8,9)
    for(i  in 0 until arrayValores.size step 2)
        println(arrayValores[i])

    var arrayValores2 = arrayOf("A", "B", "C")
    for (i in 0 until arrayValores2.size)
        println(arrayValores2[i])

    var arrayValores3 = arrayOf("Laura", 30, "Ana", 24)
    for(i in arrayValores3.size-1 downTo 0)
        println(arrayValores3[i])

    val arrayVacio = arrayOfNulls<String>(3)
    arrayVacio[0] = "Málaga"
    arrayVacio[1] = "Sevilla"
    arrayVacio[2] = "Cádiz"
    for (i in 0 until arrayVacio.size step 1) {
        println(arrayVacio[i])
    }

    var arrayPaises = arrayOf("Alemania", "Francia", "Italia")
    var arrayPaises2 = arrayPaises.copyOf(arrayPaises.size+2)
    arrayPaises2[3] = "España"
    arrayPaises2[4] = "Grecia"

    println("${arrayPaises2.joinToString(",") }")

    //Ejercicio 1, sumar todos los elementos de un array
    var arrayej1 = arrayOf(300,2313213,345345,31221,5)
    var suma = 0
    for(i in 0 until arrayej1.size)
        suma+=arrayej1[i]
    println(suma)

    //Ejercicio 2, calcular la media de un array
    var arrayej2 = arrayOf(30,455312,1,23,3232,334)
    suma = 0
    for(i in 0 until arrayej2.size)
        suma+=arrayej2[i]
    suma = suma/arrayej2.size
    println(suma)

    //Ejercicio 6
    var array2d = arrayOf(arrayOf(1,2,3), arrayOf("aaa", "ccc", -1))


    //ej
    var matrizej = arrayOf(arrayOf(12,15,21,45), arrayOf(14,25,15), arrayOf(23,24))
    println(matrizej[0][2])
    matrizej[0][2] = 50
    println(matrizej[0][2])
    matrizej[0].set(2,110)
    println(matrizej[0][2])
    println(matrizej[2][0])
    matrizej[2][0] = 90
    println(matrizej[2][0])
    matrizej[2].set(0,45)
    println(matrizej[2][0])




}