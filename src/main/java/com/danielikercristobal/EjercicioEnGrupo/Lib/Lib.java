package com.danielikercristobal.EjercicioEnGrupo.Lib;

import java.util.Random;
import java.util.Scanner;

public class Lib {
    private static final Scanner lector = new Scanner(System.in);
    public static String leerLinea() {
        return lector.nextLine();
    }
    public static int leerInt() {
        return Integer.parseInt(leerLinea());
    }
    public static double leerDouble() {
        return Double.parseDouble(leerLinea());
    }
    public static float leerFloat() {
        return Float.parseFloat(leerLinea());
    }
    public static char leerChar(){
        return lector.next().charAt(0);
    }
    public static int numeroAleatorio(int MIN, int MAX){
        Random r = new Random();
        return r.nextInt(MAX - MIN + 1) + MIN;
    }
    public static double numeroAleatorioDouble(int MIN, int MAX){
        Random r = new Random();
        return r.nextDouble() * (MAX - MIN + 1) + MIN;
    }

    public void espera(int x){
        try {
            Thread.sleep(x);
        }catch (InterruptedException ie){

        }
    }
}
