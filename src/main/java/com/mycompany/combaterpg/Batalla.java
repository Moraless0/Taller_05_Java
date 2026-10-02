/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.combaterpg;

/**
 *
 * @author abdielmorales
 */
public class Batalla {

    public static void ejecutarAtaqueCritico(Personaje atacante, Personaje objetivo, double multiplicador) {
        double ataquePotenciado = atacante.puntosAtaque * multiplicador;
        int danoCritico = (int) ataquePotenciado;
        objetivo.recibirDano(danoCritico);
        System.out.println("¡Golpe Crítico! " + atacante.nombre + " ha causado " + danoCritico + " de daño a " + objetivo.nombre);
    }

    public static void iniciarPeleaAutomatica(Personaje p1, Personaje p2) {
        while (p1.estaVivo() && p2.estaVivo()) {
            p1.atacar(p2);
            if (p2.estaVivo()) {
                p2.atacar(p1);
            }
        }

        if (p1.estaVivo()) {
            System.out.println(p1.nombre + " ha ganado la batalla");
        } else {
            System.out.println(p2.nombre + " ha ganado la batalla");
        }
    }
}
