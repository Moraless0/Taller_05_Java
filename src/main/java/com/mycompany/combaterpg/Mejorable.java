/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.combaterpg;

public interface Mejorable {

    void subirNivel();

    default void mostrarMensajeNivel(int nivel) {
        System.out.println("*** ¡Alcanzó el nivel " + nivel + "! ***");
    }
}
