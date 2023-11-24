package com.example.holamundo2


fun main(){
    val a: Int = 5
    val b = 10
    val c = mayor(a,b)
    for(i in 0..c)
        println(i)

    var j = 1
    while(j/5!=3){
        j++;
    }
    println(j)


    when(j){
        15 -> println ("yup")
        else -> println ("a")
    }
    for(i  in 0..10 step 2)
        println("eeee $i")

    for(i in 10 downTo 0 step 2)
        println("abajo $i")


    print("dime el numero que quieras para la tabla")
    var num = readln().toInt()
    for(i in 1..10)
        println("$num * $i = "+(num*i))


    println("Ingrese el sueldo del empleado")
    val sueldo = readln().toDouble()
    if(sueldo > 3000)
        println("Ha de pagar impuestos, bro...")

    println("Dime tu nota.")
    val nota = readln().toFloat()
    if (nota == 10f)
        println("ole un 10")
    else if(nota > 10)
        println("mentira")
    else if(nota > 9f)
        println("notable")
    else if(nota > 8f)
        println("casi")
    else if(nota > 7f)
        println("muy mal")
    else
        println("suspenso")


    //Ej 2
    println("Dime un número entero...")
    val num1 = readln().toInt()
    println("Dime otro...")
    val num2 = readln().toInt()
    println("el mayor es " + mayor(num1, num2))


}

fun mayor(a: Int, b: Int): Int{

    return if(a>b) a else b
}


