/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

public class Batalla {

    // Ejecuta un ataque crítico con multiplicador
    public static void ejecutarAtaqueCritico(Personaje atacante, Personaje objetivo, double multiplicador) {
        double ataquePotenciado = atacante.puntosAtaque * multiplicador;
        int danoCritico = (int) ataquePotenciado;
        objetivo.recibirDano(danoCritico);
        System.out.println("¡Golpe Crítico! " + atacante.nombre + " ha causado " + danoCritico + " de daño a " + objetivo.nombre);
    }

    // Intenta curar a un personaje si implementa la interface Curable
    // Usa instanceof para verificar capacidades del objeto
    public static void intentarCurar(Personaje p) {
        if (p instanceof Curable) {
            Curable curable = (Curable) p;
            curable.curar();
        } else {
            System.out.println(p.nombre + " no puede curarse (no implementa Curable).");
        }
    }

    // Inicia una pelea automática entre dos personajes
    // Usa polimorfismo - los métodos atacar() y habilidadEspecial() se ejecutan según el tipo real del objeto
    public static void iniciarPeleaAutomatica(Personaje p1, Personaje p2) {
        System.out.println("--- BATALLA AUTOMÁTICA ---");

        int turno = 1;

        while (p1.estaVivo() && p2.estaVivo()) {
            System.out.println("Turno " + turno);

            // Turno de p1
            if (turno % 3 == 0) {
                p1.habilidadEspecial(p2);
            } else {
                p1.atacar(p2);
            }

            // Turno de p2 si sigue vivo
            if (p2.estaVivo()) {
                if (turno % 3 == 0) {
                    p2.habilidadEspecial(p1);
                } else {
                    p2.atacar(p1);
                }
            }

            turno++;
        }

        // Determinar ganador usando getTipo() - polimorfismo
        if (p1.estaVivo()) {
            System.out.println(">>> El ganador es: " + p1.nombre + " (" + p1.getTipo() + ")");
        } else {
            System.out.println(">>> El ganador es: " + p2.nombre + " (" + p2.getTipo() + ")");
        }
    }
}
