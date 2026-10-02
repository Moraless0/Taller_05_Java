/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

import java.util.Scanner;

/**
 *
 * @author abdielmorales
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personaje p1 = null;
        Personaje p2 = null;
        int opcion;

        do {
            System.out.println("===========================================");
            System.out.println("SIMULADOR DE COMBATE RPG");
            System.out.println("===========================================");
            System.out.println("1. Crear Personaje 1 (Constructor Predeterminado)");
            System.out.println("2. Crear Personaje 2 (Constructor Parametrizado)");
            System.out.println("3. Ver ficha técnica de los personajes");
            System.out.println("4. Subir de nivel a un personaje");
            System.out.println("5. Curar a un personaje");
            System.out.println("6. Realizar un ataque individual");
            System.out.println("7. Iniciar Batalla Automática (P1 vs P2)");
            System.out.println("8. Ver total de personajes creados en el sistema");
            System.out.println("9. Salir");
            System.out.println("===========================================");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    p1 = new Personaje();
                    System.out.println("Personaje 1 creado con constructor predeterminado");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la vida máxima: ");
                    double vidaMax = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese el ataque: ");
                    double ataque = Double.parseDouble(scanner.nextLine());
                    System.out.print("Ingrese la defensa: ");
                    double defensa = Double.parseDouble(scanner.nextLine());
                    p2 = new Personaje(nombre, vidaMax, ataque, defensa);
                    System.out.println("Personaje 2 creado con constructor parametrizado");
                    break;

                case 3:
                    if (p1 == null) {
                        System.out.println("Personaje 1 no ha sido creado");
                    } else {
                        System.out.println("--- Ficha de Personaje 1 ---");
                        p1.mostrarEstado();
                    }
                    if (p2 == null) {
                        System.out.println("Personaje 2 no ha sido creado");
                    } else {
                        System.out.println("--- Ficha de Personaje 2 ---");
                        p2.mostrarEstado();
                    }
                    break;

                case 4:
                    System.out.print("¿A qué personaje desea subir de nivel? (1 o 2): ");
                    int personajeSubir = Integer.parseInt(scanner.nextLine());
                    if (personajeSubir == 1 && p1 != null) {
                        p1.subirNivel();
                    } else if (personajeSubir == 2 && p2 != null) {
                        p2.subirNivel();
                    } else {
                        System.out.println("Opción no válida o personaje no creado");
                    }
                    break;

                case 5:
                    System.out.print("¿A qué personaje desea curar? (1 o 2): ");
                    int personajeCurar = Integer.parseInt(scanner.nextLine());
                    if (personajeCurar == 1 && p1 != null) {
                        p1.curar();
                    } else if (personajeCurar == 2 && p2 != null) {
                        p2.curar();
                    } else {
                        System.out.println("Opción no válida o personaje no creado");
                    }
                    break;

                case 6:
                    System.out.print("¿Quién ataca a quién? (1 ataca a 2, o 2 ataca a 1): ");
                    int ataqueOpcion = Integer.parseInt(scanner.nextLine());
                    if (ataqueOpcion == 1 && p1 != null && p2 != null) {
                        p1.atacar(p2);
                        if (!p2.estaVivo()) {
                            System.out.println(p2.nombre + " ha sido derrotado");
                        }
                    } else if (ataqueOpcion == 2 && p1 != null && p2 != null) {
                        p2.atacar(p1);
                        if (!p1.estaVivo()) {
                            System.out.println(p1.nombre + " ha sido derrotado");
                        }
                    } else {
                        System.out.println("Opción no válida o personajes no creados");
                    }
                    break;

                case 7:
                    if (p1 != null && p2 != null && p1.estaVivo() && p2.estaVivo()) {
                        Batalla.iniciarPeleaAutomatica(p1, p2);
                    } else {
                        System.out.println("Ambos personajes deben existir y estar vivos para iniciar la batalla");
                    }
                    break;

                case 8:
                    System.out.println("Total de personajes creados: " + Personaje.getTotalPersonajesCreados());
                    break;

                case 9:
                    System.out.println("Gracias por usar el simulador de combate RPG. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
            System.out.println();
        } while (opcion != 9);

        scanner.close();
    }
}
