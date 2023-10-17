package org.example;


import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        //Ejercicio 1
        Scanner sca = new Scanner(System.in);

        String input;

        while(true){
            System.out.println("Dime un nombre para la carrera. Ha de empezar por vuelta y estar compuesto de al menos 3 palabras.");
            input = sca.nextLine().trim();
            if(!input.toUpperCase().startsWith("VUELTA")){
                System.out.println("No empieza por vuelta...");
                continue;
            }
            //C bros....
            char comprobar[] = input.toCharArray();
            int espacios = 0;
            boolean trampa = true;
            for(int i = 6; i < comprobar.length; i++) {
                //Esto es basicamente para que nadie pueda llamar a su vuelta algo con dos espacios seguidos, en plan "vuelta       aaaaa"

                if (!(comprobar[i] == ' ')){
                    trampa = true;
                }
                else if(comprobar[i] == ' '&&trampa) {
                    espacios++;
                    trampa = false;
                }
            }
            if(espacios<2){
                System.out.println("Lo siento, faltan espacios");
                continue;
            }

            break;
        }

       //Ejercicio 2
        input = input.toUpperCase();
        System.out.println("El nombre que has elegido es "+input);
        //Ejercicio 3 (libre interpretación ya que contradice el ejercicio anterior pero bueno)
        char comprobar[] = input.toCharArray();
        int cuenta = 0;
        for(int i = 0; i< comprobar.length; i++){
            //Uso este método de java en lugar de implementarlo yo mismo ya que este incluye caracteres acentuados y la ñ, y el ejercicio dice que asumamos que estará en español
            //Si fuese a implementarlo yo mismo, sería algo como if(!(char >= 'A' && char <= 'Z')) y añadiendo la ñ y tildes y diéresis...
            if(!Character.isLetter(comprobar[i]))
                cuenta++;
        }
        System.out.println("El número de ¿caracteres? que no son letras ni mayúsculas... ni minúsculas???? es de "+cuenta);

        //Ejercicio 4
        int numInput;
        while(true){
            System.out.println("Dime el número de etapas que quiere que tenga la competición, en números enteros positivos.");
            try {
                numInput = Integer.parseInt(sca.nextLine());
                if (numInput > 0) {
                    break;
                } else {
                    System.out.println("El número de etapas debe ser mayor que 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número...");
            }

        }
        short etapas[] = new short[numInput];
        //Ejercicio 5
        Random rng = new Random();
        for(int i = 0; i <etapas.length;i++){
            etapas[i] = (short)rng.nextInt(80,201);
        }
        //Ejercicio 6
        long km = 0;
        /*
        for(int i = 0; i <etapas.length;i++){
            km += etapas[i];
        }
        System.out.println("El total de kilómetros a recorrer es de "+km);*/

        //Ejercicio 7
        //Es imposible que salga lo mismo que con la función del 6 ya que se nos pide que la comentemos, y es aleatoria...
        //Se nos pide que devolvamos un short, pero es casi seguro que se va a pasar si se pone un número grande, así que devolveré un long.
        //En ningún sitio se nos pone que limitemos el número del input.
        long copia[] = new long[etapas.length];
        for (int i = 0; i < etapas.length; i++) {
            copia[i] = etapas[i];
        }

        System.out.println("La cantidad total de kilómetros es de "+cuentaKilometros(copia));

        //Ejercicio 8
        //Para este sí puedo usar los shorts perfectamente, sí.
        System.out.println("La etapa más larga es de "+etapaMasLarga(etapas)+" km");

        //Ejercicio 9
        String corredores[] = new String[etapas.length+1]; //Ok...

    }

    //Es esto eficiente? no, crear hasta 2 mil millones de arrays de long no es eficiente, pero me puse como prueba hacerlo usando un solo argumento, y eso he conseguido
    //No, no voy a hacer algo así en un programa de verdad
    public static long cuentaKilometros(long etapas[]){
        if (etapas.length == 1) {
            return etapas[0];
        }

        long recursivo[] = new long[etapas.length-1];
        recursivo[0] = etapas[0] + etapas[etapas.length-1];
        for (int i = 1; i < etapas.length - 1; i++) {
            recursivo[i] = etapas[i];
        }

        return cuentaKilometros(recursivo);
    }

    public static short etapaMasLarga(short etapas[]){
        short masLarga = etapas[0];

        for(int i = 1 ; i<etapas.length;i++){
            if (etapas[i]>masLarga)
                masLarga = etapas[i];
        }
        return masLarga;
    }


}