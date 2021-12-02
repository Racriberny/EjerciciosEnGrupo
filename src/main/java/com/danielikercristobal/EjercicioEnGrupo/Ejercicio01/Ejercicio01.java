package com.danielikercristobal.EjercicioEnGrupo.Ejercicio01;

import com.danielikercristobal.EjercicioEnGrupo.Lib.Lib;

public class Ejercicio01 {
    public void execute(){
        int opcion=0;
        do {
            opcion = menuPrincipal();
            switch (opcion){
                case 1:
                    juego(porrasPlayer,porrasCPU);
                    if(comprobarPorras(porrasPlayer, porrasCPU)) {
                        System.out.println("\nPlayer gana la partida!!! por " + porrasPlayer + " porras a " + porrasCPU +"\n");
                    } else {
                        System.out.println("\nCPU gana la partida!!! por " + porrasCPU + " porras a "+ porrasPlayer +"\n");
                    }
                    break;
            }

        }while (opcion !=0);


    }
    public static void main(String[] args) throws InterruptedException {
        final int DELAY = 500;
        final int VALOR_MIN = 1;
        final int VALOR_MAX = 6;
        boolean plantado = false;
        int tiradaPlayer;
        int puntosPlayer = 0;
        int porrasPlayer = 0;
        int tiradaCPU;
        int puntosCPU = 0;
        int porrasCPU = 0;
        int opcion;
        char plantarse;
        do {
            System.out.println("Jugador lanza el dado al aire ...");
            Lib.espera(DELAY);
            tiradaPlayer = Lib.numeroAleatorio(VALOR_MIN, VALOR_MAX);
            System.out.println("\n*****");
            System.out.println("* " + tiradaPlayer + " *");
            System.out.println("*****");
            puntosPlayer += tiradaPlayer;
            System.out.println("\nTu puntuación actual es " + puntosPlayer);
            if (puntosPlayer < 11) {
                System.out.print("¿Deseas plantarte con " + puntosPlayer + " puntos? (s/n): ");
                plantarse = Lib.leerLinea().charAt(0);
                plantado = plantarse == 's' || plantarse == 'S';
                if (plantado) {
                    plantado = false;
                    //Ahora la CPU intenta igualar o mejorar el resultado del jugador
                    while (puntosCPU < puntosPlayer) {
                        System.out.println("CPU lanza el dado al aire ...");
                        Lib.espera(DELAY);
                        tiradaCPU = Lib.numeroAleatorio(VALOR_MIN, VALOR_MAX);
                        System.out.println("\n?????");
                        System.out.println("? " + tiradaCPU + " ?");
                        System.out.println("?????\n");
                        puntosCPU += tiradaCPU;
                        System.out.println("La puntuación actual de la CPU es " + puntosCPU);
                    }
                    if (puntosCPU > 11) {
                        System.out.println("CPU se ha pasado. Porra para Player!!");
                        porrasPlayer++;
                        puntosCPU = 0;
                        puntosPlayer = 0;
                    } else if (puntosCPU > puntosPlayer) { // Gana CPU
                        if (puntosCPU == 11) {
                            System.out.println("\n$$$$$$$$$$$$$$$$");
                            System.out.println("$$$$ ¡ONCE! $$$$");
                            System.out.println("$$$$$$$$$$$$$$$$");
                            System.out.println("\nDoble porra para CPU\n");
                            porrasCPU += 2;
                        } else {
                            System.out.println("CPU ha mejorado tu puntuación. Porra para CPU!!");
                            porrasCPU++;
                        }
                        puntosCPU = 0;
                        puntosPlayer = 0;
                    } else { // Empate
                        System.out.println("Empate!! Porra para los dos");
                        puntosCPU = 0;
                        puntosPlayer = 0;
                        porrasCPU++;
                        porrasPlayer++;
                    }
                    System.out.println("\n**********************");
                    System.out.println("* " + porrasPlayer + " PLAYER  -  CPU " + porrasCPU + " *");
                    System.out.println("**********************");
                    Lib.intro();
                }
            } else if (puntosPlayer == 11) {
                //Al obtener 11 el jugador suma automáticamente 2 porras
                porrasPlayer += 2;
                puntosCPU = 0;
                puntosPlayer = 0;
                System.out.println("\n$$$$$$$$$$$$$$$$");
                System.out.println("$$$$ ¡ONCE! $$$$");
                System.out.println("$$$$$$$$$$$$$$$$");
                System.out.println("\n¡Bonificación! Doble porra");
                System.out.println("\n**********************");
                System.out.println("* " + porrasPlayer + " PLAYER  -  CPU " + porrasCPU + " *");
                System.out.println("**********************");
                Lib.intro();
            } else {
                //El jugador se ha pasado
                System.out.println("Ohh!! Te has pasado");
                System.out.println("Porra para la CPU");
                porrasCPU += 1;
                puntosCPU = 0;
                puntosPlayer = 0;
                System.out.println("\n**********************");
                System.out.println("* " + porrasPlayer + " PLAYER  -  CPU " + porrasCPU + " *");
                System.out.println("**********************");
                Lib.intro();
            }

        } while (porrasPlayer < 5 && porrasCPU < 5);

        if (comprobarPorras(porrasPlayer, porrasCPU)) {
            System.out.println("\nPlayer gana la partida!!! por " + porrasPlayer + " porras a " + porrasCPU + " de la CPU\n");
        } else {
            System.out.println("\nCPU gana la partida!!! por " + porrasCPU + " porras a " + porrasPlayer + " del player\n");
        }
    }

    public static int menuPrincipal(){
        int opcion;
        System.out.println("***************************");
        System.out.println("*** JUEGO DE DADOS ONCE ***");
        System.out.println("***************************");
        System.out.println("1. Nueva partida ...");
        System.out.println("0. Salir");
        System.out.print("\nElige una opción: ");
        opcion = Lib.leerInt();
        return opcion;
    }

    public static boolean comprobarPorras(int porrasPlayer, int porrasCPU){
        boolean ganador = false;
        //En caso de que gane la CPU, el método devolverá FALSE, en el caso de que gane el jugador, devolverá TRUE
        if(porrasCPU >= 5) {
            System.out.println("\nCPU gana la partida!!! por " + porrasCPU + " porras a "+ porrasPlayer +"\n");
            ganador = false;
        } else if(porrasPlayer >= 5) {
            ganador = true;
        }

        return ganador;
    }
}
