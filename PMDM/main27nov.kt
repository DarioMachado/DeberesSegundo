fun main(args: Array<String>) {


    println("dime un numero")
    val numero1 = readLine()?.toIntOrNull() ?: 0
    println("Dime otro número, bro...")
    val numero2 = readLine()?.toIntOrNull() ?: 0

    println("Su suma es esta: ${sumar(numero1, numero2)}")

    println("Su resta es esta: ${restar(numero1, numero2)}")

    println("Su multiplicación es esta: ${multiplicar(numero1, numero2)}")

    println("Su division es esta: ${dividir(numero1, numero2)}")

}
fun sumar(num1: Int, num2: Int): Int{
    return num1 + num2
}
fun restar(num1: Int, num2: Int): Int{
    return num1 - num2
}
fun multiplicar(num1: Int, num2: Int): Int{
    return num1 * num2
}
fun dividir(num1: Int, num2: Int): Int{
    return num1 / num2
}
