// Análisis (completar)
// Descripción del programa:
// Entradas:
// Salidas:
// Ejemplo:


package ui; // No olvidar especificar el paquete / carpeta de nuestro programa

import java.util.Scanner; // Para poder usar Scanner, debemos importarlo

public class AtlasPuntuaciones {

	 static Scanner escaner = new Scanner(System.in);
	public static void main(String[] args){
        
          System.out.println("Por favor, Ingrese la cantidad de jugadores: ");
        int Cantidad_Jugadores = escaner.nextInt();
        Verificar_Jugadores(Cantidad_Jugadores);

        System.out.println("Por favor, Ingrese la cantidad de rondas: ");
        int Cantidad_Rondas = escaner.nextInt();
        Verificar_Rondas(Cantidad_Rondas);

        int[] Jugadores = Jugadores(Cantidad_Jugadores);
        Jugadores = Puntaje_Rondas(Jugadores, Cantidad_Rondas);
        Resultado_Torneo(Jugadores);
        Puntuacion_Alta(Jugadores);
    }

    public static int[] Jugadores(int Cantidad_Jugadores) {
        int[] Jugadores = new int[Cantidad_Jugadores];
        return Jugadores;
    }

    public static int[] Puntaje_Rondas(int[] Jugadores, int Cantidad_Rondas) {
        for (int i = 0; i < Jugadores.length; i++) {
            Jugadores[i] = Guardar_Puntaje_Rondas(i, Cantidad_Rondas);
        }
        return Jugadores;
    }

    public static int Guardar_Puntaje_Rondas(int Jugador, int Cantidad_Rondas) {
        int Puntaje_Total = 0;
        for (int i = 0; i < Cantidad_Rondas; i++) {
            System.out.println("Ingrese el puntaje del jugador " + (Jugador + 1) + " en la ronda " + (i + 1) + ": ");
            Puntaje_Total += escaner.nextInt();
        }
        return Puntaje_Total;
    }

    public static void Resultado_Torneo(int[] Jugadores) {
        System.out.println("Los resultados son: ");
        for (int i = 0; i < Jugadores.length; i++) {
            System.out.println("El puntaje total del jugador " + (i + 1) + " es: " + Jugadores[i]);
        }
    }

    public static void Puntuacion_Alta(int[] Jugadores) {
        int Maximo_Puntaje = Jugadores[0];
        int Jugador_Ganador = 1;

        for (int i = 1; i < Jugadores.length; i++) { // Comenzamos en 1 para evitar errores
            if (Jugadores[i] > Maximo_Puntaje) {
                Maximo_Puntaje = Jugadores[i];
                Jugador_Ganador = i + 1;
            }
        }

        System.out.println("El Jugador con la puntuación más alta es: Jugador " + Jugador_Ganador + " con " + Maximo_Puntaje + " puntos");
    }

    public static void Verificar_Jugadores(int Cantidad_Jugadores) {
        if (Cantidad_Jugadores > 10 || Cantidad_Jugadores < 1) {
            System.out.println("Digite una cantidad válida de jugadores (1-10)");
            System.exit(0);
        }
    }

    public static void Verificar_Rondas(int Cantidad_Rondas) {
        if (Cantidad_Rondas > 5 || Cantidad_Rondas < 1) {
            System.out.println("Digite una cantidad válida de rondas (1-5)");
            System.exit(0);
        }
    }
}