/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

import java.util.Scanner;

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
            System.out.println("1. Crear Personaje 1");
            System.out.println("2. Crear Personaje 2");
            System.out.println("3. Ver ficha técnica de los personajes");
            System.out.println("4. Subir de nivel a un personaje");
            System.out.println("5. Curar a un personaje");
            System.out.println("6. Realizar un ataque básico");
            System.out.println("7. Usar habilidad especial");
            System.out.println("8. Iniciar Batalla Automática (P1 vs P2)");
            System.out.println("9. Ver total de personajes creados");
            System.out.println("10. Salir");
            System.out.println("===========================================");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Validación para evitar errores si no ingresa un número entero
                System.out.println("Error: debe ingresar un número entero");
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    p1 = crearPersonaje(scanner, 1);
                    break;

                case 2:
                    p2 = crearPersonaje(scanner, 2);
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
                    int personajeSubir;
                    try {
                        personajeSubir = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // Validación para evitar errores si no ingresa un número entero
                        System.out.println("Error: debe ingresar un número entero");
                        personajeSubir = 0;
                    }
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
                    int personajeCurar;
                    try {
                        personajeCurar = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // Validación para evitar errores si no ingresa un número entero
                        System.out.println("Error: debe ingresar un número entero");
                        personajeCurar = 0;
                    }
                    if (personajeCurar == 1 && p1 != null) {
                        Batalla.intentarCurar(p1);
                    } else if (personajeCurar == 2 && p2 != null) {
                        Batalla.intentarCurar(p2);
                    } else {
                        System.out.println("Opción no válida o personaje no creado");
                    }
                    break;

                case 6:
                    System.out.print("¿Quién ataca a quién? (1 ataca a 2, o 2 ataca a 1): ");
                    int ataqueOpcion;
                    try {
                        ataqueOpcion = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // Validación para evitar errores si no ingresa un número entero
                        System.out.println("Error: debe ingresar un número entero");
                        ataqueOpcion = 0;
                    }
                    if (ataqueOpcion == 1 && p1 != null && p2 != null) {
                        if (!p1.estaVivo()) {
                            System.out.println(p1.nombre + " está derrotado y no puede atacar");
                        } else {
                            p1.atacar(p2);
                            if (!p2.estaVivo()) {
                                System.out.println(p2.nombre + " ha sido derrotado");
                            }
                        }
                    } else if (ataqueOpcion == 2 && p1 != null && p2 != null) {
                        if (!p2.estaVivo()) {
                            System.out.println(p2.nombre + " está derrotado y no puede atacar");
                        } else {
                            p2.atacar(p1);
                            if (!p1.estaVivo()) {
                                System.out.println(p1.nombre + " ha sido derrotado");
                            }
                        }
                    } else {
                        System.out.println("Opción no válida o personajes no creados");
                    }
                    break;

                case 7:
                    System.out.print("¿Quién usa habilidad especial contra quién? (1 contra 2, o 2 contra 1): ");
                    int habilidadOpcion;
                    try {
                        habilidadOpcion = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        // Validación para evitar errores si no ingresa un número entero
                        System.out.println("Error: debe ingresar un número entero");
                        habilidadOpcion = 0;
                    }
                    if (habilidadOpcion == 1 && p1 != null && p2 != null) {
                        if (!p1.estaVivo()) {
                            System.out.println(p1.nombre + " está derrotado y no puede usar habilidades");
                        } else {
                            p1.habilidadEspecial(p2);
                            if (!p2.estaVivo()) {
                                System.out.println(p2.nombre + " ha sido derrotado");
                            }
                        }
                    } else if (habilidadOpcion == 2 && p1 != null && p2 != null) {
                        if (!p2.estaVivo()) {
                            System.out.println(p2.nombre + " está derrotado y no puede usar habilidades");
                        } else {
                            p2.habilidadEspecial(p1);
                            if (!p1.estaVivo()) {
                                System.out.println(p1.nombre + " ha sido derrotado");
                            }
                        }
                    } else {
                        System.out.println("Opción no válida o personajes no creados");
                    }
                    break;

                case 8:
                    if (p1 != null && p2 != null && p1.estaVivo() && p2.estaVivo()) {
                        Batalla.iniciarPeleaAutomatica(p1, p2);
                    } else {
                        System.out.println("Ambos personajes deben existir y estar vivos para iniciar la batalla");
                    }
                    break;

                case 9:
                    System.out.println("Total de personajes creados: " + Personaje.getTotalPersonajesCreados());
                    break;

                case 10:
                    System.out.println("Gracias por usar el simulador de combate RPG. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida");
            }
            System.out.println();
        } while (opcion != 10);

        scanner.close();
    }

    // Método auxiliar para crear un personaje - usa polimorfismo por referencia
    private static Personaje crearPersonaje(Scanner scanner, int numeroPersonaje) {
        System.out.println("Seleccione el tipo de personaje:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Opción: ");
        int tipo;
        try {
            tipo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: debe ingresar un número entero");
            return null;
        }

        System.out.print("¿Usar constructor predeterminado? (s/n): ");
        String constructorTipo = scanner.nextLine();

        if (constructorTipo.equalsIgnoreCase("s")) {
            // Constructor predeterminado
            switch (tipo) {
                case 1:
                    System.out.println("Personaje " + numeroPersonaje + " creado: Guerrero");
                    return new Guerrero();
                case 2:
                    System.out.println("Personaje " + numeroPersonaje + " creado: Mago");
                    return new Mago();
                case 3:
                    System.out.println("Personaje " + numeroPersonaje + " creado: Arquero");
                    return new Arquero();
                default:
                    System.out.println("Tipo no válido");
                    return null;
            }
        } else {
            // Constructor parametrizado
            System.out.print("Ingrese el nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese la vida máxima: ");
            double vidaMax;
            try {
                vidaMax = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Validación para evitar errores si no ingresa un número
                System.out.println("Error: debe ingresar un número");
                return null;
            }
            System.out.print("Ingrese el ataque: ");
            double ataque;
            try {
                ataque = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Validación para evitar errores si no ingresa un número
                System.out.println("Error: debe ingresar un número");
                return null;
            }
            System.out.print("Ingrese la defensa: ");
            double defensa;
            try {
                defensa = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Validación para evitar errores si no ingresa un número
                System.out.println("Error: debe ingresar un número");
                return null;
            }

            switch (tipo) {
                case 1:
                    System.out.print("Ingrese el escudo: ");
                    double escudo;
                    try {
                        escudo = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar un número");
                        return null;
                    }
                    System.out.println("Personaje " + numeroPersonaje + " creado: Guerrero");
                    return new Guerrero(nombre, vidaMax, ataque, defensa, escudo);
                case 2:
                    System.out.print("Ingrese el maná: ");
                    double mana;
                    try {
                        mana = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar un número");
                        return null;
                    }
                    System.out.println("Personaje " + numeroPersonaje + " creado: Mago");
                    return new Mago(nombre, vidaMax, ataque, defensa, mana);
                case 3:
                    System.out.print("Ingrese la precisión (0-100): ");
                    int precision;
                    try {
                        precision = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Error: debe ingresar un número entero");
                        return null;
                    }
                    System.out.println("Personaje " + numeroPersonaje + " creado: Arquero");
                    return new Arquero(nombre, vidaMax, ataque, defensa, precision);
                default:
                    System.out.println("Tipo no válido");
                    return null;
            }
        }
    }
}
